package xyz.chronoziel.fastfarmer;

import xyz.chronoziel.fastfarmer.board.Board;
import xyz.chronoziel.fastfarmer.panel.GamePanel;
import xyz.chronoziel.fastfarmer.panel.Painter;

public class GameElements {

	private volatile static GameElements instance;
	private GamePanel gamePanel;
	private Painter painter;
	private Board board;

	private GameElements() {
		gamePanel = new GamePanel();
		painter = new Painter();
		board = new Board();
	}

	public static GameElements getInstance() {
		GameElements gameElements = instance;
		if(gameElements == null) {
			synchronized(GameElements.class) {
				gameElements = instance;
				if(gameElements == null) {
					instance = gameElements = new GameElements();
				}
			}
		}
		return gameElements;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public Painter getPainter() {
		return painter;
	}

	public Board getBoard() {
		return board;
	}

}
