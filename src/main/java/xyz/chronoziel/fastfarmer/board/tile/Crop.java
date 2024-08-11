package xyz.chronoziel.fastfarmer.board.tile;

import java.awt.Color;
import java.awt.Point;

import xyz.chronoziel.fastfarmer.GameElements;
import xyz.chronoziel.fastfarmer.board.Board;
import xyz.chronoziel.fastfarmer.tools.Useable;

public abstract class Crop extends Tile implements Useable {

	private CropStages cropStage;
	protected CropTypes cropType;
	protected Color cropColor;

	private Crop(CropStages cropStage, TileTypes tileType) {
		super(tileType);
		this.cropStage = cropStage;
	}

	private Crop(CropStages cropStage) {
		this(cropStage, TileTypes.WET_SOIL);
	}

	public Color getCropColor() {
		return this.cropColor;
	}
	
	public CropStages getCropStage() {
		return this.cropStage;
	}

	public static class Wheat extends Crop {
		
		public Wheat() {
			this(CropStages.SEED);
		}

		public Wheat(CropStages cropStage) {
			super(cropStage);
			this.cropType = CropTypes.WHEAT;
			this.cropColor = cropType.getCropColor();
		}

		@Override
		public void use() {
			GameElements gameElements = GameElements.getInstance();
			Board board = gameElements.getBoard();
			Point pos = gameElements.getMousePosition();
			
			if(!board.isValidIndex(pos))
				return;
			
			Tile tile = board.getTile(pos);
			if(tile instanceof Crop)
				return;
			
			if(tile.getTileType().equals(TileTypes.WET_SOIL)) {
				board.setTile(pos, new Crop.Wheat());
			}
			
		}
		
		@Override
		public String toString() {
			return "Wheat";
		}
		
	}
	
	public static class Pumpkin extends Crop {
		
		public Pumpkin() {
			this(CropStages.SEED);
		}

		public Pumpkin(CropStages cropStage) {
			super(cropStage);
			this.cropType = CropTypes.PUMPKIN;
			this.cropColor = cropType.getCropColor();
		}

		@Override
		public void use() {
			GameElements gameElements = GameElements.getInstance();
			Board board = gameElements.getBoard();
			Point pos = gameElements.getMousePosition();
			
			if(!board.isValidIndex(pos)) 
				return;
			
			Tile tile = board.getTile(pos);
			if(tile instanceof Crop)
				return;
			

			if(tile.getTileType().equals(TileTypes.WET_SOIL)) {
				board.setTile(pos, new Crop.Pumpkin());
			}
		}
		
		@Override
		public String toString() {
			return "Pumpkin";
		}

	}

}
