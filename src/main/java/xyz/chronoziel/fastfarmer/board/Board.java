package xyz.chronoziel.fastfarmer.board;

import java.awt.Dimension;
import java.util.ArrayList;

import xyz.chronoziel.fastfarmer.constants.GeneralConstants;

public class Board {

	ArrayList<ArrayList<Tile>> board;

	public Board() {
		this(GeneralConstants.DEFAULT_BOARD_SIZE);
	}

	public Board(Dimension size) {
		this(size.height, size.width);
	}

	public Board(int height, int width) {
		for(int i = 0; i < height; i++) {
			ArrayList<Tile> row = new ArrayList<Tile>();
			for(int n = 0; n < width; n++) {
				row.add(new Tile(Tiles.GRASS));
			}
			board.add(row);
		}
	}

	//TODO: do setters and getters for rows and tiles

}
