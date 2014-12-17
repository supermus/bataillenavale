package controller;

import java.awt.event.ActionEvent;

import model.Game;
import model.Orientation;
import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Submarine;
import model.ship.Zodiac;
import view.GameConfigView;
import view.GameContainerView;

public class GameController extends AbstractController {
	
	Game game;
	
	public GameController(Game g){
		this.game = g;
		this.view = new GameContainerView(this);
		((GameContainerView)this.view).setModel(this.game);
		
		GameContainerView containerView = (GameContainerView) view;
		for(Orientation orien : Orientation.values()){
			containerView.comboBox_1.addItem(orien);
		}
		for(int i=0; i<game.getNbAircraftCarrier(); i++){
			containerView.comboBox.addItem(AircraftCarrier.SHIP_NAME);
		}
		
		for(int i=0; i<game.getNbIronclad(); i++){
			containerView.comboBox.addItem(Ironclad.SHIP_NAME);
		}
		for(int i=0; i<game.getNbSubmarine(); i++){
			containerView.comboBox.addItem(Submarine.SHIP_NAME);
		}
		for(int i=0; i<game.getNbZodiac(); i++){
			containerView.comboBox.addItem(Zodiac.SHIP_NAME);
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}
	

}
