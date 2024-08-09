package xyz.chronoziel.fastfarmer;

import java.awt.Point;

import javax.swing.JFrame;

import xyz.chronoziel.fastfarmer.constants.GeneralConstants;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	public GameFrame() {
		this.setTitle(GeneralConstants.TITLE);
		this.setLocation(new Point(10, 10));
		this.setSize(GeneralConstants.SIZE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameElements gameElements = GameElements.getInstance();
		gameElements.getPainter().init();
		this.add(gameElements.getGamePanel());
		this.addMouseListener(gameElements.getMouseHandler());
		this.addMouseMotionListener(gameElements.getMouseHandler());

	}

}
