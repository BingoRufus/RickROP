package me.BingoRufus.RickROP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.BingoRufus.RickROP.Main;
import me.BingoRufus.RickROP.RickRoll;
import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {
	Main m = Main.main;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rickrop")) {
			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					if (sender.hasPermission("rickrop.reload")) {
						m.configReload();
						sender.sendMessage(ChatColor.GREEN + "RickROP successfully reloaded");
						return true;
					}
					sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
					return true;

				}

				if (args[0].equalsIgnoreCase("rickroll")) {

					if (!(sender.hasPermission("rickrop.command"))) {
						sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
						return true;
					}
					if (args.length == 1) {
						if (!(sender instanceof Player)) {
							sender.sendMessage(ChatColor.RED
									+ "You can not do this to a non player, please do /rickroll <player>");
							return true;
						}
						Player p = (Player) sender;
						if (p.hasPermission("rickrop.command")) {
							new RickRoll(m, p);
							sender.sendMessage(ChatColor.GREEN + "You RickRolled yourself");
							return true;
						}

					}
					if (args.length == 2) {
						if (sender.hasPermission("rickrop.command")) {
							if (args[1].equals("*")) {
								for (Player p : Bukkit.getOnlinePlayers()) {
									sender.sendMessage(
											ChatColor.GREEN + "You Rickrolled " + ChatColor.stripColor(p.getName()));
									new RickRoll(m, p);
								}
								return true;
							}
							if (Bukkit.getPlayer(args[1]) != null) {
								Player p = Bukkit.getPlayer(args[1]);
								new RickRoll(m, p);
								sender.sendMessage(
										ChatColor.GREEN + "You Rickrolled " + ChatColor.stripColor(p.getName()));

								return true;
							}
							sender.sendMessage(ChatColor.RED + "That player is not online.");
							return true;
						}
						return false;
					}
				}
				if (args[0].equalsIgnoreCase("help")) {
					sendHelp(sender);
					return true;
				}

				sender.sendMessage(ChatColor.RED + "Invalid Command. Do '/rickrop help' for help");
				return true;

			}
			sendHelp(sender);
			return true;
		}
		return false;
	}

	public void sendHelp(CommandSender sender) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7=-=-=-=- &aRickROP Help&7 -=-=-=-="));
		sender.sendMessage(
				ChatColor.translateAlternateColorCodes('&', "&a/RickROP reload &7- &bReload the RickROP config"));
		sender.sendMessage(
				ChatColor.translateAlternateColorCodes('&', "&a/RickROP rickroll <player> &7- &bRickroll players"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a/RickROP help &7- &bView this help message"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&7=-=-=-=- &aVersion &c" + m.getDescription().getVersion() + "&7 -=-=-=-="));
	}

}
