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

import controller.GameController;

public class GridView extends AbstractView implements Observer, MouseListener {

	private JLabel[][] cells;
	private boolean isHuman;
	private int mapSize;
	
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
		mapSize = 2;
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
	public GridView(GameController c, int mapSize, boolean isHuman) {
		super(c);
		this.isHuman = isHuman;
		this.mapSize = mapSize;
		// chargement et redimensionnement des sprites;
		this.iconWater = new ImageIcon(new ImageIcon("assets/water.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH));
		this.iconHit = new ImageIcon(new ImageIcon("assets/hit.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH));
		this.iconMiss = new ImageIcon(new ImageIcon("assets/miss.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat1 = new ImageIcon(new ImageIcon("assets/boat1.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat2 = new ImageIcon(new ImageIcon("assets/boat2.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat3 = new ImageIcon(new ImageIcon("assets/boat3.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat4 = new ImageIcon(new ImageIcon("assets/boat4.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH));
		this.iconBoat5 = new ImageIcon(new ImageIcon("assets/boat5.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH));
		setLayout(new GridLayout(mapSize, mapSize, 1, 1));
		
		cells = new JLabel[mapSize][mapSize];
		for(int i = 0; i<mapSize; i++) {
			for(int j = 0; j<mapSize; j++)
			{
				JLabel btn = new JLabel( iconWater );

				cells[i][j] = btn;
				btn.addMouseListener(this);
				add(btn);
			}
		}

		Image newimg = new ImageIcon("assets/hit.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH);
		cells[0][0].setIcon(new ImageIcon(newimg));

		Image newimg2 = new ImageIcon("assets/boat1.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH);
		cells[0][1].setIcon(new ImageIcon(newimg2));
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
			System.out.println(l.getLocation().getX()/(mapSize*4) + ";" + l.getLocation().getY()/(mapSize*4));

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
