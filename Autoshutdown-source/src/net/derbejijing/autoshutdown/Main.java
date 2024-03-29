package net.derbejijing.autoshutdown;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.derbejijing.autoshutdown.Utils.Utilities;
import net.derbejijing.autoshutdown.Utils.ShutdownThread;
import net.derbejijing.autoshutdown.commands.Abort;
import net.derbejijing.autoshutdown.commands.Enable;
import net.derbejijing.autoshutdown.commands.GetShutdown;
import net.derbejijing.autoshutdown.commands.Reschedule;
import net.derbejijing.autoshutdown.listener.PlayerListener;

public class Main extends JavaPlugin {

	public Logger logger;
	
	public List<Integer> shutdownWarnings;
	public String Prefix = ChatColor.GOLD + "[Autoshutdown]" + ChatColor.RESET;
	public String shutdown;
	public String noPermission = ChatColor.RED + "No permission to execute this command";
	
	public String permissionAbort = "autoshutdown.abort";
	public String permissionEnable = "autoshutdown.enable";
	public String permissionReschedule = "autoshutdown.reschedule";
	
	public boolean active = true;
	public boolean physicalShutdown;
	
	public int physicalShutdownDelay;
	
	public Date shutdownTime;
	public LocalDateTime shutdownDate;
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		logger = this.getLogger();
		
		this.getCommand("abort").setExecutor(new Abort());
		this.getCommand("enable").setExecutor(new Enable());
		this.getCommand("reschedule").setExecutor(new Reschedule());
		this.getCommand("getshutdown").setExecutor(new GetShutdown());
		
		this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		
		this.saveResource("config.yml", false);
		FileConfiguration config = this.getConfig();
		
		shutdown = config.getString("shutdown");
		shutdownWarnings = config.getIntegerList("shutdownWarnings");
		physicalShutdown = config.getBoolean("physicalShutdown");
		active = config.getBoolean("active");
		physicalShutdownDelay = config.getInt("physicalShutdownDelay");
		
		noPermission = config.getString("noPermission");
		permissionAbort = config.getString("permissionAbort");
		permissionEnable = config.getString("permissionEnable");
		permissionReschedule = config.getString("permissionReschedule");
		
		logger.info(Prefix + " Der_Bejijing's Autoshutdown loaded!");
		if(active) {
			logger.info(Prefix + " Shutdown at [" + ChatColor.RED + shutdown + ChatColor.RESET + "]");
			if(physicalShutdown) {
				logger.info(Prefix + " Machine will power-off after server shutdown");
			}
		} else {
			logger.info(Prefix + " No shutdown scheduled");
		}
		
		adjustShutdownDate();
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
		    @Override
		    public void run() {
		    	if(active) {
		    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		        	String date = dtf.format(LocalDateTime.now()).toString();
		        	
		        	if(date.equalsIgnoreCase(shutdown)) {
		        		if(physicalShutdown) {
		        			ShutdownThread st = new ShutdownThread();
		        			st.delay = physicalShutdownDelay;
		            		st.start();
		        		}
		        		
		        		getServer().shutdown();
		        	}
		        	
		        	for(int i = 0; i < shutdownWarnings.size(); i++) {
		        		if(date.equalsIgnoreCase(shutdownDate.minusSeconds(shutdownWarnings.get(i)).format(dtf))) {
		        			if(shutdownWarnings.get(i) <= 60) {
		        				Utilities.broadcast(ChatColor.YELLOW + "Shutdown in [" + ChatColor.RED + shutdownWarnings.get(i) +  ChatColor.YELLOW + "] second(s)");
		        			} else {
		        				Utilities.broadcast(ChatColor.YELLOW + "Shutdown in [" + ChatColor.RED + shutdownWarnings.get(i)/60 +  ChatColor.YELLOW + "] minutes");
		        			}
		        		}
		        	}
		    	}
		    }
		}, 0, 20);
	}
	
	public void adjustShutdownDate() {
		try {
			shutdownTime = new SimpleDateFormat("HH:mm:ss").parse(shutdown);
			shutdownDate = Utilities.convertToLocalDateViaInstant(shutdownTime);
		} catch(ParseException e) {
			
		}
	}
}
