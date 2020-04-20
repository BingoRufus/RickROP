package me.BingoRufus.RickROP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.BingoRufus.RickROP.Main;
import net.md_5.bungee.api.ChatColor;

public class NewVersionDisplayer implements Listener {
	private Main main;
	private String current;
	private String update;

	public NewVersionDisplayer(Main m, String CurrentVersion, String UpdateVersion) {
		this.main = m;
		this.current = CurrentVersion;
		this.update = UpdateVersion;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("rickrop.reload")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.main, new Runnable() {
				public void run() {
					p.sendMessage(
							ChatColor.GREEN + "RickROP is currently running " + ChatColor.BLUE + "v." + ChatColor.WHITE
									+ "" + ChatColor.BOLD + current + ChatColor.GREEN + " and should be updated to "
									+ ChatColor.BLUE + "v." + ChatColor.WHITE + "" + ChatColor.BOLD + update);
				}
			}, 3);

		}
	}

}
