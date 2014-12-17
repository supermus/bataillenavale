package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.Timer;

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

	

	
	public Game(ArrayList<Player> player, Battle mode, int mapSize,int nbSubmarine,int nbAircraftCarrier, int nbIronclad, int nbZodiac  ){
		this.player = player;
		this.mode = mode;
		this.mapSize = mapSize;
		this.nbSubmarine = nbSubmarine;
		this.nbIronclad = nbIronclad;
		this.nbAircraftCarrier = nbAircraftCarrier;
		this.nbZodiac = nbZodiac;
		this.time = 0;
		this.tour = 0;
		
		
		// Compteur pour le temps
		Timer timeCount = new Timer(1000, new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e) { time++; }
		});
		
	}
	
   public void start(){
		timeCount.start();
	}
	
   public  int getNbZodiac(){
	   return nbZodiac;
   }
   
   public int getNbIronclad(){
	   return nbIronclad;
    }
    
   public int getNbAircraftCarrier(){
    	return nbAircraftCarrier;
    }
    
   public int getNbSubmarine(){
		return nbSubmarine;
	}
	
	public int getTurn(){
		return tour;
	}
	
	public int getTime(){
		return time;
	}
	
	public void checkVictory(){
		
	}
	
	public void end(){
		timeCount.stop();
	}
	public ArrayList<Player> getPlayer(){
		return player;
	}
	
	public void setPlayer(ArrayList<Player>player){
		this.player = player;
	}
	
	public int getMapSize(){
		return mapSize;
	}
	
	public void setMapSize(int mapSize){
		this.mapSize = mapSize;
	}

}
