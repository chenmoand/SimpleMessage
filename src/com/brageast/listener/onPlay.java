package com.brageast.listener;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.brageast.util.Action;
import com.brageast.util.JsonMessage;

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
		new JsonMessage(config.getString("PlayJoin")).setHoverEvent(Action.getHoverEvent("SHOW_TEXT"), "&6哈哈哈")
		.append(config.getString("PlayJoin")).setHoverEvent(Action.getHoverEvent("SHOW_TEXT"), "&7哈哈哈").say(p);
	}
}
