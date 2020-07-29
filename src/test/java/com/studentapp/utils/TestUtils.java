package com.studentapp.utils;

import java.util.Random;

public class TestUtils {
	
	public static String getRandomName() {
		Random random = new Random();
		int randomVal = random.nextInt(1000);
		return "Name_" + Integer.toString(randomVal);
	}
}
