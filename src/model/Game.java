package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.Timer;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import model.Player.*;
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
	
	public Game(ArrayList<Player> player, Battle mode, int mapSize,int nbSubmarine,int nbAircraftCarrier, int nbIronclad, int nbZodiac  ){
		this.player = player;
		this.mode = mode;
		this.mapSize = mapSize;
		this.nbSubmarine = nbSubmarine;
		this.nbIronclad = nbIronclad;
		this.nbAircraftCarrier = nbAircraftCarrier;
		this.nbZodiac = nbZodiac;
		this.time = 0;
		
		
		// Compteur pour le temps
		Timer timeCount = new Timer(1000, new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e) { time++; }
		});
		
	}
	
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
		if(player.get(0).win(player.get(1))){
			System.out.println("le gagnant est: "+player.get(0));
			}
		if(player.get(1).win(player.get(0))){
			System.out.println("le gagnant est: "+player.get(1));
			
		}
		
   
   }

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
   

   public void turncomputer(Computer player,Player adversaire){
	   mode.attack(player, adversaire, player.gettarget(adversaire.getGrid()));
	   for(int i=0;i<player.getGrid().getShip().size();i++){
		   System.out.println(player.getGrid().getShip().get(i).getState());
		   }
	   
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