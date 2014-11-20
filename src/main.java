
import model.*;
import model.mode.Battle;


public class main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1=new Human("Player1");
		Player p2=new Human("Player2");
		Grid g1=new Grid(12, p1);
		Grid g2=new Grid(12, p2);
		Battle battle=new Battle();
		battle.PlaceShip(g2, "Ironclad", new Position(12, 29), Orientation.TOP );
		System.out.println(g2.getShip().get(0).getState());
		battle.attack(g1, g2, new Position(12, 29));
		battle.attack(g1, g2, new Position(12, 29));
		System.out.println(p1.getScore());
		System.out.println(p2.getScore());
		System.out.println(g2.getShip().get(0).getState());
	
	}

}