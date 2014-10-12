package ee.ut.math.tvt.teamedward;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.configuration.ConfigurationException;

public class IntroUI{

	
	public static void tutvus() throws IOException, ConfigurationException{
		
		
		PropertyValues properties = new PropertyValues();
		String teamNameString = properties.getTeamName();
		String teamLeaderString = properties.getTeamLeader();
		String teamLeaderEmailString = properties.getTeamLeaderEmail();
		String teamMembersString = properties.getTeamMembers();
		String verNumberString = properties.getVersion();
		
		properties.getTeamLogo();
		
		
		JLabel teamName = new JLabel("Team name: " + teamNameString);
		JLabel teamLeader = new JLabel("Team leader: " + teamLeaderString);
		JLabel teamLeaderMail = new JLabel("Team leader email: " + teamLeaderEmailString);
		JLabel teamMembers = new JLabel("Members: " + teamMembersString);
		JLabel versionNumber = new JLabel("Version: " + verNumberString);
		
		BufferedImage logo = ImageIO.read(new File("logo.jpeg"));
		JLabel teamLogo = new JLabel(new ImageIcon(logo));
		
		deleteLogo();
		
		
		
		JFrame mainFrame = new JFrame("TeamEdward");
		JPanel mainPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints d = new GridBagConstraints();
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(300, 350);
		
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
		mainPanel.add(teamMembers, d);
		
		d.gridx = 0;
		d.gridy = 4;
		mainPanel.add(versionNumber, d);
		
		d.gridx = 0;
		d.weightx = 2.0;
		
		d.gridy = 5;
		d.anchor=GridBagConstraints.NORTH;
		mainPanel.add(teamLogo, d);
		
		mainFrame.add(mainPanel);
		
		mainFrame.setVisible(true);
		
	}
	
	public static void deleteLogo(){
		try{
			 
    		File deleteLogo = new File("logo.jpeg");
 
    		deleteLogo.delete();
 
    	}catch(Exception e){
 
    		e.printStackTrace();
 
    	}
	}
    

    

	
}