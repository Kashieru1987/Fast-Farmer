package xyz.chronoziel.fastfarmer.frame;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import xyz.chronoziel.fastfarmer.constants.GeneralConstants;
import xyz.chronoziel.fastfarmer.constants.PaletteConstants;
import xyz.chronoziel.fastfarmer.tools.Tool;

@SuppressWarnings("serial")
public class Palette extends JScrollPane {

	Tool[] tools = {new Tool.Hoe(), new Tool.WateringCan(), new Tool.Shovel()};
	JComboBox<Tool> currentTool;
	
	public Palette() {
		this.setMinimumSize(PaletteConstants.SIZE);
		this.getViewport().setBackground(GeneralConstants.BACKGROUND_COLOR);
		
		Container main = Box.createVerticalBox();

		currentTool = new JComboBox<Tool>(tools);
		currentTool.setSelectedIndex(0);
		currentTool.setMaximumSize(new Dimension(currentTool.getMaximumSize().width, 50));
		
		main.add(currentTool);
		
		this.setViewportView(main);
		
	}

}
