package com.brageast.util;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.brageast.util.file.getYml;
import com.brageast.util.player.Ez;

public class doDecision {
	private BukkitTask r;
	private YamlConfiguration config = getYml.getConfig();
	private int i = config.getInt("tpa.EffectiveTime");
	private boolean b = config.getBoolean("tpa.msg.remind.enable");
	private int tpamsgtime = config.getInt("tpa.msg.remind.time");
	public void run(Player p1, Player p2) {
		long lo = (long)i;
		r = new BukkitRunnable() {
			int time = i;
			public void run() {
				//同意
				if(doTransfer.pstatus.get(p2.getDisplayName()) == 2) {
					setStatus(0);
					p1.sendMessage("§l"+p2.getDisplayName()+"同意了tpa邀请");
					p2.sendMessage("§l你同意了tpa邀请");
					new doTransfer().run(p1, p2);
					cancel();
				}
				//拒绝
				if(doTransfer.pstatus.get(p2.getDisplayName()) == 3) {
					setStatus(0);
					p1.sendMessage("§l"+p2.getDisplayName()+"拒绝了tpa邀请");
					p2.sendMessage("§l你拒绝了tpa邀请");
					cancel();
				}
				//过期了
				if(time == 1) {
					setStatus(0);
					Ez.info.get("pastdue").say(p2).say(p1);
					cancel();
				}
				//提醒
				if(b) {
					if(time % tpamsgtime == 0) {
						Ez.info.get("remind.xiaoxi").say(p2);
					}
				}
//				System.out.println("111");
				time--;
				
			}
			public void setStatus(int i) {
				doTransfer.pstatus.replace(p1.getDisplayName(), i);
				doTransfer.pstatus.replace(p2.getDisplayName(), i);
			}
		}.runTaskTimerAsynchronously(AnnouncementTiming.plugin, 0L, 20L);
	}
	
	public void run2(Player p1, Player p2) {
		long lo = (long)i;
		r = new BukkitRunnable() {
			int time = i;
			public void run() {
				//同意
				if(doTransfer.pstatus.get(p2.getDisplayName()) == 2) {
					setStatus(0);
					p1.sendMessage("§l"+p2.getDisplayName()+"同意了tpa邀请");
					p2.sendMessage("§l你同意了tpa邀请");
					new doTransfer().run(p2, p1);
					cancel();
				}
				//拒绝
				if(doTransfer.pstatus.get(p2.getDisplayName()) == 3) {
					setStatus(0);
					p1.sendMessage("§l"+p2.getDisplayName()+"拒绝了tpa邀请");
					p2.sendMessage("§l你拒绝了tpa邀请");
					cancel();
				}
				//过期了
				if(time == 1) {
					setStatus(0);
					Ez.info.get("pastdue").say(p2).say(p1);
					cancel();
				}
				//提醒
				if(b) {
					if(time % tpamsgtime == 0) {
						Ez.info.get("remind.xiaoxi").say(p2);
					}
				}
//				System.out.println("111");
				time--;
				
			}
			public void setStatus(int i) {
				doTransfer.pstatus.replace(p1.getDisplayName(), i);
				doTransfer.pstatus.replace(p2.getDisplayName(), i);
			}
		}.runTaskTimerAsynchronously(AnnouncementTiming.plugin, 0L, 20L);
	}
	public void stop() {
		r.cancel();
	}
}
