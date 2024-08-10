package xyz.chronoziel.fastfarmer.board;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import xyz.chronoziel.fastfarmer.GameElements;
import xyz.chronoziel.fastfarmer.constants.GeneralConstants;
import xyz.chronoziel.fastfarmer.constants.TileConstants;
import xyz.chronoziel.fastfarmer.util.ThreadUtil;

public class Board {

	ArrayList<ArrayList<Tile>> board;

	public Board() {
		this(GeneralConstants.DEFAULT_BOARD_SIZE);
	}

	public Board(Dimension size) {
		this(size.height, size.width);
	}

	public Board(int height, int width) {
		board = new ArrayList<ArrayList<Tile>>();
		for (int i = 0; i < height; i++) {
			ArrayList<Tile> row = new ArrayList<Tile>();
			for (int n = 0; n < width; n++) {
				row.add(new Tile(Tiles.GRASS));
			}
			board.add(row);
		}
	}

	/**
	 * Calculates how wide/tall the tiles could be and returns the smallest length
	 * 
	 * @return the tile diameter
	 */
	public int getTileDiameter() {
		Dimension panelDimensions = GameElements.getInstance().getGamePanel().getSize();
		int panelHeight = panelDimensions.height;
		int panelWidth = panelDimensions.width;
		int tilesHigh = this.getRowsHigh();
		int tilesWide = this.getColumnsWide();

		int potentialTileHeight = (int) ((double) panelHeight / (double) tilesHigh);
		int potentialTileWidth = (int) ((double) panelWidth / (double) tilesWide);

		if (potentialTileHeight < potentialTileWidth)
			return potentialTileHeight;
		return potentialTileWidth;

	}

	public Point findOnBoard(Point pos) {
		double tileDiameter = getTileDiameter();
		int posX = (int) ((double) pos.x / tileDiameter);
		int posY = (int) ((double) pos.y / tileDiameter);

		return new Point(posX, posY);

	}

	public boolean isValidIndex(Point pos) {
		pos = findOnBoard(pos);
		return isValidIndex(pos.y, pos.x);
	}
	
	public boolean isValidIndex(int row, int column) {
		boolean validRow = row >= 0 && row < this.getRowsHigh();
		boolean validColumn = column >= 0 && column < this.getColumnsWide();
		return validRow && validColumn;
	}

	public void setBoard(Board board) {
		setBoard(board.getRaw());
	}

	public void setBoard(ArrayList<ArrayList<Tile>> board) {
		this.board = board;
	}

	public void setRow(int index, ArrayList<Tile> row) {
		board.set(index, row);
	}

	public void setTile(Point p, Tile tile) {
		p = findOnBoard(p);
		setTile(p.y, p.x, tile);
	}

	public void setTile(int row, int column, Tile tile) {
		getRow(row).set(column, tile);

		switch(tile.getTileType()) {
		case DRY_SOIL -> {
			new Thread(() -> {
				
				ThreadUtil.sleepAndVary(TileConstants.DRY_SOIL_TIMEOUT, TileConstants.SOIL_TIMEOUT_VARIANCE);
				if(getTile(row, column).equals(tile)) {
					setTile(row, column, new Tile(Tiles.GRASS));
				}
				
				
			}).start();
		}
		case WET_SOIL -> {
			new Thread(() -> {
				
				ThreadUtil.sleepAndVary(TileConstants.WET_SOIL_TIMEOUT, TileConstants.SOIL_TIMEOUT_VARIANCE);
				if(getTile(row, column).equals(tile)) {
					setTile(row, column, new Tile(Tiles.DRY_SOIL));
				}
				
			}).start();
		}
		default -> {}
		}

	}

	public ArrayList<ArrayList<Tile>> getRaw() {
		return board;
	}

	public ArrayList<Tile> getRow(int index) {
		return board.get(index);
	}

	public Tile getTile(Point p) {
		p = findOnBoard(p);
		return getTile(p.y, p.x);
	}

	public Tile getTile(int row, int column) {
		return getRow(row).get(column);
	}

	public int getRowsHigh() {
		return board.size();
	}

	public int getColumnsWide() {
		return getRow(0).size();
	}

}
