package me.BingoRufus.RickROP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.BingoRufus.RickROP.Listeners.Commands;
import me.BingoRufus.RickROP.Listeners.CommandsTabCompleter;
import me.BingoRufus.RickROP.Listeners.RickROPEventListener;

public class Main extends JavaPlugin implements Listener {
	public RickRoll play;

	List<String> BlockedMessages = new ArrayList<String>();
	String[][] Replacements;

	public static Main main;

	@Override
	public void onEnable() {

		main = this;
		this.saveDefaultConfig();
		this.reloadConfig();

		configReload();
		this.getCommand("rickrop").setExecutor(new Commands());
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

		BlockedMessages = getConfig().getStringList("blocked-messages");
		List<String> syns = getConfig().getStringList("synonyms");
		Replacements = new String[syns.size()][2];
		for (int length = 0; length < syns.size(); length++) {

			Replacements[length] = syns.get(length).split(":");

		}
		Bukkit.getPluginManager().registerEvents(new RickROPEventListener(main, BlockedMessages, Replacements), main);
	}

}
