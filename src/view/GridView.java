package view;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.Game;
import model.Player;
import model.Position;
import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Ship;
import model.ship.Submarine;
import model.ship.Zodiac;
import controller.GameController;

public class GridView extends AbstractView implements Observer {

	private static Game game;
	private JLabel[][] cells;
	private boolean isHuman;
	private int idPlayer;
	
	// Sprites pour les cases
	private ImageIcon iconWater;
	private ImageIcon iconHit;
	private ImageIcon iconMiss;
	private ImageIcon iconBoat1;
	private ImageIcon iconBoat2;
	private ImageIcon iconBoat3;
	private ImageIcon iconBoat4;

	/**
	 * Constructeur de test UNIQUEMENT !
	 */
	public GridView() {
		super(new GameController(null));
		isHuman = false;
		setLayout(new GridLayout(2, 2, 1, 1));

		JButton btnNewButton_1 = new JButton();
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton();
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton();
		add(btnNewButton_3);

		JButton btnNewButton = new JButton();
		add(btnNewButton);

	}

	/**
	 * Constructeur de GridView
	 * @param c instance de GameController
	 * @param mapSize entier donnant la taille de la grille
	 * @param isHuman indique si la grille appartient à un humain
	 */
	public GridView(GameController c, boolean isHuman, int idPlayer) {
		super(c);
		this.isHuman = isHuman;
		this.idPlayer = idPlayer;
		// chargement et redimensionnement des sprites;
		this.iconWater = new ImageIcon(new ImageIcon("assets/water.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconHit = new ImageIcon(new ImageIcon("assets/hit.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconMiss = new ImageIcon(new ImageIcon("assets/miss.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat1 = new ImageIcon(new ImageIcon("assets/boat1.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat2 = new ImageIcon(new ImageIcon("assets/boat2.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat3 = new ImageIcon(new ImageIcon("assets/boat3.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat4 = new ImageIcon(new ImageIcon("assets/boat4.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		setLayout(new GridLayout(c.getGame().getMapSize(), c.getGame().getMapSize(), 1, 1));
		
		cells = new JLabel[c.getGame().getMapSize()][c.getGame().getMapSize()];
		for(int i = 0; i<c.getGame().getMapSize(); i++) {
			for(int j = 0; j<c.getGame().getMapSize(); j++)
			{
				JLabel btn = new JLabel(iconWater);
				cells[i][j] = btn;
				if(!isHuman)
					btn.addMouseListener((GameController)this.controller); // ajout écouteur
				add(btn); // ajout à la GUI
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		ArrayList<Player> players = game.getPlayer();
		if(idPlayer == 0)
		{
			for(Ship s : players.get(0).getGrid().getShip())
			{
				Iterator<Entry<Position, Boolean>> it = s.getState().entrySet().iterator();
				while(it.hasNext())
				{
					Entry<Position, Boolean> e = it.next();
					this.setBoat(s.getName(), e.getKey(), e.getValue(), isHuman);
				}
			}
			
			// coups manqués
			for(Position p : players.get(1).getGrid().getMissed())
			{
				this.setMissed(p);
			}
		} else {
			for(Ship s : players.get(1).getGrid().getShip())
			{
				Iterator<Entry<Position, Boolean>> it = s.getState().entrySet().iterator();
				while(it.hasNext())
				{
					Entry<Position, Boolean> e = it.next();
					this.setBoat(s.getName(), e.getKey(), e.getValue(), isHuman);
				}
			}
			
			// coups manqués
			for(Position p : players.get(0).getGrid().getMissed())
			{
				this.setMissed(p);
			}
		}
	}
	
	public void setMissed(Position pos)
	{
		cells[pos.getX()][pos.getY()].setIcon(iconMiss);
	}
	
	/**
	 * Remplace l'image d'une case contenant un morceau de bateau
	 * @param name nom du bateau (type)
	 * @param state état (détruit ou pas)
	 * @param destroyedOnly indique si on doit uniquement afficher les bateaux détruits ou tous les bateaux
	 */
	public void setBoat(String name, Position pos, boolean state, boolean destroyedOnly)
	{
		if(name.equals(AircraftCarrier.SHIP_NAME))
		{
			if(!state) // détruit
				cells[pos.getX()][pos.getY()].setIcon(iconHit);
			else
				if(!destroyedOnly)
					cells[pos.getX()][pos.getY()].setIcon(iconBoat1);
			
		}
		
		if(name.equals(Ironclad.SHIP_NAME))
		{
			if(!state) // détruit
				cells[pos.getX()][pos.getY()].setIcon(iconHit);
			else
				if(!destroyedOnly)
					cells[pos.getX()][pos.getY()].setIcon(iconBoat2);
			
		}
		
		if(name.equals(Submarine.SHIP_NAME))
		{
			if(!state) // détruit
				cells[pos.getX()][pos.getY()].setIcon(iconHit);
			else
				if(!destroyedOnly)
					cells[pos.getX()][pos.getY()].setIcon(iconBoat3);
			
		}
		
		if(name.equals(Zodiac.SHIP_NAME))
		{
			if(!state) // détruit
				cells[pos.getX()][pos.getY()].setIcon(iconHit);
			else
				if(!destroyedOnly)
					cells[pos.getX()][pos.getY()].setIcon(iconBoat4);
			
		}
	}

	/**
	 * Indique si la grille appartient à un joueur humain (permet de décider ce qui doit être affiché ou non)
	 * @return boolean true si humain, false sinon
	 */
	public boolean isHuman()
	{
		return isHuman;
	}
}
