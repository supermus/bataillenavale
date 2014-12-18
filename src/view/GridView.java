package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.Game;
import controller.GameController;

public class GridView extends AbstractView implements Observer, MouseListener {

	private static Game game;
	private JLabel[][] cells;
	private boolean isHuman;
	
	// Sprites pour les cases
	private ImageIcon iconWater;
	private ImageIcon iconHit;
	private ImageIcon iconMiss;
	private ImageIcon iconBoat1;
	private ImageIcon iconBoat2;
	private ImageIcon iconBoat3;
	private ImageIcon iconBoat4;
	private ImageIcon iconBoat5;

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
	public GridView(GameController c, boolean isHuman) {
		super(c);
		this.isHuman = isHuman;
		// chargement et redimensionnement des sprites;
		this.iconWater = new ImageIcon(new ImageIcon("assets/water.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconHit = new ImageIcon(new ImageIcon("assets/hit.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconMiss = new ImageIcon(new ImageIcon("assets/miss.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat1 = new ImageIcon(new ImageIcon("assets/boat1.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat2 = new ImageIcon(new ImageIcon("assets/boat2.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat3 = new ImageIcon(new ImageIcon("assets/boat3.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat4 = new ImageIcon(new ImageIcon("assets/boat4.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat5 = new ImageIcon(new ImageIcon("assets/boat5.png").getImage().getScaledInstance(400/c.getGame().getMapSize(), 400/c.getGame().getMapSize(),  java.awt.Image.SCALE_SMOOTH));
		setLayout(new GridLayout(c.getGame().getMapSize(), c.getGame().getMapSize(), 1, 1));
		
		cells = new JLabel[c.getGame().getMapSize()][c.getGame().getMapSize()];
		for(int i = 0; i<c.getGame().getMapSize(); i++) {
			for(int j = 0; j<c.getGame().getMapSize(); j++)
			{
				JLabel btn = new JLabel(iconWater);
				cells[i][j] = btn;
				btn.addMouseListener(this); // ajout écouteur
				add(btn); // ajout à la GUI
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		

	}

	/**
	 * Indique si la grille appartient à un joueur humain (permet de décider ce qui doit être affiché ou non)
	 * @return boolean true si humain, false sinon
	 */
	public boolean isHuman()
	{
		return isHuman;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!isHuman) {
			// TODO Auto-generated method stub
			JLabel l = (JLabel) arg0.getSource();
			GameController gc = (GameController) controller;
			System.out.println((int)(l.getLocation().getX()/(400/gc.getGame().getMapSize())) + ";" + (int)(l.getLocation().getY()/(400/gc.getGame().getMapSize())));

		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
