package me.BingoRufus.RickROP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.BingoRufus.RickROP.Listeners.Commands;
import me.BingoRufus.RickROP.Listeners.CommandsTabCompleter;
import me.BingoRufus.RickROP.Listeners.NewVersionDisplayer;
import me.BingoRufus.RickROP.Listeners.RickROPEventListener;
import me.BingoRufus.RickROP.Utils.Metrics;
import me.BingoRufus.RickROP.Utils.RickRoll;
import me.BingoRufus.RickROP.Utils.UpdateChecker;

public class Main extends JavaPlugin implements Listener {
	public RickRoll play;
	NewVersionDisplayer NewVer;
	List<String> BlockedMessages = new ArrayList<String>();
	String[][] Replacements;

	public Main main;

	@Override
	public void onEnable() {

		new Metrics(this, 7239);
		main = this;
		this.saveDefaultConfig();
		this.reloadConfig();

		configReload();
		this.getCommand("rickrop").setExecutor(new Commands(this));
		this.getCommand("rickrop").setTabCompleter(new CommandsTabCompleter());

	}

	@Override
	public void onDisable() {

	}

	public void configReload() {

		this.saveDefaultConfig();
		this.reloadConfig();
		if (!BlockedMessages.isEmpty())
			BlockedMessages.clear();
		if (NewVer != null)
			HandlerList.unregisterAll(NewVer);
		if (!main.getConfig().getBoolean("disable-update-checking")) {
			new UpdateChecker(main, 76422).getLatestVersion(version -> {

				if (UpToDate(this.getDescription().getVersion().split("[.]"), version.split("[.]"))) {
					this.getLogger().info("RickROP is up to date");
				} else {

					this.getLogger().warning("RickROP is currently running version "
							+ main.getDescription().getVersion() + " and can be updated to " + version);
					this.getLogger().warning(
							"Download the newest version at: https://www.spigotmc.org/resources/rickrop.76422/");
					NewVer = new NewVersionDisplayer(this, this.getDescription().getVersion(), version);
					Bukkit.getPluginManager().registerEvents(NewVer, this);
				}
			});
		}

		BlockedMessages = getConfig().getStringList("blocked-messages");
		List<String> syns = getConfig().getStringList("synonyms");
		Replacements = new String[syns.size()][2];
		for (int length = 0; length < syns.size(); length++) {

			Replacements[length] = syns.get(length).split(":");

		}
		Bukkit.getPluginManager().registerEvents(new RickROPEventListener(main, BlockedMessages, Replacements), main);
	}

	public Boolean UpToDate(String cur[], String upd[]) {
		Integer[] CurrentVer = new Integer[3];
		Integer[] UpdateVer = new Integer[3];
		int lengthtouse = 0;
		if (cur.length < upd.length)
			lengthtouse = cur.length;
		if (cur.length > upd.length)
			lengthtouse = cur.length;
		if (cur.length == upd.length)
			lengthtouse = cur.length;
		for (int i = 0; i < lengthtouse; i++) {
			CurrentVer[i] = Integer.parseInt(cur[i]);
			UpdateVer[i] = Integer.parseInt(upd[i]);
		}
		if (CurrentVer.equals(UpdateVer)) {
			if (CurrentVer.length < UpdateVer.length)
				return false;
			return true;
		}

		if (CurrentVer[0] < UpdateVer[0])
			return false;
		if (CurrentVer[0] > UpdateVer[0])
			return true;
		// CurrentVer[0] has to be equal to UpdateVer[0]
		if (CurrentVer[1] < UpdateVer[1])
			return false;
		if (CurrentVer[1] > UpdateVer[1])
			return true;
		// Second number is now equal
		if (CurrentVer[2] >= UpdateVer[2])
			return true;

		return false;
	}

}
