package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Game;
import controller.GameController;

public class GameContainerView extends AbstractView implements Observer {
	
	// Modele
	
	private static Game game; // contient la partie

	// Elements d'interface
	GridView leftGrid;
	GridView rightGrid;
	private JLabel labelVS;
	private JLabel labelPlayerLeft;
	private JLabel labelPlayerRight;
	private JMenuBar menuBar;
	private JMenu gameMenu;
	private JMenuItem menuButtonQuit;
	private JLabel labelTurn;
	private JLabel labelTime;
	private JLabel labelShotLeft;
	private JLabel labelShotValueLeft;
	private JLabel labelScoreLeft;
	private JLabel labelScoreValueLeft;
	private JLabel labelShotRight;
	private JLabel labelScoreRight;
	private JLabel labelScoreValueRight;
	private JLabel labelShotValueRight;
	private JLabel labelBoats;
	private JList listBoat;
	private JButton buttonPlaceBoat;

	public GameContainerView(GameController c) {
		super(c);
		setPreferredSize(new Dimension(1024, 720));
		setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1024, 25);
		add(menuBar);

		gameMenu = new JMenu("Jeu");
		menuBar.add(gameMenu);

		menuButtonQuit = new JMenuItem("Quitter");
		gameMenu.add(menuButtonQuit);

		leftGrid = new GridView((GameController)controller, 10, true, false);
		leftGrid.setBounds(42, 75, 400, 400);

		add(leftGrid);
		rightGrid = new GridView((GameController)controller, 10, true, false);
		rightGrid.setBounds(582, 75, 400, 400);
		add(rightGrid);

		labelVS = new JLabel("VS");
		labelVS.setHorizontalAlignment(SwingConstants.CENTER);
		labelVS.setFont(new Font("Tahoma", Font.PLAIN, 37));
		labelVS.setBounds(452, 233, 120, 83);
		add(labelVS);

		labelPlayerLeft = new JLabel("Joueur 1 : Nom");
		labelPlayerLeft.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerLeft.setBounds(42, 50, 400, 14);
		add(labelPlayerLeft);

		labelPlayerRight = new JLabel("Joueur 2 : Nom");
		labelPlayerRight.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerRight.setBounds(582, 50, 400, 14);
		add(labelPlayerRight);

		labelTurn = new JLabel("Tour 1");
		labelTurn.setHorizontalAlignment(SwingConstants.CENTER);
		labelTurn.setBounds(452, 76, 120, 14);
		add(labelTurn);

		labelTime = new JLabel("00:00");
		labelTime.setHorizontalAlignment(SwingConstants.CENTER);
		labelTime.setBounds(452, 101, 120, 14);
		add(labelTime);

		labelShotLeft = new JLabel("Tirs :");
		labelShotLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		labelShotLeft.setBounds(42, 486, 46, 14);
		add(labelShotLeft);

		labelShotValueLeft = new JLabel("0 (dont 0 rat\u00E9s)");
		labelShotValueLeft.setBounds(100, 486, 141, 14);
		add(labelShotValueLeft);

		labelScoreLeft = new JLabel("Score :");
		labelScoreLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		labelScoreLeft.setBounds(42, 511, 46, 14);
		add(labelScoreLeft);

		labelScoreValueLeft = new JLabel("0");
		labelScoreValueLeft.setBounds(100, 511, 153, 14);
		add(labelScoreValueLeft);

		labelShotRight = new JLabel("Tirs :");
		labelShotRight.setHorizontalAlignment(SwingConstants.RIGHT);
		labelShotRight.setBounds(582, 486, 46, 14);
		add(labelShotRight);

		labelScoreRight = new JLabel("Score :");
		labelScoreRight.setHorizontalAlignment(SwingConstants.RIGHT);
		labelScoreRight.setBounds(582, 511, 46, 14);
		add(labelScoreRight);

		labelScoreValueRight = new JLabel("0");
		labelScoreValueRight.setBounds(640, 511, 168, 14);
		add(labelScoreValueRight);

		labelShotValueRight = new JLabel("0 (dont 0 rat\u00E9s)");
		labelShotValueRight.setBounds(640, 486, 161, 14);
		add(labelShotValueRight);

		labelBoats = new JLabel("Bateaux :");
		labelBoats.setHorizontalAlignment(SwingConstants.CENTER);
		labelBoats.setBounds(42, 570, 60, 139);
		add(labelBoats);

		listBoat = new JList();
		listBoat.setBounds(112, 570, 206, 139);
		add(listBoat);

		buttonPlaceBoat = new JButton("Placer");
		buttonPlaceBoat.setBounds(338, 606, 91, 67);
		add(buttonPlaceBoat);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//System.out.println(arg0.toString());
		this.labelPlayerLeft.setText(game.getPlayer().get(0).getNom());
		this.labelPlayerRight.setText(game.getPlayer().get(1).getNom());
		this.labelShotValueLeft.setText(game.getPlayer().get(0).getHits() +" dont " +game.getPlayer().get(0).getMiss()+" raté");
		this.labelShotValueRight.setText(game.getPlayer().get(1).getHits() +" dont "+game.getPlayer().get(1).getMiss() +" raté");
		this.labelScoreValueLeft.setText( Integer.toString(game.getPlayer().get(0).getScore()));
		this.labelScoreValueRight.setText(Integer.toString(game.getPlayer().get(1).getScore()));
		this.labelTime.setText((game.getTime()/60)+":"+ (game.getTime()%60));
		
		
	}
	
	public void setModel(Game g)
	{
		this.game = g;
		this.game.addObserver(this);
		this.update(null, null); // on force une update
	}
}
