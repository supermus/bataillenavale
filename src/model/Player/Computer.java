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
		//g.getAttacks().add(new  Position(2, 2));
		if (position== null) {
			x= (int)(Math.random() * (g.getSize() ));
			y= (int)(Math.random() * (g.getSize() ));
		position=new Position(x, y);	
		}
		if(!g.getHits().isEmpty()){
			x=g.getHits().get(g.getHits().size()-1).getX()-1;
			y=g.getHits().get(g.getHits().size()-1).getY()+1;
		for(int i=0;i<2;i++){
			if(!g.isattacked(new Position(x, y))){
				position=new Position(x, y);
				break;
			}
			else{
				x++;
			}
		}
		for(int i=0;i<2;i++){
			if(!g.isattacked(new Position(x, y))){
				position=new Position(x, y);
				break;
			}
			else{
				y--;
			}
		}
		for(int i=0;i<2;i++){
			if(!g.isattacked(new Position(x, y))){
				position=new Position(x, y);
				break;
			}
			else{
				x--;
			}
		}
		for(int i=0;i<2;i++){
			if(!g.isattacked(new Position(x, y))){
				position=new Position(x, y);
				break;
			}
			else{
				y++;
			}
		}
		}
		break;
	case 3:
		
		break;

		default:
			break;
		}
		return position;
		
		
		
	}
}
