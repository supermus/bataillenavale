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
	
	public GameController(Game g)
	{
		this.game = g;
		this.view = new GameContainerView(this, g);
		GameContainerView containerView = (GameContainerView) view;
	}
	
	public Game getGame()
	{
		return game;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		GameContainerView containerView = (GameContainerView) view;
		String boatType, orientation;
		int x, y;
		if(e.getSource()== containerView.btnValidate );
		{
			//Extraction des données
			boatType = containerView.comboBoxBoat.getName();
			orientation = containerView.comboBoxOrien.getName();
			x = (int) containerView.spinnerAxeX.getValue();
			y = (int) containerView.spinnerAxeY.getValue();
			//game.getPlayer().get(0).placeBoat(name, origin, size, orientation);
		}
		
		if(e.getSource() == containerView.btnRemoveLastBoat){
			
		}
		
		if(e.getSource()== containerView.btnGameStart){
			
		}
	}
	

}
