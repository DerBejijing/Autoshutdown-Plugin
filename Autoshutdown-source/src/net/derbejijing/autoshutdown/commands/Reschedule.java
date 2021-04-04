package net.derbejijing.autoshutdown.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.derbejijing.autoshutdown.Main;
import net.derbejijing.autoshutdown.Utils.Utilities;

public class Reschedule implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String prefix = Main.instance.Prefix;
		
		if(sender.hasPermission(Main.instance.permissionReschedule)) {
			
			if(args.length == 1) {
				Main.instance.getConfig().set("shutdown", args[0]);
				
				Main.instance.saveConfig();
				
				Main.instance.shutdown = args[0];
				
				Main.instance.adjustShutdownDate();
				
				Utilities.broadcast(ChatColor.YELLOW + "Shutdown time changed to [" + ChatColor.RED + args[0] + ChatColor.YELLOW + "]!");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Invalid input");
			}
			
		} else sender.sendMessage(prefix + " " + Main.instance.noPermission);
		return false;
	}

}
