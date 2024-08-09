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
		board = new ArrayList<ArrayList<Tile>>();
		for(int i = 0; i < height; i++) {
			ArrayList<Tile> row = new ArrayList<Tile>();
			for(int n = 0; n < width; n++) {
				row.add(new Tile(Tiles.GRASS));
			}
			board.add(row);
		}
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

	public void setTile(int row, int column, Tile tile) {
		getRow(row).set(column, tile);
	}

	public ArrayList<ArrayList<Tile>> getRaw(){
		return board;
	}

	public ArrayList<Tile> getRow(int index){
		return board.get(index);
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
