package net.derbejijing.autoshutdown.Utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.derbejijing.autoshutdown.Main;

public class Utilities {

	public static void broadcast(String msg) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(Main.instance.Prefix + " " + msg);
		}
		
		Main.instance.logger.info(msg);
	}
	
	public static LocalDateTime convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
}
