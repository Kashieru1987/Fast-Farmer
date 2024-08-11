package xyz.chronoziel.fastfarmer.inputhandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import xyz.chronoziel.fastfarmer.GameElements;

public class MouseHandler implements MouseListener, MouseMotionListener {

	private boolean mouseHeld = false;

	public MouseHandler() {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		GameElements.getInstance().setMousePosition(e.getPoint());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		GameElements.getInstance().setMousePosition(e.getPoint());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		GameElements.getInstance().getPalette().getSelectedItem().use();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseHeld = true;
		new Thread(() -> {
			while(mouseHeld) {
				mouseClicked(e);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseHeld = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
