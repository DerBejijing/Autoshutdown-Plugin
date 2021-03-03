package net.derbejijing.autoshutdown.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import net.derbejijing.autoshutdown.Main;

public class GetShutdown implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(Main.instance.publicShutdown) {
			sender.sendMessage(Main.instance.Prefix + " §7Shutdown is scheduled at [§c" + Main.instance.shutdown + "§7]");
			return true;
		} else if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage(Main.instance.Prefix + " §7Shutdown is scheduled at [§c" + Main.instance.shutdown + "§7]");
		} else {
			sender.sendMessage(Main.instance.Prefix + " " + Main.instance.noPermission);
		}
		return false;
	}

}
