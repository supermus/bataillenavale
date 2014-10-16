package model;

import java.util.ArrayList;

public class Game {
	
	private ArrayList<Player> player;
	private GameMode mode;
	private Battle battle;
	private int mapSize;

	
	public Game(ArrayList<Player> player, GameMode mode, Battle battle, int mapSize)
	{
		this.player = player;
		this.GameMode = mode;
		this.battle = battle;
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
	public Player getPlayer()
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
