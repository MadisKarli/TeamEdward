package ee.ut.math.tvt.teamedward;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroUI {
	
	
	
	public static JLabel teamName = new JLabel("TeamEdward");
	public static JLabel teamLeader = new JLabel("Leader");
	public static JLabel teamLeaderMail = new JLabel("Mail");
	public static JLabel teamMember2 = new JLabel("Member2");
	public static JLabel teamMember3 = new JLabel("Member3");
	public static JLabel verNum = new JLabel("1.2.3");
	
	static JFrame mainFrame = new JFrame("TeamEdward");
	static JPanel mainPanel = new JPanel(new GridBagLayout());
	
	static GridBagConstraints d = new GridBagConstraints();
	
	public static void tutvus(){
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(350, 260);
		
		d.gridx = 0;
		d.gridy = 0;
		d.weightx = 1.0;
		d.weighty = 1.0;
		d.anchor=GridBagConstraints.NORTHWEST;
		
		mainPanel.add(teamName, d);
		
		d.gridx = 0;
		d.gridy = 1;
		mainPanel.add(teamLeader, d);
		
		d.gridx = 0;
		d.gridy = 2;
		mainPanel.add(teamLeaderMail, d);
		
		d.gridx = 0;
		d.gridy = 3;
		mainPanel.add(teamMember2, d);
		
		d.gridx = 0;
		d.gridy = 4;
		mainPanel.add(teamMember3, d);
		
		d.gridx = 0;
		d.gridy = 5;
		mainPanel.add(verNum, d);
		
		mainFrame.add(mainPanel);
		
		mainFrame.setVisible(true);
		
	}

	
}
