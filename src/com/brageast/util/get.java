package com.brageast.util;

import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;

public class get {
	public static HashMap<String, JsonMessage> sj = new HashMap<>();
	public static void msg(YamlConfiguration msg) {
		for(String key : msg.getKeys(false)) {
			String k = key + ".";
			JsonMessage jm = new JsonMessage(msg.getString(k+"msg"));
			if(msg.getString(k+"cevent") != null) {
				jm.setClickEvent(Action.getClickEvent(msg.getString(k+"cevent")), msg.getString(k+"click"));
			}
			if(msg.getString((k+"hover")) != null) {
				jm.setHoverEvent(Action.getHoverEvent(msg.getString(k+"hover")), msg.getString(k+"hevent"));
			}
			sj.put(key, jm);
		}
	}
//	private String setPlaceholders(String str, YamlConfiguration msg) {
//		
////		PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayers(), msg.getString(str));
//		return str;
//	}

}
