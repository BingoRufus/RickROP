package me.bingorufus.rickrollop;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.bingorufus.rickrollop.listeners.Commands;
import me.bingorufus.rickrollop.listeners.CommandsTabCompleter;
import me.bingorufus.rickrollop.listeners.NewVersionDisplayer;
import me.bingorufus.rickrollop.listeners.RickROPEventListener;
import me.bingorufus.rickrollop.utils.Metrics;
import me.bingorufus.rickrollop.utils.RickRoll;
import me.bingorufus.rickrollop.utils.UpdateChecker;

public class RickROP extends JavaPlugin implements Listener {
	public RickRoll play;
	NewVersionDisplayer NewVer;
	List<String> BlockedMessages = new ArrayList<String>();
	String[][] Replacements;
	public List<Player> PlayingSong = new ArrayList<Player>();

	public RickROP rickROP;

	@Override
	public void onEnable() {

		new Metrics(this, 7239);
		rickROP = this;
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
		if (!rickROP.getConfig().getBoolean("disable-update-checking")) {
			new UpdateChecker(rickROP, 76422).getLatestVersion(version -> {

				if (UpToDate(this.getDescription().getVersion().split("[.]"), version.split("[.]"))) {
					this.getLogger().info("RickROP is up to date");
				} else {

					this.getLogger().warning("RickROP is currently running version "
							+ rickROP.getDescription().getVersion() + " and can be updated to " + version);
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
		Bukkit.getPluginManager().registerEvents(new RickROPEventListener(rickROP, BlockedMessages, Replacements), rickROP);
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
