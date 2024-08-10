package xyz.chronoziel.fastfarmer.board;

public class ThreadUtil {

	private ThreadUtil() {
	}

	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
