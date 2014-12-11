package model;

public class Computer extends Player {
	
	public static int DIFFICULTY_EASY = 1;
	public static int DIFFICULTY_NORMAL = 2;
	public static int DIFFICULTY_HARD = 3;
	
	private int difficulty;

	public Computer(String nom, Grid g, int difficulty) {
		super(nom, g);
		this.difficulty = difficulty;
	}

}
