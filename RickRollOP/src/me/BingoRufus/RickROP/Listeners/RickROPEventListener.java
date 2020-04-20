package me.BingoRufus.RickROP.Listeners;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.BingoRufus.RickROP.Main;
import me.BingoRufus.RickROP.Utils.RickRoll;
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
				e.getRecipients().clear();
				e.getRecipients().add(p);

				Bukkit.getScheduler().runTaskAsynchronously(main, new Runnable() {

					public void run() {
						if (main.getConfig().getBoolean("send-blocked-messages")) {
							for (Player player : Bukkit.getOnlinePlayers()) {
								if (player.hasPermission("rickrop.seeblocked")) {
									player.sendMessage(ChatColor.GRAY + ("[RickBlocked] "
											+ ChatColor.stripColor(e.getPlayer().getName()) + " > " + e.getMessage()));
								}
							}
						}
						try {
							TimeUnit.MILLISECONDS.sleep(main.getConfig().getLong("delays.sentmessage-and-op-message"));
						} catch (InterruptedException e2) {
						}
						p.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[Server: Made " + p.getName()
								+ " a server operator]");
						try {
							TimeUnit.MILLISECONDS.sleep(main.getConfig().getLong("delays.op-message-and-rickroll"));
						} catch (InterruptedException e3) {
						}
						new RickRoll(main, p);
					}

				});
			}

		}
	}
}
