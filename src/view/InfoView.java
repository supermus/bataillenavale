package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class InfoView extends JPanel {
	public InfoView() {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Shot : 0");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Time : 0 : 00");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Round : 0");
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblNewLabel_4 = new JLabel("Water : 0");
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Hit : 0 ");
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(90);
		flowLayout_1.setHgap(20);
		add(panel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Number of ally ship : 0");
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Turn/Miss");
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Number of adverse ship : 0");
		panel_1.add(lblNewLabel_7);
	}

	
	
	
	

}
