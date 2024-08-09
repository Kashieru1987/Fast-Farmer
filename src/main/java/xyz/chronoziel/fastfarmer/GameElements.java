package xyz.chronoziel.fastfarmer;

import java.awt.Point;

import xyz.chronoziel.fastfarmer.board.Board;
import xyz.chronoziel.fastfarmer.frame.Palette;
import xyz.chronoziel.fastfarmer.inputhandler.MouseHandler;
import xyz.chronoziel.fastfarmer.panel.GamePanel;
import xyz.chronoziel.fastfarmer.panel.Painter;

public class GameElements {

	private volatile static GameElements instance;
	private volatile Point mousePosition;
	private MouseHandler mouseHandler;
	private GamePanel gamePanel;
	private Palette palette;
	private Painter painter;
	private Board board;

	private GameElements() {
		gamePanel = new GamePanel();
		palette = new Palette();
		mousePosition = new Point();
		mouseHandler = new MouseHandler();
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

	public MouseHandler getMouseHandler() {
		return mouseHandler;
	}

	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
	
	public Palette getPalette() {
		return this.palette;
	}

	public Painter getPainter() {
		return this.painter;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setMousePosition(Point mousePosition) {
		this.mousePosition = mousePosition;
	}
	
	public Point getMousePosition() {
		return this.mousePosition;
	}

}
