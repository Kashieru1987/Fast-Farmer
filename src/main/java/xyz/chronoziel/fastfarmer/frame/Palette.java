package xyz.chronoziel.fastfarmer.frame;

import javax.swing.JScrollPane;

import xyz.chronoziel.fastfarmer.constants.GeneralConstants;
import xyz.chronoziel.fastfarmer.constants.PaletteConstants;

public class Palette extends JScrollPane {

	public Palette() {
		this.setMinimumSize(PaletteConstants.SIZE);
		this.getViewport().setBackground(GeneralConstants.BACKGROUND_COLOR);
	}

}
