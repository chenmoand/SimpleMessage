package com.brageast;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.brageast.Command.SmCmd;
import com.brageast.util.AnnouncementTiming;
import com.brageast.util.get;
import com.brageast.util.papi;

public class main extends JavaPlugin {
//	private File f = this.getDataFolder();
	private YamlConfiguration config;
	private YamlConfiguration msg;
	public void onEnable() {
//		isPapi();
		onCreateYmlFile();
		get.msg(msg);
		AnnouncementTiming.setAtime(this, config);
		Bukkit.getPluginCommand("smsg").setExecutor(new SmCmd(config, msg));
//		Bukkit.getPluginManager().registerEvents(new onPlay(config, msg), this);
		
	}
	public void onDisable() {
//		System.out.println("关闭了?????");

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
