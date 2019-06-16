package com.brageast.listener;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.brageast.util.Action;
import com.brageast.util.JsonMessage;
import com.brageast.util.doTransfer;

public class onPlay implements Listener {
	private YamlConfiguration config;
	private YamlConfiguration msg;
	public onPlay(YamlConfiguration config, YamlConfiguration msg) {
		this.config = config;
		this.msg = msg;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		doTransfer.pstatus.put(p.getDisplayName(), 0);

	}
}
