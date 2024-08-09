package xyz.chronoziel.fastfarmer.tools;

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
		public void useTool() {
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
		public void useTool() {
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
		public void useTool() {
			
		}
		
		@Override
		public String toString() {
			return "Shovel";
		}

	}

}
