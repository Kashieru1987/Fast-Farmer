package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

public class Tile {

	private Tiles tileType;
	private Color color;


	public Tile(Tiles tileType) {
		this.tileType = tileType;
		this.color = tileType.getColor();
		
//		switch(tileType) {
//		case DRY_SOIL -> {
//			Timer timer = new Timer(2000, ActionEvent -> {
//				
//				
//
//			});
//			timer.start();
//		}
//		default -> {}
//		}
		
	}

	public Color getColor() {
		return this.color;
	}

	public Tiles getTileType() {
		return tileType;
	}

}
