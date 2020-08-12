package me.bingorufus.rickrollop.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;

import me.bingorufus.rickrollop.RickROP;

public class FireBall {
	private Player p;
	@SuppressWarnings("serial")
	List<String> PossibleNotes = new ArrayList<String>() {
		{
			add("F");
			add("G");
			add("A");
			add("B");
			add("C");
			add("D");
			add("E");
		}
	};
	@SuppressWarnings("serial")
	List<String> PossibleBlocks = new ArrayList<String>() {
		{
			add("DIRT");
			add("WOOD");
			add("STONE");
			add("SAND");
			add("GLASS");
			add("WOOL");
			add("CLAY");
			add("GOLD");
			add("ICE");
			add("BONE");
			add("IRON");
			add("SOUL");
			add("PUMPKIN");
			add("EMERALD");
			add("HAY");
			add("GLOWSTONE");

		}
	};

	public void pause(double d) {
		try {
			TimeUnit.MILLISECONDS.sleep((long) ((1000 / 20) * d));
		} catch (InterruptedException e) {
		}
	}

	public FireBall(RickROP rickROP, Player player) {
		p = player;
		// SongTPS = 2.5
		if (rickROP.PlayingSong.contains(p))
			return;
		rickROP.PlayingSong.add(p);
		Bukkit.getScheduler().runTaskAsynchronously(rickROP, new Runnable() {
			public void run() {

				for (int i = 0; i < 2; i++) {
					pl("Dirt", "A", 3, false);
					pl("Wood", "F", 4, false);
					pl("Dirt", "F", 4, false);
					pl("Wool", "F", 4, false);
					pl("Wool", "A", 3, false);
					pl("Clay", "F", 4, false);
					pl("Stone", "C", 4, false);
					pl("Sand", "G", 4, false);
					pl("Dirt", "A", 4, false);
					pause(5);
					pl("Sand", "E", 5, false);
					pl("Glass", "F", 5, false);
					pause(5);
					pl("Dirt", "A", 3, true);
					pl("Wood", "A", 3, true);
					pl("Wool", "F", 4, false);
					pl("Dirt", "A", 3, false);
					pl("Clay", "G", 4, false);
					pl("Stone", "C", 4, false);
					pause(2.5);
					pl("Wood", "C", 4, false);
					pl("Sand", "G", 4, false);
					pause(2.5);
					pl("Dirt", "A", 3, true);
					pl("Wood", "D", 4, true);
					pl("Dirt", "D", 4, true);
					pl("Wool", "F", 4, false);
					pl("Wool", "A", 3, false);
					pl("Clay", "D", 4, true);
					pl("Sand", "E", 5, false);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Dirt", "A", 3, false);
					pl("Wood", "F", 4, false);
					pl("Dirt", "F", 4, false);
					pl("Wool", "F", 4, false);
					pl("Wool", "A", 3, false);
					pl("Clay", "F", 4, false);
					pl("Stone", "C", 4, false);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Dirt", "C", 4, false);
					pl("Wool", "F", 4, false);
					pl("Wool", "G", 3, false);
					pl("Clay", "C", 4, false);
					pause(2.5);
					pl("Sand", "E", 5, false);
					pl("GLASS", "F", 5, false);
					pause(2.5);
					pl("Dirt", "C", 4, false);
					pl("Wool", "G", 3, false);
					pl("Wool", "A", 3, true);
					pl("Clay", "C", 4, false);
					pl("Sand", "G", 4, false);
					pause(2.5);
					pl("Wood", "A", 3, true);
					pl("Stone", "C", 4, false);
					pause(2.5);
					pl("Wood", "C", 4, false);
					pause(2.5);
					pl("Wood", "D", 4, true);
					pl("Sand", "E", 5, false);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Dirt", "A", 3, false);
					pl("Wood", "F", 4, false);
					pl("Stone", "C", 4, false);
					pl("Sand", "G", 4, false);
					pause(5);
					pl("Sand", "E", 5, false);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Dirt", "F", 4, false);
					pl("Wool", "A", 3, false);
					pl("Wool", "C", 4, false);
					pl("Clay", "F", 4, false);
					pause(2.5);
					pl("Dirt", "A", 3, true);
					pl("Wood", "A", 3, true);
					pl("Wool", "F", 4, false);
					pl("Dirt", "A", 3, false);
					pl("Clay", "G", 4, false);
					pl("Stone", "C", 4, false);
					pause(2.5);
					pl("Wood", "C", 4, false);
					pl("Sand", "G", 4, false);
					pause(2.5);
					pl("Dirt", "A", 3, true);
					pl("Wood", "D", 4, true);
					pl("Dirt", "D", 4, true);
					pl("Wool", "F", 4, false);
					pl("Wool", "A", 3, false);
					pl("Clay", "D", 4, true);
					pl("Sand", "E", 5, false);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Dirt", "A", 3, false);
					pl("Wood", "F", 4, false);
					pl("Dirt", "F", 4, false);
					pl("Wool", "F", 4, false);
					pl("Wool", "A", 3, false);
					pl("Clay", "F", 4, false);
					pl("Stone", "C", 4, false);
					pl("Sand", "G", 4, false);
					pause(2.5);
					pl("Dirt", "C", 4, false);
					pl("Wool", "F", 4, false);
					pl("Wool", "G", 3, false);
					pl("Clay", "C", 4, false);
					pause(2.5);
					pl("Sand", "E", 5, false);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Dirt", "C", 4, false);
					pl("Wool", "F", 4, false);
					pl("Wool", "G", 3, false);
					pl("Clay", "C", 4, false);
					pl("Sand", "G", 4, false);
					pause(2.5);
					pl("Wood", "A", 3, true);
					pl("Stone", "C", 4, false);
					pause(2.5);
					pl("Wood", "C", 4, false);
					pl("Wool", "A", 3, true);
					pause(2.5);
					pl("Wood", "D", 4, true);
					pl("Wool", "F", 4, false);
					pl("Wool", "A", 3, false);
					pl("Sand", "E", 5, false);
					pl("Glass", "F", 5, false);
					pause(2.5);
					pl("Wool", "F", 4, false);
					pl("Wool", "A", 3, false);
					pl("Glass", "F", 5, false);
					pause(2.5);
				}
				rickROP.PlayingSong.remove(p);

			}
		});
	}

