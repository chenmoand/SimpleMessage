package com.brageast.util;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.brageast.util.file.getYml;

public class doTransfer {
	private BukkitTask r;
	
	public static HashMap<String,Integer> pstatus = new HashMap<String,Integer>();
	//玩家状态 1代表有请求 0 代表没 2 代表同意 3代表拒绝
//	public static HashMap<String,Boolean>  fqz = new HashMap<String,Boolean>();
	//判断发起者
	public void run(Player p1, Player p2) {
		pstatus.put(p1.getDisplayName(), 1);
		pstatus.put(p2.getDisplayName(), 1);
		int i = pstatus.get(p2.getDisplayName());
		r = new BukkitRunnable() {
			public void run() {
				
				p1.teleport(p2.getLocation());
			}
		}.runTaskLaterAsynchronously(AnnouncementTiming.plugin, getYml.getConfig().getLong("tpa.WaitingTime") * 20L);
	}
	public void stop() {
		r.cancel();
	}
}
