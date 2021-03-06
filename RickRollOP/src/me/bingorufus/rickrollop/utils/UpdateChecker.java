package me.bingorufus.rickrollop.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

import org.bukkit.Bukkit;

import me.bingorufus.rickrollop.RickROP;

public class UpdateChecker {

	private RickROP plugin;
	private Integer id;

	public UpdateChecker(RickROP m, Integer i) {
		this.plugin = m;
		this.id = i;
	}

	public void getLatestVersion(Consumer<String> consumer) {
		Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
			try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.id)
					.openStream(); Scanner scanner = new Scanner(inputStream)) {
				if (scanner.hasNext()) {
					consumer.accept(scanner.next());
				}

			} catch (IOException e) {
				this.plugin.getLogger().warning("Unable to connect to Spigot to check for updates " + e.getMessage());
			}

		});

	}
}
