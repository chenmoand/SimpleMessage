package com.brageast.util.player;

import org.bukkit.entity.Player;

public class PlayerStatus {
	private Player p ;
	private String str;
	public PlayerStatus(Player p, String str) {
		this.p = p;
		this.str = str;
		p.getWorld().getName();
	}

	public String getStatus() {
		String vlaue = str.replace("!", "");
		switch (vlaue) {
		case "player_name":
			return p.getName();
		case "player_health":
			return p.getHealth()+"";
		case "player_exp":
			return p.getExp()+"";
		case "player_gamemode":
			return p.getGameMode().getValue()+"";
		case "player_isfly":
			return p.isFlying()+"";
		case "player_worldname":
			return p.getWorld().getName();
		case "tpa_time_wait":
			return  "0";
		default:
			return "[?]";
		}
	}
}
