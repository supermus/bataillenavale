package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.Timer;

import model.Player.Computer;
import model.Player.Human;
import model.Player.Player;
import model.mode.Battle;

public class Game extends Observable {

	private ArrayList<Player> player;
	private Battle mode;
	private int mapSize;
	private int nbSubmarine;
	private int nbAircraftCarrier;
	private int nbIronclad;
	private int nbZodiac;
	private Timer timeCount;
	private int time;
	private int tour;

	/**
	 * Constructeur de Game
	 * @param player Liste des joueurs
	 * @param mode Mode de jeu
	 * @param mapSize Taille de la carte
	 * @param nbSubmarine Nombre de sous-marins
	 * @param nbAircraftCarrier Nombre de porte avions
	 * @param nbIronclad Nombre de cuirassés
	 * @param nbZodiac Nombre de zodiacs
	 */
	public Game(ArrayList<Player> player, Battle mode, int mapSize,int nbSubmarine,int nbAircraftCarrier, int nbIronclad, int nbZodiac  ){
		this.player = player;
		this.mode = mode;
		this.mapSize = mapSize;
		this.nbSubmarine = nbSubmarine;
		this.nbIronclad = nbIronclad;
		this.nbAircraftCarrier = nbAircraftCarrier;
		this.nbZodiac = nbZodiac;
		this.time = 0;
		this.tour=0;

		// Compteur pour le temps
		Timer timeCount = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { time++; }
		});

	}

	/**
	 * Lance une nouvelle partie
	 */
	public void start(){
		//	timeCount.start();
		int i=1;
		while(!player.get(0).win(player.get(1))&&!player.get(1).win(player.get(0))){

			System.out.println("Turn player"+i);
			this.turnplayer((Human) player.get(0), player.get(1));
			i++;
			System.out.println("Turn computer"+i);
			this.turncomputer((Computer) player.get(1), player.get(0));
			i++;	}
		


	}

	/**
	 * Execute le tour d'un joueur humain
	 * @param player Joueur humain
	 * @param adversaire Adversaire (human ou computer)
	 */
	public void turnplayer(Human player,Player adversaire){
		Scanner sc = new Scanner(System.in);
		int x, y;
		System.out.println("x=");
		x = sc.nextInt();
		System.out.println("y=");
		y = sc.nextInt();
		mode.attack(player, adversaire, new Position(x, y));
		for(int i=0;i<player.getGrid().getShip().size();i++){
			System.out.println(player.getGrid().getShip().get(i).getState());
		}
	}

	/**
	 * Execute le tour d'un ordinateur
	 * @param player Ordinateur
	 * @param adversaire Adversaire (human ou computer)
	 */
	public void turncomputer(Computer player,Player adversaire){
		mode.attack(player, adversaire, player.gettarget(adversaire.getGrid()));
		for(int i=0;i<player.getGrid().getShip().size();i++){
			System.out.println(player.getGrid().getShip().get(i).getState());
		}

	}

	/**
	 * Retourne la quantité maximum de Zodiac par joueur
	 * @return Quantité de Zodiac maximum
	 */
	public  int getNbZodiac(){
		return nbZodiac;
	}

	/**
	 * Retourne la quantité maximum de Cuirassés par joueur
	 * @return Quantité de Cuirassés maximum
	 */
	public int getNbIronclad(){
		return nbIronclad;
	}

	/**
	 * Retourne la quantité maximum de Porte-avions par joueur
	 * @return Quantité de Porte-avions maximum
	 */
	public int getNbAircraftCarrier(){
		return nbAircraftCarrier;
	}

	/**
	 * Retourne la quantité maximum de Sous-marins par joueur
	 * @return Quantité de Sous-marins maximum
	 */
	public int getNbSubmarine(){
		return nbSubmarine;
	}

	/**
	 * Retourne le temps écoulé depuis le début de la partie en secondes
	 * @return Temps écoulé en secondes
	 */
	public int getTime(){
		return time;
	}

	/**
	 * Retourne le tour courant
	 * @return tour courant
	 */
	public int getTurn(){
		return tour;
	}

	/**
	 * Vérifie si l'un des joueurs a gagné pour achever la partie
	 */
	public void checkVictory(){

	}

	/**
	 * Arrête une partie commencée
	 */
	public void end(){
		timeCount.stop();
	}

	/**
	 * Retourne la liste des joueurs
	 * @return Liste des joueurs
	 */
	public ArrayList<Player> getPlayer(){
		return player;
	}

	/**
	 * Retourne la taille de la carte
	 * @return taille de la carte
	 */
	public int getMapSize(){
		return mapSize;
	}
	/**
	 * Retourne ljoueur gagnant
	 * @return taille de la carte
	 */
	public Player winner() {
		// TODO Auto-generated method stub
		if(player.get(0).win(player.get(1))){
			return player.get(0);
		}
		else if(player.get(1).win(player.get(0))){
			return player.get(1);

		}
		else{
		return null;
		}	
	}

}
