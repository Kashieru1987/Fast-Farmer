package xyz.chronoziel.fastfarmer.constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class GeneralConstants {

	private GeneralConstants() {
	}

	public final static String TITLE = "Fast Farmer - Chronoziel";
	public final static Point POSITION = new Point(10, 10);
	public final static int FRAME_WIDTH_OFFSET = 16;
	public final static int FRAME_HEIGHT_OFFSET = 39;
	public final static Dimension SIZE = new Dimension(FRAME_WIDTH_OFFSET + 800, FRAME_HEIGHT_OFFSET + 639);
	public final static Dimension DEFAULT_BOARD_SIZE = new Dimension(10, 10);
	public final static Dimension PANEL_SIZE = new Dimension(600, 600);
	public final static Color BACKGROUND_COLOR = Color.DARK_GRAY;
	public static final Color GRID_LINE_COLOR = Color.DARK_GRAY;
	public static final Color MOUSE_POINTER_COLOR = Color.RED;
	public static final int TARGET_FPS = 60;

}
