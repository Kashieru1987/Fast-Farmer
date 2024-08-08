package xyz.chronoziel.fastfarmer.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private ArrayList<Consumer<Graphics2D>> paintQueue;

	public void setPaintQueue(ArrayList<Consumer<Graphics2D>> paintQueue) {
		this.paintQueue = paintQueue;
	}

	public GamePanel() {
		this.setBackground(Color.DARK_GRAY);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(Consumer<Graphics2D> item : paintQueue) {
			item.accept(g2);
		}
		
	}

}
