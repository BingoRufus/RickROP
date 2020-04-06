package me.BingoRufus.RickROP.Listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class CommandsTabCompleter implements TabCompleter {
	List<String> SubCommands = new ArrayList<String>();

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (SubCommands.isEmpty()) {
			SubCommands.add("rickroll");
			SubCommands.add("reload");
			SubCommands.add("help");
		}
		List<String> result = new ArrayList<String>();

		if (args.length >= 1) {
			if (args[0].equalsIgnoreCase("rickroll")) {

				List<String> OnlinePlayers = new ArrayList<String>();
				for (Player p : Bukkit.getOnlinePlayers()) {
					OnlinePlayers.add(p.getName());
				}
				for (String Player : OnlinePlayers) {
					if (Player.toLowerCase().startsWith(args[1].toLowerCase())) {
						result.add(Player);
					}
				}
				return result;
			}
		}
		if (args.length == 0) {
			return SubCommands;
		}
		if (args.length == 1) {
			for (String SubCmd : SubCommands) {
				if (SubCmd.toLowerCase().startsWith(args[0].toLowerCase())) {
					result.add(SubCmd);
				}
			}
			return result;
		}

		return null;
	}
}
