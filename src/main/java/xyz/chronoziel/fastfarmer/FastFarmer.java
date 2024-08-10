package xyz.chronoziel.fastfarmer;

import java.awt.EventQueue;

import xyz.chronoziel.fastfarmer.frame.GameFrame;
import xyz.chronoziel.fastfarmer.frame.Palette;

public class FastFarmer {

	public FastFarmer() {
		EventQueue.invokeLater(() -> {
			try {
				new GameFrame().setVisible(true);
				new Palette().setVisible(true);
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static void main(String[] args) {
		new FastFarmer();
	}
	
	/*
	 * TODO:
	 * - Create Tile Grid
	 * - - Add way to expand grid using money
	 * - Allow option to till tiles
	 * - - Have soil turn back into grass if not watered
	 * - - Have tiles require water to remain tilled
	 * - - Water sprinkler upgrade?
	 * - Allow option to plant seeds
	 * - - Seed options with different stats
	 * - Upgrades
	 * - - Expansion upgrades
	 * - - Planting upgrades
	 * - - Watering upgrades
	 * - - Yield upgrades (fertiliser)
	 */

}
