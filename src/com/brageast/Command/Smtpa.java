package com.brageast.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;

import com.brageast.util.JsonMessage;
import com.brageast.util.doDecision;
import com.brageast.util.doTransfer;

public class Smtpa implements CommandExecutor {
	private final String title = "§7[§3SimpleMessage§7]§a §4> §r";
//	private HashMap<String,Boolean> pstatus = new HashMap<String,Boolean>();
	
//	private Player p1;
//	private Player p2;
	//发起者 P1 接受者 P2;
	public Smtpa(YamlConfiguration config, YamlConfiguration msg) {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p1;
		if(!(sender instanceof Player)) {
			sendMessage(sender,"你不是个玩家哦");
			return true;
		} else if(!sender.hasPermission("simplemessage.use") || !sender.hasPermission("simplemessage.use.tpa")) {
			sendMessage(sender,"你没有权限啊");
			return true;
		} else if(args.length == 0) {
			p1 = (Player)sender;
//			p1.isPermissionSet(arg0)
			onHelp(p1);
			return true;
		} else {
			p1 = (Player)sender;
			switch (args[0]) {
			case "help":
				onHelp(p1);
				return true;
			case "a":
				if(args.length == 2) {
					onPlayerSend(args,p1);
				} else {
					onHelp(p1);
				}
				
				return true;
			case "agree":
				onAgree(p1);
				return true;
			case "disagree":
				onDisagree(p1);
				return true;
			case "invite":
				if(args.length == 2) {
					onInvite(args,p1);
				} else {
					onHelp(p1);
				}
				return true;
			default:
				onHelp(p1);
				return true;
			}
		}
	}
	private void onDisagree(Player p1) {
		if(doTransfer.pstatus.get(p1.getDisplayName()) == 1) {
			doTransfer.pstatus.replace(p1.getDisplayName(), 3);
		} else {
			p1.sendMessage("§l你并没有请求");
		}
		
	}

	public void onInvite(String[] args, Player p1) {
		Player p2 = Bukkit.getPlayer(args[1]);
		isNull(p1,p2);
		if(p2 == null) {
			sendMessage(p1, args[1]+"不在线或者不存在!");
		} else {
			Integer b = doTransfer.pstatus.get(p2.getDisplayName());
			Integer b2 = doTransfer.pstatus.get(p1.getDisplayName());
			if(args.length != 2) {
				sendMessage(p1, "您的指令不正确,正确格式/tpa Player:!");
			} else if(p1 == p2) {
				sendMessage(p1, "你不能跟自己交易!");
			} else if(b != 0 || b2 != 0) {
				sendMessage(p1, p2.getDisplayName() + "有请求ing,或者您有请求");
			} else {
				doTransfer.pstatus.put(p1.getDisplayName(), 1);
				doTransfer.pstatus.put(p2.getDisplayName(), 1);
				p1.sendMessage("§l成功发送请求");
				new doDecision().run2(p1, p2);
			}
		}
		
	}

	public void onAgree(Player p1) {
		if(doTransfer.pstatus.get(p1.getDisplayName()) == 1) {
			doTransfer.pstatus.replace(p1.getDisplayName(), 2);
		} else {
			p1.sendMessage("§l你并没有请求");
		}
		
	}

	public void onPlayerSend(String[] args, Player p1) {

		Player p2 = Bukkit.getPlayer(args[1]);
		isNull(p1,p2);
		if(p2 == null) {
			sendMessage(p1, args[1]+"不在线或者不存在!");
		} else {
			Integer b = doTransfer.pstatus.get(p2.getDisplayName());
			Integer b2 = doTransfer.pstatus.get(p1.getDisplayName());
			if(args.length != 2) {
				sendMessage(p1, "您的指令不正确,正确格式/tpa Player:!");
			} else if(p1 == p2) {
				sendMessage(p1, "你不能跟自己交易!");
			} else if(b != 0 || b2 != 0) {
				sendMessage(p1, p2.getDisplayName() + "有请求ing,或者您有请求");
			} else {
				doTransfer.pstatus.put(p1.getDisplayName(), 1);
				doTransfer.pstatus.put(p2.getDisplayName(), 1);
				p1.sendMessage("§l成功发送请求");
				new doDecision().run(p1, p2);
			}
		}
		
	}
	public void isNull(Player p1, Player p2) {
		if(doTransfer.pstatus.get(p1.getDisplayName()) == null) {
			doTransfer.pstatus.put(p1.getDisplayName(), 0);
		}
		if(doTransfer.pstatus.get(p2.getDisplayName()) == null) {
			doTransfer.pstatus.put(p2.getDisplayName(), 0);
		}
	}
	public void sendMessage(Player p, String msg) {
		p.sendMessage(title+msg);
	}
	public void sendMessage(CommandSender s, String msg) {
		s.sendMessage(title+msg);
	}
	public void onHelp(Player p) {
		p.sendMessage("§m§a---§m§6--------§3 < "+ title +"§m§a--------§m§6---");
		new JsonMessage("&8/smt a [Player] 传送玩家,默认替换/tpa").
		setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tpa [Player]").
		setHoverEvent(HoverEvent.Action.SHOW_TEXT , "&6Tp传送莫个人!").say(p);
		new JsonMessage("&8/smt invite [Player]将玩家传送到你的位置,默认替换/tpahere!").
		setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/smt invite [Player]").
		setHoverEvent(HoverEvent.Action.SHOW_TEXT , "&6邀请莫个人!").say(p);
		new JsonMessage("&8/smt agree 同意请求!").
		setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/smt agree").
		setHoverEvent(HoverEvent.Action.SHOW_TEXT , "&6同意请求!").say(p);
		new JsonMessage("&8/smt disagree 拒绝请求!").
		setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/smt disagree").
		setHoverEvent(HoverEvent.Action.SHOW_TEXT , "&6拒绝请求!").say(p);
		
	}

}
