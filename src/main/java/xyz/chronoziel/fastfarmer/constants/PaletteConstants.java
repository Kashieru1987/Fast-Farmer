package xyz.chronoziel.fastfarmer.constants;

import java.awt.Dimension;
import java.awt.Point;

public class PaletteConstants {

	private PaletteConstants() {
	}

	public final static String TITLE = "Palette";
	public final static Dimension SIZE = new Dimension(300, GeneralConstants.SIZE.height);
	public final static Point POSITION = new Point(2 + GeneralConstants.POSITION.x + GeneralConstants.SIZE.width, GeneralConstants.POSITION.y);

}