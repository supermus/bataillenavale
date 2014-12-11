package model;

import java.util.*;
import model.ship.*;

public abstract class Player {

	
	private String 	nom; 	// nom du joueur ou de l'ordinateur
	private String 	status; // �tat du joueur (gagnant/perdant)
	private int		score; 	// score courant
	private int 	hits; 	// compteur coups r�ussis
	private int 	miss; 	// compteur coups rat�s
	private Grid 	grid; 	// grille
	
	/**
	 * Constructeur principal de Player
	 * @param nom Nom du joueur
	 * @param g grille associ�e � ce joueur
	 */
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
	
	/**
	 * Retourne le nombre de coups total du joueur
	 * @return int nombre de coups
	 */
	public int getAttacks() {
		return hits + miss;
	}

	/**
	 * Retourne le nombre de coups r�ussis du joueur
	 * @return int nombre de coups r�ussis
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * Retourne le nombre de coups rat�s du joueur
	 * @return int nombre de coups rat�s
	 */
	public int getMiss() {
		return miss;
	}

	/**
	 * Remplace le score du joueur
	 * @param score nouvelle valeur du score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Incr�mente le score du joueur
	 * @param score montant � ajouter au score
	 */
	public void addScore(int score)
	{
		this.score += score;
	}

	/**
	 * Retourne le score courant du joueur
	 * @return int valeur du score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Retourne le nom du joueur
	 * @return String nom du joueur
	 */
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Retourne la grille du joueur
	 * @return Grid grille du joueur
	 */
	public Grid getGrid()
	{
		return grid;
	}
	
	/**
	 * Incr�mente de 1 le compteur de coups r�ussis
	 */
	public void addHit()
	{
		this.hits++;
	}
	
	/**
	 * Incr�mente de 1 le compteur de coups rat�s
	 */
	public void addMiss()
	{
		this.miss++;
	}

}
