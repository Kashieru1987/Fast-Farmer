package xyz.chronoziel.fastfarmer.panel;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import xyz.chronoziel.fastfarmer.GameElements;
import xyz.chronoziel.fastfarmer.board.Board;
import xyz.chronoziel.fastfarmer.board.Tile;
import xyz.chronoziel.fastfarmer.constants.GeneralConstants;

public class Painter {

	public Painter() {
	}

	public void init() {
		ArrayList<Consumer<Graphics2D>> paintQueue = new ArrayList<Consumer<Graphics2D>>();

		paintQueue.add(Painter::GameBoard);
		paintQueue.add(Painter::GridLines);

		GameElements.getInstance().getGamePanel().setPaintQueue(paintQueue);
	}

	private static void GameBoard(Graphics2D g2) {
		GameElements gameElements = GameElements.getInstance();
		Board gameBoard = gameElements.getBoard();

		// oh god i found out i can declare a class in here lmfao
		class TileCalculator {
			/**
			 * Calculates how wide/tall the tiles could be and returns the smallest length
			 * 
			 * @return the tile diameter
			 */
			public int getTileDiameter() {
				Dimension panelDimensions = gameElements.getGamePanel().getSize();
				int panelHeight = panelDimensions.height;
				int panelWidth = panelDimensions.width;
				int tilesHigh = gameBoard.getRowsHigh();
				int tilesWide = gameBoard.getColumnsWide();

				int potentialTileHeight = (int) ((double) panelHeight / (double) tilesHigh);
				int potentialTileWidth = (int) ((double) panelWidth / (double) tilesWide);

				if (potentialTileHeight < potentialTileWidth)
					return potentialTileHeight;
				return potentialTileWidth;

			}
		}

		int tileDiameter = (new TileCalculator()).getTileDiameter();
		for (int row = 0; row < gameBoard.getRowsHigh(); row++) {
			for (int column = 0; column < gameBoard.getColumnsWide(); column++) {
				int pivotX = column * tileDiameter;
				int pivotY = row * tileDiameter;

				Tile currentTile = gameBoard.getTile(row, column);

				g2.setColor(currentTile.getColor());
				g2.fillRect(pivotX, pivotY, tileDiameter, tileDiameter);
				g2.setColor(GeneralConstants.GRID_LINE_COLOR);
				g2.drawRect(pivotX, pivotY, tileDiameter, tileDiameter);
			}
		}

	}

	private static void GridLines(Graphics2D g2) {
		
	}

}
