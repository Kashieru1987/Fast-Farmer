package xyz.chronoziel.fastfarmer.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JPanel;
import javax.swing.Timer;

import xyz.chronoziel.fastfarmer.constants.GeneralConstants;
import xyz.chronoziel.fastfarmer.util.FPSListener;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {

	private FPSListener listenerFPS;
	private ArrayList<Consumer<Graphics2D>> paintQueue;
	private boolean doGameLoop;
	private long fpsCounter;

	public void addFPSListener(FPSListener listenerFPS) {
		this.listenerFPS = listenerFPS;
	}

	public void setPaintQueue(ArrayList<Consumer<Graphics2D>> paintQueue) {
		this.paintQueue = paintQueue;
	}

	public GamePanel() {
		this.setBackground(GeneralConstants.BACKGROUND_COLOR);
		this.setMinimumSize(GeneralConstants.PANEL_SIZE);
	}

	public void setDoGameLoop(boolean flag) {
		this.doGameLoop = flag;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (Consumer<Graphics2D> item : paintQueue) {
			item.accept(g2);
		}

	}

	@Override
	public void run() {
		int fpsTarget = GeneralConstants.TARGET_FPS;
		long lastTime = System.nanoTime();
		double ns = 1000000000 / fpsTarget;
		double delta = 0;

		Timer fpsShouter = new Timer(1000, actionevent -> {
			listenerFPS.updateFPS(fpsCounter);
			fpsCounter = 0;
		});
		fpsShouter.start();

		doGameLoop = true;
		while (doGameLoop) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			delta -= (int) delta; // makes sure delta is always in between 0 and 1;

			this.repaint();
			fpsCounter++;

			long frameTime = System.nanoTime() - now;
			long sleepTime = (long) ((ns - frameTime) / 1000000);
			
			if(sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
