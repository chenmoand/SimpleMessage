package com.brageast.util;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;

public class Action {
	//	点击动作
	public static ClickEvent.Action getClickEvent(String s) {
		switch (s) {
		case "OPEN_URL":
			//在用户的浏览器打开指定URL
			return ClickEvent.Action.OPEN_URL;
		case "OPEN_FILE":
			//在用户的电脑打开指定文件
			return ClickEvent.Action.OPEN_FILE;
		case "RUN_COMMAND":
			//让用户运行指令
			return ClickEvent.Action.RUN_COMMAND;
		case "SUGGEST_COMMAND":
			//在用户的输入框设置文字
			return ClickEvent.Action.SUGGEST_COMMAND;
		case "CHANGE_PAGE":
			//改变书本的页码
			return ClickEvent.Action.CHANGE_PAGE;
		default:
			return null;
		}
	}
	
	public static HoverEvent.Action getHoverEvent(String s){
		switch (s) {
		case "SHOW_TEXT":
			//显示一个文本
			return HoverEvent.Action.SHOW_TEXT;
		case "SHOW_ACHIEVEMENT":
			//显示一个成就及其介绍
			return HoverEvent.Action.SHOW_ACHIEVEMENT;
		case "SHOW_ITEM":
			//显示一个物品的名字和其他信息
			return HoverEvent.Action.SHOW_ITEM;
		case "SHOW_ENTITY":
			//显示一个实体的名字，ID和其他信息
			return HoverEvent.Action.SHOW_ENTITY;
		default:
			return null;
		}
	}

}
