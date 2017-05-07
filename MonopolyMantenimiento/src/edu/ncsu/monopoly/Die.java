package edu.ncsu.monopoly;

import java.util.Random;

public class Die {
	public int getRoll() {
            Random r = new Random();
            return r.nextInt(5) + 1;
	}
}
