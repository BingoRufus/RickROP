package me.BingoRufus.RickROP.Utils;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;

import me.BingoRufus.RickROP.Main;

public class CrabRave {
	public void pause(double d) {
		try {
			TimeUnit.MILLISECONDS.sleep((long) ((1000 / 20) * d));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CrabRave(Main m, Player playr) {

		Player p = playr;
		Bukkit.getScheduler().runTaskAsynchronously(m, new Runnable() {
			public void run() {
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.G));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.sharp(1, Tone.A));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.G));
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.G));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.G));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.F));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.A));
				pause(5);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.F));
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.A));
				pause(5);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.D));
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.C));
				pause(2);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.C));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.E));
				pause(2);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.E));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.E));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.G));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.sharp(1, Tone.A));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.G));
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.G));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.G));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.F));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.A));
				pause(5);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.F));
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.D));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.A));
				pause(5);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.D));
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.C));
				pause(2);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.C));
				pause(5);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.E));
				pause(2);
				p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.E));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.F));
				pause(2);
				p.playNote(p.getLocation(), Instrument.IRON_XYLOPHONE, Note.natural(1, Tone.E));

			}
		});

	}
}
