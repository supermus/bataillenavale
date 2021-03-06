package model;

import java.util.ArrayList;
import java.util.Observable;

import model.mode.Battle;

public class Game extends Observable {
	
	private ArrayList<Player> player;
	private Battle mode;
	private int mapSize;
	private int nbSousMarin;
	private int nbPorteAvion;
	private int nbCuirassésFurtif;
	private int nbZodiac;

	
	public Game(ArrayList<Player> player, Battle mode, int mapSize,int nbSousMarin,int nbPorteAvion, int nbCuirassésFurtif, int nbZodiac  )
	{
		this.player = player;
		this.mode = mode;
		this.mapSize = mapSize;
		this.nbSousMarin = nbSousMarin;
		this.nbCuirassésFurtif = nbCuirassésFurtif;
		this.nbPorteAvion = nbPorteAvion;
		this.nbZodiac = nbZodiac;
		
	}
	
	public void start()
	{
		
	}
	
	public void checkVictory()
	{
		
	}
	
	public void end()
	{
		
	}
	public ArrayList<Player> getPlayer()
	{
		return player;
	}
	
	public void setPlayer(ArrayList<Player>player){
		
		this.player = player;
	}
	
	public int getMapSize()
	{
		return mapSize;
	}
	
	public void setMapSize(int mapSize)
	{
		this.mapSize = mapSize;
	}

}
