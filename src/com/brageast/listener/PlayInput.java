package com.brageast.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayInput implements Listener {
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().startsWith("/tpa")) {
			e.setMessage(e.getMessage().replace("/tpa", "/smt a"));
			
		} else if(e.getMessage().startsWith("/tpahere")) {
			e.setMessage(e.getMessage().replace("/tpahere", "/smt invite"));
		}
	}
}
