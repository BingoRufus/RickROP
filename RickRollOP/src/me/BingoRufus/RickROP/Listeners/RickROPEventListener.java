package me.BingoRufus.RickROP.Listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.BingoRufus.RickROP.Main;
import me.BingoRufus.RickROP.RickRoll;
import net.md_5.bungee.api.ChatColor;

public class RickROPEventListener implements Listener {
	Main main;
	List<String> BlockedMessages;
	String[][] Replacements;

	public RickROPEventListener(Main m, List<String> blocked, String[][] replaces) {
		main = m;
		BlockedMessages = blocked;
		Replacements = replaces;

	}

	@EventHandler()
	public void AskForOp(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String Message = e.getMessage().toLowerCase();

		if (p.hasPermission("rickrop.exclude"))
			return;

		try {
			for (String[] ReplaceSet : Replacements) {
				if (Message.contains(ReplaceSet[0].toLowerCase())) {
					Message = Message.replaceAll(ReplaceSet[0].toLowerCase(), ReplaceSet[1].toLowerCase());
					continue;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		Message = Message.replaceAll("[^a-zA-Z0-9]", "");
		for (String Blocked : BlockedMessages) {
			Message = Message.replaceAll(" ", "");
			Blocked = Blocked.toLowerCase().replaceAll(" ", "");
			if (Message.contains(Blocked) || Message.toLowerCase().equalsIgnoreCase(Blocked)) {
				p.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[Server: Made " + p.getName()
						+ " a server operator]");
				e.setCancelled(true);
				Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
					public void run() {
						new RickRoll(main, p);
						return;
					}
				}, 50L);
				return;
			}
		}

	}
}
