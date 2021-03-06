package model;

import java.util.*;
import model.ship.*;

public abstract class Player {

	
	private String nom; // nom du joueur ou de l'ordinateur
	private String status; // �tat du joueur (gagnant/perdant)
	private int score; 
	private int hits;
	private int miss;
	private Grid grid;
	
	
	public Player(String nom, Grid g) {
		this.nom = nom;
		this.score = 0;
		this.hits = 0;
		this.miss = 0;
		this.grid = g;
		this.status = "inconnu";
	}
	
	@Override
	public String toString() {
		return "Player [nom=" + nom + ", status=" + status + ", nombre d'attaques="
				+ (miss+hits) + ", score=" + score + "]";
	}
	

	public int getAttacks() {
		return hits + miss;
	}


	public int getHits() {
		return hits;
	}


	public int getMiss() {
		return miss;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score)
	{
		this.score += score;
	}

	public int getScore() {
		return score;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public Grid getGrid()
	{
		return grid;
	}
	
	public void addHit()
	{
		this.hits++;
	}
	
	public void addMiss()
	{
		this.miss++;
	}

}
