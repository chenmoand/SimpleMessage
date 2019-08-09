package com.brageast;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.brageast.Command.SmCmd;
import com.brageast.Command.Smtpa;
import com.brageast.listener.PlayInput;
import com.brageast.listener.onPlay;
import com.brageast.util.AnnouncementTiming;
import com.brageast.util.get;
import com.brageast.util.papi;
import com.brageast.util.file.getYml;
import com.brageast.util.player.Ez;
import com.brageast.util.player.bstats;

public class main extends JavaPlugin {
	private YamlConfiguration config;
	private YamlConfiguration msg;
	public void onEnable() {
		pluginReady();
		Bukkit.getPluginManager().registerEvents(new onPlay(config, msg), this);
		Bukkit.getPluginCommand("smsg").setExecutor(new SmCmd());
		if(config.getBoolean("tpa.switch") == false) {
			Bukkit.getPluginManager().registerEvents(new PlayInput(), this);
			Bukkit.getPluginCommand("smt").setExecutor(new Smtpa(config, msg));
			getLogger().info("插件自带tpa已经关闭,如需请在config中tpa.switch 改为true");
		}
		
	    
		
	}
	public void onDisable() {
//		System.out.println("关闭了?????");

    }
	public void pluginReady() {
		onCreateYmlFile();
		get.msg(msg);
		AnnouncementTiming.setAtime(this, config);
		getYml.append(config, msg);
		new bstats(this);
		Ez.Load();
	}
	public void onCreateYmlFile() {
		 config = createYmlFile("config.yml");
		 msg = createYmlFile("msg.yml");
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
	public void isPapi() {
		if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new papi().register();
		} else {
			getLogger().info("请安装PlaceholderAPI插件,否则部分功能将无法运行");
		}
	}
}
