package me.bingorufus.rickrollop.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.bingorufus.rickrollop.RickROP;
import me.bingorufus.rickrollop.utils.CrabRave;
import me.bingorufus.rickrollop.utils.FireBall;
import me.bingorufus.rickrollop.utils.RickRoll;
import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {
	private RickROP m;

	public Commands(RickROP rickROP) {
		this.m = rickROP;
	}

	Random rand = new Random();

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

					if (!(sender.hasPermission("rickrop.play.rickroll"))) {
						sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
						return true;
					}
					if (args.length == 1) {
						if (!(sender instanceof Player)) {
							sender.sendMessage(ChatColor.RED
									+ "You can not do this to a non player, please do /rickrop rickroll <player>");
							return true;
						}
						Player p = (Player) sender;
						if (p.hasPermission("rickrop.play.rickroll")) {
							new RickRoll(m, p);
							sender.sendMessage(ChatColor.GREEN + "You RickRolled yourself");
							return true;
						}

					}
					if (args.length == 2) {
						if (sender.hasPermission("rickrop.play.rickroll")) {
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
				if (args[0].equalsIgnoreCase("fireball")) {

					if (!(sender.hasPermission("rickrop.play.fireball"))) {
						sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
						return true;
					}
					if (args.length == 1) {
						if (!(sender instanceof Player)) {
							sender.sendMessage(ChatColor.RED
									+ "You can not do this to a non player, please do /rickrop fireball <player>");
							return true;
						}
						Player p = (Player) sender;
						if (p.hasPermission("rickrop.play.fireball")) {
							new FireBall(m, p);
							sender.sendMessage(ChatColor.GREEN + "You played Fireball to yourself");
							return true;
						}

					}
					if (args.length == 2) {
						if (sender.hasPermission("rickrop.play.Fireball")) {
							if (args[1].equals("*")) {
								for (Player p : Bukkit.getOnlinePlayers()) {
									sender.sendMessage(ChatColor.GREEN + "You played Fireball to "
											+ ChatColor.stripColor(p.getName()));
									new FireBall(m, p);
								}
								return true;
							}
							if (Bukkit.getPlayer(args[1]) != null) {
								Player p = Bukkit.getPlayer(args[1]);
								new FireBall(m, p);
								sender.sendMessage(ChatColor.GREEN + "You played Fireball to "
										+ ChatColor.stripColor(p.getName()));

								return true;
							}
							sender.sendMessage(ChatColor.RED + "That player is not online.");
							return true;
						}
						return false;
					}

				}

				if (args[0].equalsIgnoreCase("crabrave")) {

					if (!(sender.hasPermission("rickrop.play.crabrave"))) {
						sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
						return true;
					}
					if (args.length == 1) {
						if (!(sender instanceof Player)) {
							sender.sendMessage(ChatColor.RED
									+ "You can not do this to a non player, please do /rickrop crabrave <player>");
							return true;
						}
						Player p = (Player) sender;
						if (p.hasPermission("rickrop.play.crabrave")) {
							new CrabRave(m, p);
							sender.sendMessage(ChatColor.GREEN + "You have played Crab Rave to yourself");
							return true;
						}

					}
					if (args.length == 2) {
						if (sender.hasPermission("rickrop.play.crabrave")) {
							if (args[1].equals("*")) {
								for (Player p : Bukkit.getOnlinePlayers()) {
									sender.sendMessage(ChatColor.GREEN + "You played Crab Rave to "
											+ ChatColor.stripColor(p.getName()));
									new CrabRave(m, p);
								}
								return true;
							}
							if (Bukkit.getPlayer(args[1]) != null) {
								Player p = Bukkit.getPlayer(args[1]);
								new CrabRave(m, p);
								sender.sendMessage(ChatColor.GREEN + "You have played Crab Rave to "
										+ ChatColor.stripColor(p.getName()));

								return true;
							}
							sender.sendMessage(ChatColor.RED + "That player is not online.");
							return true;
						}
						return false;
					}
				}
				if (args[0].equalsIgnoreCase("random")) {
					if (!(sender.hasPermission("rickrop.play.random"))) {
						sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
						return true;
					}
					if (args.length == 1) {
						if (!(sender instanceof Player)) {
							sender.sendMessage(ChatColor.RED
									+ "You can not do this to a non player, please do /rickrop random <player>");
							return true;
						}

						Player p = (Player) sender;
						if (p.hasPermission("rickrop.play.random")) {
							Integer RandomSong = rand.nextInt(3);
							if (RandomSong == 0) {
								new CrabRave(m, p);
								sender.sendMessage(ChatColor.GREEN + "You have played Crab Rave to yourself");
								return true;
							}
							if (RandomSong == 1) {
								new RickRoll(m, p);
								sender.sendMessage(ChatColor.GREEN + "You have Rickrolled yourself");
								return true;
							}
							if (RandomSong == 2) {
								new FireBall(m, p);
								sender.sendMessage(ChatColor.GREEN + "You have played Fireball to yourself");
								return true;
							}
						}

					}
					if (args.length == 2) {
						if (sender.hasPermission("rickrop.play.random")) {
							if (args[1].equals("*")) {
								for (Player p : Bukkit.getOnlinePlayers()) {
									Integer RandomSong = rand.nextInt(3);
									if (RandomSong == 0) {
										new CrabRave(m, p);
										sender.sendMessage(ChatColor.GREEN + "You played Crab Rave to "
												+ ChatColor.stripColor(p.getName()));
									}
									if (RandomSong == 1) {
										new RickRoll(m, p);
										sender.sendMessage(ChatColor.GREEN + "You Rickrolled "
												+ ChatColor.stripColor(p.getName()));
									}

									if (RandomSong == 2) {
										new FireBall(m, p);
										sender.sendMessage(ChatColor.GREEN + "You played Fireball To "
												+ ChatColor.stripColor(p.getName()));
									}
								}
								return true;
							}
							if (Bukkit.getPlayer(args[1]) != null) {
								Player p = Bukkit.getPlayer(args[1]);

								Integer RandomSong = rand.nextInt(3);
								if (RandomSong == 0) {
									new CrabRave(m, p);
									sender.sendMessage(ChatColor.GREEN + "You played Crab Rave to "
											+ ChatColor.stripColor(p.getName()));
									return true;
								}
								if (RandomSong == 1) {
									new RickRoll(m, p);
									sender.sendMessage(
											ChatColor.GREEN + "You Rickrolled " + ChatColor.stripColor(p.getName()));
									return true;
								}
								if (RandomSong == 2) {
									new FireBall(m, p);
									sender.sendMessage(ChatColor.GREEN + "You played Fireball to "
											+ ChatColor.stripColor(p.getName()));
									return true;
								}

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
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&a/RickROP crabrave <player> &7- &bPlay CrabRave to players"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&a/RickROP fireball <player> &7- &bPlay FireBall to players"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a/RickROP help &7- &bView this help message"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&a/RickROP random <player> &7- &bPlay a random RickROP song to players"));
		sender.sendMessage(
				ChatColor.translateAlternateColorCodes('&', "&a/RickROP reload &7- &bReload the RickROP config"));
		sender.sendMessage(
				ChatColor.translateAlternateColorCodes('&', "&a/RickROP rickroll <player> &7- &bRickroll players"));

		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&7=-=-=-=- &aVersion &c" + m.getDescription().getVersion() + "&7 -=-=-=-="));
	}

}
