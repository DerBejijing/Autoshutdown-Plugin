package net.derbejijing.autoshutdown.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.derbejijing.autoshutdown.Main;

public class GetShutdown implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage(Main.instance.Prefix + ChatColor.GRAY + " Shutdown is scheduled at [" + ChatColor.RED + Main.instance.shutdown + ChatColor.GRAY + "]");
		return true;
	}

}
