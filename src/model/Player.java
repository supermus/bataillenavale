package model;

import java.util.*;

import model.ship.*;

public abstract class Player {

	
	private String nom;
	private String Statu;
	private int score;
	private int attacks;
	private int hits;
	private int miss;
	
	
	public Player(String nom) {
		this.nom = nom;
		this.score = 0;
		this.attacks = 0;
		this.hits = 0;
		this.miss = 0;
	}
	
	@Override
	public String toString() {
		return "Player [nom=" + nom + ", Statu=" + Statu + ", nombre d'attaques="
				+ attacks + ", score=" + score + "]";
	}

	public void setScore(int score) {
		this.score += score;
	}
	

	public int getAttacks(Grid grid) {
		return grid.getAttacks().size();
	}


	public int getHits(Grid grid) {
		return grid.getHits().size();
	}


	public int getMiss(Grid grid) {
		return grid.getMissed().size();
	}


	public int getScore() {
		return score;
	}
	
	public String getNom()
	{
		return nom;
	}


}
