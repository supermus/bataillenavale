import java.util.ArrayList;

import model.Grid;
import model.Orientation;
import model.Position;
import model.Player.Computer;
import model.Player.Human;
import model.Player.Player;
import model.mode.Classic;
import model.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grid g=new Grid(12);
		Grid g2=new Grid(12);
		Computer cp=new Computer("cp", g, 2);
		Human pl=new Human("walid",g2);
		Classic cl=new Classic();
		cp.placeBoat("AircraftCarrier", new Position(2, 2), Orientation.Verticale);

		pl.placeBoat("AircraftCarrier", new Position(10, 2), Orientation.Verticale);
		pl.placeBoat("AircraftCarrier", new Position(5, 2), Orientation.Verticale);
		pl.placeBoat("AircraftCarrier", new Position(6, 2), Orientation.Verticale);
		/*cl.attack(cp, pl, new Position(1, 3));
		cl.attack(cp, pl, new Position(2, 3));
		cl.attack(cp, pl, new Position(3, 3));
		cl.attack(cp, pl, new Position(3, 2));
		cl.attack(cp, pl, new Position(3, 1));
		cl.attack(cp, pl, new Position(2, 1));
		cl.attack(cp, pl, new Position(1, 1));
		cl.attack(cp, pl, new Position(1, 2));
		cl.attack(cp, pl, new Position(1, 2));*/
		//cl.attack(pl, cp, new Position(2, 3));
		//cl.attack(pl, cp, new Position(2, 4));
		//cl.attack(pl, cp, new Position(2, 5));
		//cl.attack(pl, cp, new Position(2, 6));
	/*	System.out.println(cp.getGrid().getShip().get(0).getState());
		System.out.println(cp.getGrid().getShip().get(0).isDead());
		System.out.println(pl.win(cp));
		*/
		ArrayList<Player> player=new ArrayList<Player>();
	//	pl.getGrid().addhits(new Position(5, 2));
		player.add(pl);
		player.add(cp);
		Game gm=new Game(player, cl, 12, 0, 1, 0, 0);
		gm.start();
		//System.out.println(cp.gettarget(pl.getGrid()).toString());
		//System.out.println(cp.getGrid().getShip().get(0).getState());
	}

}
