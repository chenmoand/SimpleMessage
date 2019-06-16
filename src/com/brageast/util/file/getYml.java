package com.brageast.util.file;

import org.bukkit.configuration.file.YamlConfiguration;

public class getYml {
	private static YamlConfiguration config;
	private static YamlConfiguration msg;
	public getYml() {}
	public static void append(YamlConfiguration config, YamlConfiguration msg) {
		getYml.config = config;
		getYml.msg = msg;
	}
	public static YamlConfiguration getConfig() {
		return config;
	}
	public static void setConfig(YamlConfiguration config) {
		getYml.config = config;
	}
	public static YamlConfiguration getMsg() {
		return msg;
	}
	public static void setMsg(YamlConfiguration msg) {
		getYml.msg = msg;
	}
}
