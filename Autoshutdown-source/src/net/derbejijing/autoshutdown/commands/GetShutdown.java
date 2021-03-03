package net.derbejijing.autoshutdown.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.derbejijing.autoshutdown.Main;

public class GetShutdown implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage(Main.instance.Prefix + " §7Shutdown is scheduled at [§c" + Main.instance.shutdown + "§7]");
		return true;
	}

}
