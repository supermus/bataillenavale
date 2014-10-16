package model.ship;

import java.util.HashMap;
import java.util.Iterator;

import model.Position;

public abstract class Ship {
	
	private String name;
	private int size;
	private Position origin;
	private boolean orientation; // false = horizontal, true = vertical
	private HashMap<Position, Boolean> state;
	
	public Ship(String name, Position origin, int size, boolean orientation)
	{
		this.name = name;
		this.origin = origin;
		this.size = size;
		this.orientation = orientation;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public boolean hasPosition(int x, int y)
	{
		return hasPosition(new Position(x, y));
	}
	
	public boolean hasPosition(Position p)
	{
		return state.containsKey(p);
	}
	
	public void setPosition(Position p)
	{
		this.origin.setX(p.getX());
		this.origin.setY(p.getY());
	}
	
	public void setPosition(int x, int y)
	{
		this.origin.setX(x);
		this.origin.setY(y);
	}
	
	public boolean isDead()
	{
		int alive = 0;
		Iterator it = state.keySet().iterator();
		while(it.hasNext())
			if(state.get(it.next()).booleanValue())
				alive++;
		return (alive != 0);
	}
	
	

}
