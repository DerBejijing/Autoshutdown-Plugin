package net.derbejijing.autoshutdown.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.derbejijing.autoshutdown.Main;
import net.derbejijing.autoshutdown.Utils.Utilities;

public class Enable implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String prefix = Main.instance.Prefix;
		
		if(sender.hasPermission(Main.instance.permissionAbort)) {
			if(!Main.instance.active) {
				Main.instance.getConfig().set("active", true);
				
				Main.instance.saveConfig();
				
				Main.instance.active = true;
				
				Utilities.broadcast(ChatColor.GRAY + "Shutdown enabled and scheduled at [§c" + Main.instance.shutdown + "§7]!");
				
				return true;
			} else {
				sender.sendMessage(prefix + ChatColor.RED + " Shutdown already enabled");
			}
		} else sender.sendMessage(prefix + " " + Main.instance.noPermission);
		return false;
	}

}
