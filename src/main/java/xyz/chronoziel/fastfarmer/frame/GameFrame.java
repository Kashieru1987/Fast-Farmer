package xyz.chronoziel.fastfarmer.frame;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import xyz.chronoziel.fastfarmer.GameElements;
import xyz.chronoziel.fastfarmer.constants.GeneralConstants;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	public GameFrame() {
		this.setTitle(GeneralConstants.TITLE);
		this.setLocation(GeneralConstants.POSITION);
		this.setMinimumSize(GeneralConstants.SIZE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameElements gameElements = GameElements.getInstance();
		gameElements.getPainter().init();
		
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gameElements.getGamePanel(), gameElements.getPalette());
		pane.setOneTouchExpandable(true);
		pane.setDividerLocation(600);
		
		this.add(pane);
		
		gameElements.getGamePanel().addMouseListener(gameElements.getMouseHandler());
		gameElements.getGamePanel().addMouseMotionListener(gameElements.getMouseHandler());
		
//		this.addMouseListener(gameElements.getMouseHandler());
//		this.addMouseMotionListener(gameElements.getMouseHandler());

		gameElements.startGameLoop();

	}

}
