package com.brageast.util;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class AnnouncementTiming {
	private BukkitTask r;
	private YamlConfiguration config;
	private long time;
	private int i = 1;
	private int t = 1;
	private HashMap<Integer, JsonMessage> m2 = new HashMap<>();
			
	public AnnouncementTiming(Plugin plugin, YamlConfiguration config) {
		this.config = config;
		this.time = this.config.getLong("Time") > 0L ? this.config.getLong("Time") : 1L;
//		JsonMessage j = get.sj.get("demo").append(get.sj.get("demo2"));
		getJsonMessages();
		this.r = new BukkitRunnable() {
			
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
//					j.say(p);
//					System.out.println(i);
					if(i < t) {
						t = 1;
						m2.get(t).say(p);
					} else {
						m2.get(t).say(p);
						t++;
					}
//					m2.get(2).say(p);
					
//					System.out.println(config.getString("Message.1"));
//					System.out.println(m2);
//					System.out.println(get.sj);
				}
			}
		}.runTaskTimerAsynchronously(plugin, 0L, time * 10L);
	}
	public void getJsonMessages() {
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
	public void onProcessing(String s, int i2) {
		
		JsonMessage jms = new JsonMessage("");
		String[] strarray = s.split(",");
		
		for(String str : strarray) {
//			System.out.println(get.sj.get(str));
			jms.append(get.sj.get(str));
//			System.out.println(str);
		}
		
		m2.put(i2, jms);
	}
	public void stop() {
		r.cancel();
	}
}
