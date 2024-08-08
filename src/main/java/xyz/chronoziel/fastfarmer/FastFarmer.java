package xyz.chronoziel.fastfarmer;

import java.awt.EventQueue;

public class FastFarmer {

	public FastFarmer() {
		EventQueue.invokeLater(() -> {
			try {
				new GameFrame().setVisible(true);
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
	 * - - Ensure aspect ratio of tile is kept (all square)
	 * - - Add way to expand grid using money
	 * - Allow option to till tiles
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
