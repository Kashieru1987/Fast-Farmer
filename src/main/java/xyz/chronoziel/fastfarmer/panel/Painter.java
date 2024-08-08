package xyz.chronoziel.fastfarmer.panel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import xyz.chronoziel.fastfarmer.GameElements;

public class Painter {

	public Painter() {
	}

	public void init() {
		ArrayList<Consumer<Graphics2D>> paintQueue = new ArrayList<Consumer<Graphics2D>>();
		
		paintQueue.add(Painter::Circle);
		
		GameElements.getInstance().getGamePanel().setPaintQueue(paintQueue);
	}

	/**
	 * this is just for making sure that things are actually being painted
	 * @param g2
	 */
	private static void Circle(Graphics2D g2) {
		g2.setColor(Color.green);
		g2.drawOval(10, 10, 10, 10);
	}

}
