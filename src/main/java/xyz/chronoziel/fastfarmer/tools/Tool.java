package xyz.chronoziel.fastfarmer.tools;

import java.awt.Point;

import xyz.chronoziel.fastfarmer.GameElements;
import xyz.chronoziel.fastfarmer.board.Board;
import xyz.chronoziel.fastfarmer.board.tile.Crop;
import xyz.chronoziel.fastfarmer.board.tile.Tile;
import xyz.chronoziel.fastfarmer.board.tile.TileTypes;

public abstract class Tool implements Useable, Cloneable {

	private Tool() {
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static class Hoe extends Tool {

		public Hoe() {
			super();
		}

		@Override
		public void use() {
			GameElements gameElements = GameElements.getInstance();
			Board board = gameElements.getBoard();
			Point pos = gameElements.getMousePosition();

			if (!board.isValidIndex(pos))
				return;

			if (board.getTile(pos).getTileType().equals(TileTypes.GRASS)) {
				board.setTile(pos, new Tile(TileTypes.DRY_SOIL));
			}

		}

		@Override
		public String toString() {
			return "Hoe";
		}

	}

	public static class WateringCan extends Tool {

		public WateringCan() {
			super();
		}

		@Override
		public void use() {
			GameElements gameElements = GameElements.getInstance();
			Board board = gameElements.getBoard();
			Point pos = gameElements.getMousePosition();

			if (!board.isValidIndex(pos))
				return;

			if (board.getTile(pos).getTileType().equals(TileTypes.DRY_SOIL)) {

				if (board.getTile(pos) instanceof Crop crop) {
					board.setTile(pos, Crop.createCrop(crop.getCropType(), crop.getCropStage(), TileTypes.WET_SOIL));
					return;
				}

				board.setTile(pos, new Tile(TileTypes.WET_SOIL));
			}
		}

		@Override
		public String toString() {
			return "Watering Can";
		}
	}

	public static class Shovel extends Tool {

		public Shovel() {
			super();
		}

		@Override
		public void use() {
			GameElements gameElements = GameElements.getInstance();
			Board board = gameElements.getBoard();
			Point pos = gameElements.getMousePosition();

			if (!board.isValidIndex(pos))
				return;

			Tile tile = board.getTile(pos);	

			if (!(tile instanceof Crop)) 
				return;

			Crop crop = (Crop) tile;

			board.setTile(pos, new Tile(crop.getTileType()));
		}

		@Override
		public String toString() {
			return "Shovel";
		}

	}

}
