package xyz.chronoziel.fastfarmer.frame;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import xyz.chronoziel.fastfarmer.board.Crop;
import xyz.chronoziel.fastfarmer.board.MouseModes;
import xyz.chronoziel.fastfarmer.constants.GeneralConstants;
import xyz.chronoziel.fastfarmer.constants.PaletteConstants;
import xyz.chronoziel.fastfarmer.tools.Tool;
import xyz.chronoziel.fastfarmer.tools.Useable;

@SuppressWarnings("serial")
public class Palette extends JScrollPane {

	private MouseModes mouseMode;
	
	private JComboBox<Useable> selector;

	private Tool[] tools = { new Tool.Hoe(), new Tool.WateringCan(), new Tool.Shovel() };
	private Tool selectedTool = tools[0];

	private Crop[] crops = { new Crop.Wheat(), new Crop.Pumpkin() };
	private Crop selectedCrop = crops[0];

	private Useable selectedItem = selectedTool;

	public Palette() {
		this.setMinimumSize(PaletteConstants.SIZE);
		this.getViewport().setBackground(GeneralConstants.BACKGROUND_COLOR);

		Container main = Box.createVerticalBox();
		Container mouseModeOptions = Box.createVerticalBox();

		{
			ButtonGroup group = new ButtonGroup();
			
			JRadioButton toolModeButton = new JRadioButton();
			toolModeButton.setText("Tools");
			toolModeButton.setSelected(true);
			group.add(toolModeButton);
			mouseModeOptions.add(toolModeButton);
			mouseMode = MouseModes.TOOLS;
			toolModeButton.addActionListener(actionevent -> {
				mouseMode = MouseModes.TOOLS;
				System.out.println("Tool Mode Selected");
				selector.setModel(new JComboBox<Useable>(tools).getModel());
				selector.setSelectedItem(selectedTool);
			});

			JRadioButton seedModeButton = new JRadioButton();
			seedModeButton.setText("Crops");
			group.add(seedModeButton);
			mouseModeOptions.add(seedModeButton);
			seedModeButton.addActionListener(actionevent -> {
				mouseMode = MouseModes.SEEDS;
				System.out.println("Crop Mode Selected");
				selector.setModel(new JComboBox<Useable>(crops).getModel());
				selector.setSelectedItem(selectedCrop);
			});
			
		}

		selector = new JComboBox<Useable>(tools);
		selector.setSelectedIndex(0);
		selector.setMaximumSize(new Dimension(selector.getMaximumSize().width, selector.getPreferredSize().height));
		selector.addActionListener(actionevent -> {
			selectedItem = selector.getItemAt(selector.getSelectedIndex());
			switch(mouseMode) {
			case TOOLS -> selectedTool = (Tool) selectedItem;
			case SEEDS -> selectedCrop = (Crop) selectedItem;
			}
		});

		main.add(mouseModeOptions);
		main.add(selector);

		this.setViewportView(main);

	}

	public Useable getSelectedItem() {
		return this.selectedItem;
	}

}
