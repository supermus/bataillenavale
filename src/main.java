
import model.*;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1=new Human("Player1");
		Player p2=new Human("Player2");
		Battle battle=new Battle();
		battle.PlaceShip(p2, "Ironclad", new Position(12, 29), Orientation.TOP );
		System.out.println(p2.getShip().get(0).getState());
		battle.attack(p1, p2, new Position(12, 20));
		battle.attack(p1, p2, new Position(12, 21));
		battle.attack(p1, p2, new Position(12, 22));
		System.out.println(p1.getScore());
		System.out.println(p2.getShip().get(0).getState());
	
	}

}
