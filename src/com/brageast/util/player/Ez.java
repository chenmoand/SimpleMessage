package com.brageast.util.player;

import java.util.HashMap;

import com.brageast.util.JsonMessage;
import com.brageast.util.get;
import com.brageast.util.file.getYml;

public class Ez {
	public static HashMap<String, JsonMessage> info = new HashMap<>();
	
	public static void append(String s, String s2) {
		
		JsonMessage jms = new JsonMessage();
		String[] strarray = s.split(",");
		
		for(String str : strarray) {
			if(str.startsWith("!")) {
				jms.append(str);
			}
			jms.append(get.sj.get(str));
		} 
		
		info.put(s2, jms);
	}
	public static void Load() {
		append(getYml.getConfig().getString("tpa.msg.remind.xiaoxi"), "remind.xiaoxi");
		append(getYml.getConfig().getString("tpa.msg.pastdue"), "pastdue");
	}
}
