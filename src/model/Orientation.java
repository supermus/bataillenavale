package model;

import java.util.Random;

public enum Orientation {
Horizontale,Verticale;

public static Orientation getRandomOrientation() {
Random random = new Random();
return values()[random.nextInt(values().length)];
}
}