	private void pl(String Block, String InstrumentNote, Integer Octave, Boolean isSharp) {
		Instrument instr = null;
		if (Block.equalsIgnoreCase("dirt")) {
			instr = Instrument.PIANO;
		}
		if (Block.equalsIgnoreCase("wood")) {
			instr = Instrument.BASS_GUITAR;
		}
		if (Block.equalsIgnoreCase("Stone")) {
			instr = Instrument.BASS_DRUM;
		}
		if (Block.equalsIgnoreCase("SAND")) {
			instr = Instrument.SNARE_DRUM;
		}
		if (Block.equalsIgnoreCase("Glass")) {
			instr = Instrument.PIANO;
		}
		if (Block.equalsIgnoreCase("wool")) {
			instr = Instrument.GUITAR;
		}
		if (Block.equalsIgnoreCase("clay")) {
			instr = Instrument.FLUTE;
		}
		if (Block.equalsIgnoreCase("gold")) {
			instr = Instrument.BELL;
		}
		if (Block.equalsIgnoreCase("ice")) {
			instr = Instrument.CHIME;
		}
		if (Block.equalsIgnoreCase("bone")) {
			instr = Instrument.XYLOPHONE;
		}
		if (Block.equalsIgnoreCase("Iron")) {
			instr = Instrument.IRON_XYLOPHONE;
		}
		if (Block.equalsIgnoreCase("PUMPKIN")) {
			instr = Instrument.DIDGERIDOO;
		}
		if (Block.equalsIgnoreCase("EMERALD")) {
			instr = Instrument.BIT;
		}
		if (Block.equalsIgnoreCase("HAY")) {
			instr = Instrument.BANJO;
		}
		if (Block.equalsIgnoreCase("GLOWSTONE")) {
			instr = Instrument.PLING;
		}
		Tone NoteTone = Tone.valueOf(InstrumentNote.toUpperCase());
		if (InstrumentNote.equalsIgnoreCase("F")) {
			if (isSharp) {
				p.playNote(p.getLocation(), instr, Note.sharp(Octave - 3, Tone.F));
				return;
			}
			p.playNote(p.getLocation(), instr, Note.natural(Octave - 4, Tone.F));
			return;

		}
		if (InstrumentNote.equalsIgnoreCase("G") || InstrumentNote.equalsIgnoreCase("A")
				|| InstrumentNote.equalsIgnoreCase("B")) {
			if (isSharp) {
				p.playNote(p.getLocation(), instr, Note.sharp(Octave - 3, NoteTone));
				return;
			}
			p.playNote(p.getLocation(), instr, Note.natural(Octave - 3, NoteTone));
			return;
		}
		if (isSharp) {
			p.playNote(p.getLocation(), instr, Note.sharp(Octave - 3, NoteTone));
			return;
		}
		p.playNote(p.getLocation(), instr, Note.natural(Octave - 4, NoteTone));
		return;

	}

}
