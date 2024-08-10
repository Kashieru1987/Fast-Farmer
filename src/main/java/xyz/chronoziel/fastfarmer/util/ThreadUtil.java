package xyz.chronoziel.fastfarmer.util;

import java.util.Random;

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

	public static void sleepAndVary(long sleepms, long varyms) {
		varyms = (int) (varyms * Math.random());
		
		if(new Random().nextBoolean()) {
			sleep(sleepms + varyms);
			return;
		}
		sleep(sleepms - varyms);
	}

}
