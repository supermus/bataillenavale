package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import model.Computer;
import model.Game;
import model.Human;
import model.Player;
import model.mode.Artillery;
import model.mode.Battle;
import model.mode.Classic;
import model.mode.Radar;
import model.mode.RedAlert;
import view.GameConfigView;
import core.BatailleNavale;

public class GameConfigController extends AbstractController{
	private ArrayList<Player>player = new ArrayList<Player>();
	private Battle gameMode;
	private Game game;
	private Computer com;
	private String speudo;
	private String ModeJeux;
	private int TailleMap;
	private String Difficulter;
	private String TypeBataille;
	private int nbSousMarin;
	private int nbPorteAvion;
	private int nbCuirassésFurtif;
	private int nbZodiac;
	
	
	public GameConfigController(){
			view = new GameConfigView(this);
		}
	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == ((GameConfigView)view).btnValider){
				System.out.println("Début d'une partie");
				speudo =((GameConfigView)view).txtUsername.getText();
				System.out.println(speudo);
		
				//player = new Human(speudo);
				
				
				// Nombre de joeur de la partie
				ModeJeux=((GameConfigView)view).bg0.getSelection().getActionCommand();
				System.out.println(ModeJeux);
				
				//Taille de la map
				TailleMap=Integer.parseInt(((GameConfigView)view).bg1.getSelection().getActionCommand());
				System.out.println(TailleMap);
				
				//Dificulter de la partie
				Difficulter=((GameConfigView)view).bg2.getSelection().getActionCommand();
				System.out.println(Difficulter);
				
				//Dificulter de la partie
				TypeBataille=((GameConfigView)view).bg3.getSelection().getActionCommand();
				System.out.println(TypeBataille);
				
				// Récupération des spinner
				nbSousMarin = (Integer) ((GameConfigView)view).spinnerSousMarin.getValue();
				System.out.println("Nombre de Sous-Marin : "+nbSousMarin);
				nbPorteAvion = (Integer) ((GameConfigView)view).spinnerPorteAvion.getValue();
				System.out.println("Nombre de porte Avion :" +nbPorteAvion);
				nbCuirassésFurtif = (Integer) ((GameConfigView)view).spinnerCuirassésFurtif.getValue();
				System.out.println("Nombre de Cuirassés Furtif : "+nbCuirassésFurtif);
				nbZodiac = (Integer) ((GameConfigView)view).spinnerZodiac.getValue();
				System.out.println("Nombre de Zodiac : "+nbZodiac);
				if(TypeBataille.equals("BatailleNavalle"))
					gameMode = new Classic();
				if(TypeBataille.equals("AlerteRouge"))
					gameMode = new RedAlert();
				if(TypeBataille.equals("Artillerie"))
					gameMode = new Artillery();
				if(TypeBataille.equals("Radar"))
					gameMode = new Radar();
				
				switch (ModeJeux){
				case "Demo" : player.add(new Computer("Computer1"));
							  player.add(new Computer("Computer2"));
							  game = new Game(player,gameMode,TailleMap,nbSousMarin,nbPorteAvion,nbCuirassésFurtif,nbZodiac);
							  break;
				
				case "1 Joueur" : player.add(new Computer("Computer1"));
				  				  player.add(new Human(speudo));
				  				  game = new Game(player,gameMode,TailleMap,nbSousMarin,nbPorteAvion,nbCuirassésFurtif,nbZodiac);
				  				  break;
				}
				
				BatailleNavale.changeScreen(new GameController(game));
//				if(ModeJeux == "Demo"){
//					player.add(new Computer("Computer1"));
//					player.add(new Computer("Computer2"));
//				    gameMode = (GameMode) (Object)TypeBataille;
//					game = new Game(player,gameMode,TailleMap);
//					
//				}
				
				}
			else if (e.getSource() == ((GameConfigView)view).btnAnnuler){
				System.out.println("Retour au MENU");
				BatailleNavale.changeScreen(new MenuController());
			}
			
		}

}
