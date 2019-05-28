package com.brageast.util;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class AnnouncementTiming {
	private static BukkitTask r;
	private static YamlConfiguration config;
	private static long time;
	private static int i = 1;
	private static int t = 1;
	private static HashMap<Integer, JsonMessage> m2 = new HashMap<>();
	private static Plugin plugin;
			
	public static void setAtime(Plugin plugin, YamlConfiguration config) {
		AnnouncementTiming.plugin = plugin;
		AnnouncementTiming.config = config;
		AnnouncementTiming.time = AnnouncementTiming.config.getLong("Time") > 0L ? AnnouncementTiming.config.getLong("Time") : 1L;
		run();
	}
	public static void run() {
		getJsonMessages();
		r = new BukkitRunnable() {
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(i < t) {
						t = 1;
						m2.get(t).say(p);
					} else {
						m2.get(t).say(p);
						t++;
					}
				}
			}
		}.runTaskTimerAsynchronously(plugin, 0L, time * 10L);
	}
	public static void getJsonMessages() {
				while(true) {
					String s = config.getString("Message." + i);
					onProcessing(s, i);
					if(config.getString("Message."  + (i+1)) == null) {
						break;
					}
					i++;
				}
	}
	//起名字困难户
	public static void onProcessing(String s, int i2) {
		
		JsonMessage jms = new JsonMessage();
		String[] strarray = s.split(",");
		
		for(String str : strarray) {
			if(str.startsWith("!")) {
				jms.append(str);
			}
			jms.append(get.sj.get(str));
		} 
		
		m2.put(i2, jms);
	}
	public static void stop() {
		//究极停止
//		r.cancel();
//		m2.clear();
//		get.sj.clear();

//		plugin.saveConfig();
//		plugin.reloadConfig();
		plugin.onDisable();
		plugin.onEnable();
//		plugin.en
	}
}
