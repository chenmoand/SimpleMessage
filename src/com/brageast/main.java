package com.brageast;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.brageast.listener.onPlay;
import com.brageast.util.AnnouncementTiming;
import com.brageast.util.get;

public class main extends JavaPlugin{
	
	public void onEnable() {
//		System.out.println("启动了?????");
		YamlConfiguration config = createYmlFile("config.yml");
		YamlConfiguration msg = createYmlFile("msg.yml");
		get.msg(msg);
//		Bukkit.getPluginManager().registerEvents(new onPlay(config, msg), this);
		new AnnouncementTiming(this, config);
	}
	public void onDisable() {
//		System.out.println("关闭了?????");
    }
	public YamlConfiguration createYmlFile(String name) {
		YamlConfiguration file;
		File f = new File(this.getDataFolder(), name);
		if(f.exists()) {
			getLogger().info("正在加载"+name);
			file = YamlConfiguration.loadConfiguration(f);
		} else {
			getLogger().info("没有找到"+name+",正在创建");
			saveResource(name, true);
			file = YamlConfiguration.loadConfiguration(f);
		}
		return file;
	}
}
