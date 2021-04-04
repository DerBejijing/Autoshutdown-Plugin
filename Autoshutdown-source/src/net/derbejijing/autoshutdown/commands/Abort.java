package net.derbejijing.autoshutdown.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.derbejijing.autoshutdown.Main;
import net.derbejijing.autoshutdown.Utils.Utilities;

public class Abort implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String prefix = Main.instance.Prefix;
		
		if(sender.hasPermission(Main.instance.permissionAbort)) {
			if(Main.instance.active) {
				Main.instance.getConfig().set("active", false);
				
				Main.instance.saveConfig();
				
				Main.instance.active = false;
				
				Utilities.broadcast(ChatColor.GRAY + "Shutdown aborted!");
				
				return true;
			} else {
				sender.sendMessage(prefix + ChatColor.RED + " Shutdown already inactive");
			}
		} else sender.sendMessage(prefix + " " + Main.instance.noPermission);
		return false;
	}

}
