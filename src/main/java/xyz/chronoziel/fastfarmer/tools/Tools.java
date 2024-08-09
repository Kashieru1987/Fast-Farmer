package xyz.chronoziel.fastfarmer.tools;

public enum Tools {
	HOE(new Tool.Hoe()),
	WATERING_CAN(new Tool.WateringCan()),
	SHOVEL(new Tool.Shovel());
	
	Tool tool;
	
	private Tools(Tool tool) {
		this.tool = tool;
	}
	
	public Tool getTool() {
		return (Tool) tool.clone();
	}
	
}
