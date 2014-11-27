package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import model.Computer;
import model.Game;
import model.GameMode;
import model.Human;
import model.Player;
import core.BatailleNavale;
import view.GameConfigView;

public class GameConfigController extends Controller{

	private BatailleNavale batailleNavale;
	private ArrayList<Player> player;
	private GameMode gameMode;
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
	
	
	public GameConfigController(BatailleNavale bn){
		  
			batailleNavale = bn;
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
				
				if(ModeJeux == "Demo"){
					player.add(new Computer("Computer1"));
					player.add(new Computer("Computer2"));
				    gameMode = (GameMode) (Object)TypeBataille;
					game = new Game(player,gameMode,TailleMap);
					
				}
				
				}
			else if (e.getSource() == ((GameConfigView)view).btnAnnuler){
				System.out.println("Retour au MENU");
				batailleNavale.changeScreen(new MenuController(batailleNavale));
			}
			
		}

}
