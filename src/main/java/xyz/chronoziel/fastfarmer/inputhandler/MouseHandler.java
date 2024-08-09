package xyz.chronoziel.fastfarmer.inputhandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import xyz.chronoziel.fastfarmer.GameElements;

public class MouseHandler implements MouseListener, MouseMotionListener {

	public MouseHandler() {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		GameElements.getInstance().setMousePosition(e.getPoint());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("mouse moved");
		GameElements.getInstance().setMousePosition(e.getPoint());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicked");
		GameElements.getInstance().getPalette().getSelectedTool().useTool();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
