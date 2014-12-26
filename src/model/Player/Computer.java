package model.Player;

import model.Grid;
import model.Position;

public class Computer extends Player {
	
	public static int DIFFICULTY_EASY = 1;
	public static int DIFFICULTY_NORMAL = 2;
	public static int DIFFICULTY_HARD = 3;
	private int difficulty;

	public Computer(String nom, Grid g, int difficulty) {
		super(nom, g);
		this.difficulty = difficulty;
	}

	public Position gettarget(Grid g){
		Position position = null;
		int x,y;
		switch (this.difficulty) {
	case 1:
		x= (int)(Math.random() * (g.getSize() ));
		y= (int)(Math.random() * (g.getSize() ));
		while(g.isattacked(new Position(x, y))){
			x= (int)(Math.random() * (g.getSize()));
			y= (int)(Math.random() * (g.getSize()));
		}
		position=new Position(x, y);
		break;
	case 2:
		
		break;
	case 3:
		
		break;

		default:
			break;
		}
		
		
		
		
		
		
		
		return position;
		
		
		
	}
}
