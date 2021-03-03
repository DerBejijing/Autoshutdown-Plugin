package net.derbejijing.autoshutdown.listener;

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
		
		player.sendMessage(prefix + " §7Server is running §aDer_Bejijing's Autoshutdown plugin");
		
		if(Main.instance.active) {
			if(Main.instance.publicShutdown) player.sendMessage(prefix + " §7Shutdown scheduled at " + shutdown);
		} else {
			player.sendMessage(prefix + " §7No shutdown active");
		}
	}
	
}
