package xyz.chronoziel.fastfarmer.panel;

import java.awt.Graphics2D;
import java.awt.Point;
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
		paintQueue.add(Painter::MousePointer);

		GameElements.getInstance().getGamePanel().setPaintQueue(paintQueue);
	}

	private static void GameBoard(Graphics2D g2) {
		GameElements gameElements = GameElements.getInstance();
		Board gameBoard = gameElements.getBoard();

		int tileDiameter = gameBoard.getTileDiameter();
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

	private static void MousePointer(Graphics2D g2) {
		g2.setColor(GeneralConstants.MOUSE_POINTER_COLOR);
		Point p = GameElements.getInstance().getMousePosition();
		g2.fillOval(p.x-2, p.y-2, 4, 4);
	}

}
