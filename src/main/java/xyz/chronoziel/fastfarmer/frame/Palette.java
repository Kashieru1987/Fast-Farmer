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

	Tool[] tools = { new Tool.Hoe(), new Tool.WateringCan(), new Tool.Shovel() };
	JComboBox<Tool> toolSelector;
	Tool selectedTool = tools[0];

	public Palette() {
		this.setMinimumSize(PaletteConstants.SIZE);
		this.getViewport().setBackground(GeneralConstants.BACKGROUND_COLOR);

		Container main = Box.createVerticalBox();

		toolSelector = new JComboBox<Tool>(tools);
		toolSelector.setSelectedIndex(0);
		toolSelector.setMaximumSize(new Dimension(toolSelector.getMaximumSize().width, 50));
		toolSelector.addActionListener(
				actionevent -> selectedTool = toolSelector.getItemAt(toolSelector.getSelectedIndex()));

		main.add(toolSelector);

		this.setViewportView(main);

	}

	public Tool getSelectedTool() {
		return this.selectedTool;
	}

}
