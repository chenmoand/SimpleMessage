package com.brageast.util.file;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import com.brageast.main;

//暂时不弄这个.....
public class YmlFile {
	private YamlConfiguration file;
	public YamlConfiguration create(File f, String name) {
		main m = new main();
		File f1 = new File(f, name);
		if(f1.exists()) {
			m.getLogger().info("正在加载"+name);
			file = YamlConfiguration.loadConfiguration(f1);
		} else {
			m.getLogger().info("没有找到"+name+",正在创建");
			
			m.saveResource(name, true);
			file = YamlConfiguration.loadConfiguration(f1);
		}
		return file;
	}
}
