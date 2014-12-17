package model.ship;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import model.Grid;
import model.Orientation;
import model.Position;

public abstract class Ship {
	
	private String name;
	private int size; //La taille du navire
	private Position origin; //position de la  premiere case du navire
	private Orientation orientation; // orientation du navire top right bot left
	private HashMap<Position, Boolean> state = new HashMap<Position, Boolean>(); //Position(String)  et l'etat(Boolean true=pas touché false=touché) de chaque case du navire 
	
//	public Ship(String name, Position origin, int size, Orientation orientation)
//	{
//		this.name = name;
//		this.origin = origin;
//		this.size = size;
//		this.orientation = orientation;
//		state=new HashMap<Position, Boolean>();
//		switch (orientation) {
//		case BOT:
//			for (int i = 0; i < size; i++) {
//				state.put(new Position(origin.getX(),origin.getY()-i), true);
//			}
//			break;
//		case TOP:
//			for (int i = 0; i < size; i++) {
//				state.put(new Position(origin.getX(),origin.getY()+i), true);
//			}
//			break;
//		case LEFT:
//			for (int i = 0; i < size; i++) {
//				state.put(new Position(origin.getX()-i,origin.getY()), true);
//			}
//			break;
//		case RIGHT:
//			for (int i = 0; i < size; i++) {
//				state.put(new Position(origin.getX()+i,origin.getY()-i), true);
//			}
//			break;
//		}
//	}
	
	public Ship(String name, Position origin, int size, Orientation orientation)
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
	
	//si la position choisit contient un navire
	
	public boolean hasPosition(int x, int y)
	{
		return hasPosition(new Position(x, y));
	}
	
	public boolean hasPosition(Position p)
	{
		Boolean boll=false;
		for (Entry<Position, Boolean> entry : this.getState().entrySet()) {
            if (entry.getKey().equals(p)) {
            	boll=true;
            	break;
            }
            else{
            	boll=false;
            }
		}
		
		return boll;
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
		state.put(position, false);
	}
	
	
	public String getName() {
		return name;
	}


	public HashMap<Position, Boolean> getState() {
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
