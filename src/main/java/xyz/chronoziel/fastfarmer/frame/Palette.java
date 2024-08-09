package xyz.chronoziel.fastfarmer.frame;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import xyz.chronoziel.fastfarmer.constants.GeneralConstants;
import xyz.chronoziel.fastfarmer.constants.PaletteConstants;
import xyz.chronoziel.fastfarmer.tools.HoeTool;
import xyz.chronoziel.fastfarmer.tools.Useable;

@SuppressWarnings("serial")
public class Palette extends JScrollPane {

	Useable[] tools = {new HoeTool()};
	JComboBox<Useable> currentTool;
	
	
	public Palette() {
		this.setMinimumSize(PaletteConstants.SIZE);
		this.getViewport().setBackground(GeneralConstants.BACKGROUND_COLOR);
		
		Container main = Box.createVerticalBox();

		currentTool = new JComboBox<Useable>(tools);
		currentTool.setSelectedIndex(0);
		currentTool.setMaximumSize(new Dimension(currentTool.getMaximumSize().width, 50));
		
		main.add(currentTool);
		
		this.setViewportView(main);
		
	}

}
