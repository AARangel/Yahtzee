package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainPage extends JFrame {

	private int NumberPlayers;
	private static JLabel Round;
	private static JLabel Player1Score;
	private static JLabel Player2Score;
	private static ScoreCard ScoreCard;
	private static ButtonsAndDice Dice;
	private static JPanel[] PlayerPanel = new JPanel[2];
	private static Color Wine = Color.decode("#722f37");
	private static Color Gold = Color.decode("#FFD700");
	
	
	@SuppressWarnings("deprecation")
	public MainPage() throws IOException {

		LaunchMenu start = new LaunchMenu();
		start.startLaunchMenu();
		
		while(!start.getMain())
			System.out.println("Menu");
		
		Boolean Run = start.getMain(); 
		
		if(Run)
			RunMain(); 

	}
	
	public static void RunMain(){
		JFrame frame = new JFrame("Yahtzee!");
		frame.setSize(900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menu bar 
		JMenuBar menubar = new JMenuBar(); 
		JButton file = new JButton("     Exit     ");
		
		file.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		}); 
		
		file.setBackground(Wine); 
		file.setFocusPainted(false); 
		file.setPreferredSize(new Dimension(100, 20)); 
		file.setBorder(BorderFactory.createLineBorder(Gold, 1));
		file.setForeground(Color.WHITE);
		menubar.setBackground(Color.BLACK); 
		menubar.setBorder(BorderFactory.createEmptyBorder());
		menubar.add(file);  
		frame.setJMenuBar(menubar); 
		
		
		JPanel Main = new JPanel();
		Main.setBackground(Color.BLACK); 
		Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS));
		Main.setSize(700, 400);

		ScoreCard = new ScoreCard();
		ScoreCard.setBackground(Color.BLACK); 
		//Dimension dimer = new Dimension(500, 250);
		//ScoreCard.setPreferredSize(dimer); 
		Dice = new ButtonsAndDice();
		Dice.setBackground(Color.BLACK); 
		

		
	//	Main.add(Round);
		Main.add(ScoreCard);
		//Main.add(Box.createHorizontalStrut(5));
		Main.add(Dice);
		//Main.add(Box.createHorizontalStrut(5));
		Main.setBackground(Color.BLACK); 
		Main.setForeground(Color.WHITE); 
		// Main.add(BottomButtons);

		JPanel PlayersScore = Players();
		// Player PlayersScore = new Player();
		PlayersScore.setPreferredSize(new Dimension(200, 480));

		JPanel flow = new JPanel(new FlowLayout());
		flow.setBackground(Color.BLACK);
		
		flow.add(PlayersScore);
		//flow.add(Box.createVerticalStrut(200));
		flow.add(Main);
		
		JPanel LogoPanel = new JPanel(); 
		LogoPanel.setLayout(new  BoxLayout(LogoPanel, BoxLayout.Y_AXIS));
		LogoPanel.setBackground(Color.black); 
		
		BufferedImage img = null;
		JLabel Logo = new JLabel(); 
		try {
		    img = ImageIO.read(new File("/home/aar/Documents/Dev/Eclipse/YahtzeeUserInterface/src/UI/yahtzee1final.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null,"No");
		}
		
		Image dimg = img.getScaledInstance(300, 200,
		        Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		Logo.setIcon(imageIcon);
		//Logo.setBorder(BorderFactory.createLineBorder(Gold, 3));
		
		
		LogoPanel.add(Box.createHorizontalStrut(25));
		LogoPanel.add(Logo); 
		//LogoPanel.add(Box.createHorizontalStrut(10));
		LogoPanel.add(flow); 
		LogoPanel.setAlignmentX(CENTER_ALIGNMENT);
		
		frame.add(LogoPanel);
		
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);

		StartGame();
	}

	public static JPanel Players() {

		JPanel Players = new JPanel();
		Players.setBackground(Color.BLACK); 
		Players.setLayout(new BoxLayout(Players, BoxLayout.Y_AXIS));
		Players.setBorder(BorderFactory.createLineBorder(Gold, 5));

		JPanel temp = new JPanel(new GridLayout(2, 1));
		temp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		temp.setBackground(Wine); 
		temp.setBorder(BorderFactory.createLineBorder(Gold, 2));

		JPanel temp2 = new JPanel(new GridLayout(2, 1));
		temp2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		temp2.setBackground(Wine); 
		temp2.setBorder(BorderFactory.createLineBorder(Gold, 2));

		Player1Score = new JLabel("Score: 0");
		Player1Score.setSize(50, 48);
		Player1Score.setPreferredSize(new Dimension(50, 48));
		Player1Score.setHorizontalAlignment(SwingConstants.CENTER);
		Player1Score.setBackground(Wine); 
		Player1Score.setForeground(Color.WHITE); 

		Player2Score = new JLabel("Score: 0");
		Player2Score.setSize(50, 48);
		Player2Score.setPreferredSize(new Dimension(50, 48));
		Player2Score.setHorizontalAlignment(SwingConstants.CENTER);
		Player2Score.setBackground(Wine); 
		Player2Score.setForeground(Color.WHITE); 
		

		JLabel Player1Name = new JLabel("Player 1");
		Player1Name.setSize(50, 48);
		Player1Name.setPreferredSize(new Dimension(50, 48));
		Player1Name.setHorizontalAlignment(SwingConstants.CENTER);
		Player1Name.setBackground(Wine); 
		Player1Name.setForeground(Color.WHITE); 

		JLabel Player2Name = new JLabel("Player 2");
		Player2Name.setSize(50, 48);
		Player2Name.setPreferredSize(new Dimension(50, 48));
		Player2Name.setHorizontalAlignment(SwingConstants.CENTER);
		Player2Name.setBackground(Wine); 
		Player2Name.setForeground(Color.WHITE); 
		
		
		temp.add(Player1Name);
		temp.add(Player1Score);
		temp2.add(Player2Name);
		temp2.add(Player2Score);

		PlayerPanel[0] = temp;
		PlayerPanel[1] = temp2;

		Round = new JLabel("Round 1/13");
		Round.setSize(new Dimension(50, 48));
		Round.setHorizontalAlignment(SwingConstants.CENTER);
		Round.setForeground(Color.WHITE); 
		
		Players.setBackground(Wine); 
		Players.add(Round); 
		Players.add(temp);
		Players.add(temp2);

		return Players;

	}

	// Run the Game from here
	private static void StartGame() {

		Player[] Players = new Player[2];
		for (int x = 0; x < 2; x++) {
			Player NewPlayer = new Player();
			Players[x] = NewPlayer;
			NewPlayer = null;
		}

		System.out.println("Yes");

		// Number of Rounds in the Game
		for (int i = 1; i < 14; i++) {
			// Number of players per round
			for (int j = 0; j < 2; j++) {

				Dice.setCurrentPlayer(Players[j]);
				Dice.setCurrentScoreCard(ScoreCard);

				String start = "Start of Player " + (j + 1) + " Turn.";
				JOptionPane.showMessageDialog(null,start);

				if (j == 0) {
					PlayerPanel[1].setBorder(BorderFactory.createEmptyBorder());
					PlayerPanel[0].setBorder(BorderFactory.createLineBorder(
							Color.GREEN, 5));
				}

				// Same as above
				if (j == 1) {
					PlayerPanel[0].setBorder(BorderFactory.createEmptyBorder());
					PlayerPanel[1].setBorder(BorderFactory.createLineBorder(
							Color.GREEN, 5));
				}

				while (!Players[j].getEndTurn()) {

					System.out.println(Players[j].getEndTurn());
				}

//				int TotalCurrent = 0;
//				int[] array = Dice.getCurrentPlayer().getScoreCard();
//				for (int z = 0; z < 14; z++) {
//					TotalCurrent = array[i] + TotalCurrent;
//				}

				if (j == 1) {
					int TotalCurrent = 0;
					int[] array = Dice.getCurrentPlayer().getScoreCard();
					for (int z = 0; z < 14; z++) 
						TotalCurrent = array[z] + TotalCurrent;
					
					String string1 = "Score: " + TotalCurrent;
					Player2Score.setText(string1);
					array = null;
				}
					
				if (j == 0) {
					int TotalCurrent1 = 0;
					int[] array1 = Dice.getCurrentPlayer().getScoreCard();
					for (int z = 0; z < 14; z++) 
						TotalCurrent1 = array1[z] + TotalCurrent1;
				
					String string2 = "Score: " + TotalCurrent1;
					Player1Score.setText(string2);
					array1 = null;
				}

				String curr = "End of Player " + (j + 1) + " Turn.";
				 JOptionPane.showMessageDialog(null,curr);

				ScoreCard.reset();

			}

			String Rounds = "Round " + (i + 1) + "/13";
			Round.setText(Rounds);
		}

	}

}
