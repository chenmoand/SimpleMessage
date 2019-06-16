package com.brageast.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brageast.util.AnnouncementTiming;

public class SmCmd implements CommandExecutor {
private final String title = "§7[§3simplemessage§7]§a";
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender.hasPermission("simplemessage.use")) {
			if(args[0].equals("reload")) {
				AnnouncementTiming.stop();
				sender.sendMessage(title + " §b》§7  重载成功");
			} else {
				onHelp(sender);
			}
		} else {
			onHelp(sender);
		}
		return true;
	}
	public void onHelp(CommandSender sender) {
		sender.sendMessage("§6---§a---------§7[§3simplemessage§7]§a---------§6---");
		sender.sendMessage("§b》§7/smsg 打开帮助菜单");
		sender.sendMessage("§b》§7/smsg reload 重启插件");
	}

}
