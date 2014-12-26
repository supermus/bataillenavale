package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import model.Game;
import model.Grid;
import model.Player.Computer;
import model.Player.Human;
import model.Player.Player;
import model.mode.Artillery;
import model.mode.Battle;
import model.mode.Classic;
import model.mode.Radar;
import model.mode.RedAlert;
import view.GameConfigView;
import core.BatailleNavale;

public class GameConfigController extends AbstractController{
	
	
	public GameConfigController()
	{
		view = new GameConfigView(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		GameConfigView configView = (GameConfigView) view;
		String playerName, gameType, difficulty, battleType;
		int mapSize, amountBoat1, amountBoat2, amountBoat3, amountBoat4;
		
		if(e.getSource() == configView.btnValider)
		{
			// extraction des valeurs de configuration
			playerName = configView.txtUsername.getText();	
			gameType = configView.bg0.getSelection().getActionCommand();
			mapSize = Integer.parseInt(configView.bg1.getSelection().getActionCommand());
			difficulty = configView.bg2.getSelection().getActionCommand();
			battleType = configView.bg3.getSelection().getActionCommand();
			amountBoat1 = (int) configView.spinnerSousMarin.getValue();
			amountBoat2 = (int) configView.spinnerPorteAvion.getValue();
			amountBoat3 = (int) configView.spinnerCuirassésFurtif.getValue();
			amountBoat4 = (int) configView.spinnerZodiac.getValue();
			
			// préparation de la partie
			Battle battle = null;
			ArrayList<Player> players = new ArrayList<Player>();
			int computerDifficulty = Computer.DIFFICULTY_EASY;
			Game game = null;

			// type de bataille
			if(battleType.equals("BatailleNavalle"))
				battle = new Classic();
			if(battleType.equals("AlerteRouge"))
				battle = new RedAlert();
			if(battleType.equals("Artillerie"))
				battle = new Artillery();
			if(battleType.equals("Radar"))
				battle = new Radar();
			
			// niveau ordinateurs
			if(difficulty.equals("Facile"))
				computerDifficulty = Computer.DIFFICULTY_EASY;
			else if(difficulty.equals("Intermédiaire"))
				computerDifficulty = Computer.DIFFICULTY_NORMAL;
			else
				computerDifficulty = Computer.DIFFICULTY_HARD;
			
			// type de partie
			if(gameType.equals("Demo"))
			{
				players.add(new Computer("Computer1", new Grid(mapSize), computerDifficulty));
				players.add(new Computer("Computer2", new Grid(mapSize), computerDifficulty));
			}
			else if(gameType.equalsIgnoreCase("1 Joueur"))
			{
				players.add(new Human(playerName, new Grid(mapSize)));
				players.add(new Computer("Computer2", new Grid(mapSize), computerDifficulty));
			}
			
			System.out.println("Préparation d'une nouvelle partie");
			System.out.println("type : " + battleType + " (" + gameType + ")");
			System.out.println("map de taille " + mapSize + "x" + mapSize);
			System.out.println("limites : " + amountBoat1 + " sous-marins, " + amountBoat2 + " porteavions, " + amountBoat3 + " cuirassés, " + amountBoat4 + " zodiacs.");
			
			game = new Game(players, battle, mapSize, amountBoat1, amountBoat2, amountBoat3, amountBoat4);
			BatailleNavale.changeScreen(new GameController(game)); // passage à GameController
		}
		else if (e.getSource() == configView.btnAnnuler)
		{
				BatailleNavale.changeScreen(new MenuController()); // retour menu
		}
			
	} // fin actionPerformed

}
