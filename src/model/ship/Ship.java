package model.ship;

import java.util.HashMap;
import java.util.Iterator;
import model.Orientation;
import model.Position;

public abstract class Ship {
	
	private String name;
	private int size; //La taille du navire
	private Position origin; //position de la  premiere case du navire
	private Orientation orientation; // orientation du navire top right bot left
	private HashMap<String, Boolean> state; //Position(String)  et l'etat(Boolean true=pas touché false=touché) de chaque case du navire 
	
	public Ship(String name, Position origin, int size, Orientation orientation)
	{
		this.name = name;
		this.origin = origin;
		this.size = size;
		this.orientation = orientation;
		state=new HashMap<String, Boolean>();
		switch (orientation) {
		case BOT:
			for (int i = 0; i < size; i++) {
				state.put(new Position(origin.getX(),origin.getY()-i).toString(), true);
			}
			break;
		case TOP:
			for (int i = 0; i < size; i++) {
				state.put(new Position(origin.getX(),origin.getY()+i).toString(), true);
			}
			break;
		case LEFT:
			for (int i = 0; i < size; i++) {
				state.put(new Position(origin.getX()-i,origin.getY()).toString(), true);
			}
			break;
		case RIGHT:
			for (int i = 0; i < size; i++) {
				state.put(new Position(origin.getX()+i,origin.getY()-i).toString(), true);
			}
			break;
		}
	}
	
	
	public int getSize()
	{
		return this.size;
	}
	//si la position choisit contient un navire
	
	public boolean hasPosition(int x, int y)
	{
		return hasPosition(new Position(x, y));
	}
	
	public boolean hasPosition(Position p)
	{
		return state.containsKey(p.toString());
	}
	
	//modifier 1er case du navire
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
	
	
	public void setStates(Position position) {
		state.put(position.toString(), false);
	}
	
	
	public String getName() {
		return name;
	}


	public HashMap<String, Boolean> getState() {
		return state;
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
