package model;

import java.util.ArrayList;

public class Game {
	
	private ArrayList<Player> player;
	private GameMode mode;
	private int mapSize;

	
	public Game(ArrayList<Player> player, GameMode mode, int mapSize)
	{
		this.player = player;
		this.mode = mode;
		this.mapSize = mapSize;
		
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
