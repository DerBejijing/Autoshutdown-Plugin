package net.derbejijing.autoshutdown.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.derbejijing.autoshutdown.Main;

public class PlayerListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String prefix = Main.instance.Prefix;
		String shutdown = Main.instance.shutdown;
		
		player.sendMessage(prefix + ChatColor.GRAY +" Server is running " + ChatColor.GREEN + "§aDer_Bejijing's Autoshutdown plugin");
		
		if(Main.instance.active) {
			player.sendMessage(prefix + ChatColor.GRAY + " Shutdown scheduled at [" + ChatColor.RED + shutdown + ChatColor.GRAY + "]");
		} else {
			player.sendMessage(prefix + ChatColor.GRAY + " No shutdown active");
		}
	}
	
}
