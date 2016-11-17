package UI;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MainPage {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Yahtzee!");
		frame.setSize(1000,1000);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		JPanel Main = new JPanel(); 
		Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS)); 
		Main.setSize(750, 750); 
		
		JPanel TopScoreCard = LeftScorecard();
		JPanel BottomScoreCard = RightScorecard(); 
		JPanel Dice = Dice(); 
		JPanel BottomButtons = RowButtons(); 
		
		Main.add(Box.createHorizontalStrut(2)); 
		Main.add(TopScoreCard); 
		Main.add(BottomScoreCard);
		Main.add(Box.createHorizontalStrut(10)); 
		Main.add(Dice); 
		Main.add(Box.createHorizontalStrut(2)); 
		Main.add(BottomButtons); 
		
		JPanel PlayersScore = Players(); 
		
		JPanel flow = new JPanel(new FlowLayout()); 
		flow.add(PlayersScore); 
		flow.add(Box.createVerticalStrut(200)); 
		flow.add(Main);
		
		frame.add(flow);
	
	}

	public static JPanel LeftScorecard() {

		// Create the panel for the first score card
		JPanel LPanel = new JPanel(new GridLayout(6, 2));
		LPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		LPanel.setSize(220, 125);

		JToggleButton leftLabel1 = new JToggleButton("Aces");
		leftLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel1);

		JLabel RightLabel1 = new JLabel("0");
		RightLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel1);

		JToggleButton leftLabel2 = new JToggleButton("2s");
		leftLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel2);

		JLabel RightLabel2 = new JLabel("0");
		RightLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel2);

		JToggleButton leftLabel3 = new JToggleButton("3s");
		leftLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel3);

		JLabel RightLabel3 = new JLabel("0");
		RightLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel3);

		JToggleButton leftLabel4 = new JToggleButton("4s");
		leftLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel4);

		JLabel RightLabel4 = new JLabel("0");
		RightLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel4);

		JToggleButton leftLabel5 = new JToggleButton("5s");
		leftLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel5);

		JLabel RightLabel5 = new JLabel("0");
		RightLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel5);

		JToggleButton leftLabel6 = new JToggleButton("6s");
		leftLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel6);

		JLabel RightLabel6 = new JLabel("0");
		RightLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel6);

		return LPanel;

	}

	public static JPanel RightScorecard() {

		// Create the panel for the first score card
		JPanel RPanel = new JPanel(new GridLayout(7, 2));
		RPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		RPanel.setSize(220, 125);

		JToggleButton leftLabel1 = new JToggleButton("3 of a kind");
		leftLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(leftLabel1);

		JLabel RightLabel1 = new JLabel("0");
		RightLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(RightLabel1);

		JToggleButton leftLabel2 = new JToggleButton("4 of a king");
		leftLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(leftLabel2);

		JLabel RightLabel2 = new JLabel("0");
		RightLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(RightLabel2);

		JToggleButton leftLabel3 = new JToggleButton("Full House");
		leftLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(leftLabel3);

		JLabel RightLabel3 = new JLabel("0");
		RightLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(RightLabel3);

		JToggleButton leftLabel4 = new JToggleButton("Small Straight");
		leftLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(leftLabel4);

		JLabel RightLabel4 = new JLabel("0");
		RightLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(RightLabel4);

		JToggleButton leftLabel5 = new JToggleButton("Large Straight");
		leftLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(leftLabel5);

		JLabel RightLabel5 = new JLabel("0");
		RightLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(RightLabel5);

		JToggleButton leftLabel6 = new JToggleButton("Yahtzee");
		leftLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(leftLabel6);

		JLabel RightLabel6 = new JLabel("0");
		RightLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(RightLabel6);

		JToggleButton leftLabel7 = new JToggleButton("Chance");
		leftLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(leftLabel7);

		JLabel RightLabel7 = new JLabel("0");
		RightLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		RPanel.add(RightLabel7);

		return RPanel;

	}

	public static JPanel Dice(){
			
			//Layout for the dice 
			JPanel Dice = new JPanel(new GridLayout(1, 5, 20, 20)); 
			
			// create the dice as buttons 
			ArrayList<JButton> Dices = new ArrayList<JButton>(); 
			
			 for(int i = 0; i < 5; i++){
				 JButton temp = new JButton();
				 String s = "" + i; 
				 temp.setText(s); 
				 Dices.add(temp);
				 Dice.add(Dices.get(i)); 
			 }
			
			 return Dice; 
		}

	public static JPanel RowButtons() {

		JPanel Buttons = new JPanel(new GridLayout(1, 3, 20, 20));

		JButton Roll = new JButton("ROLL");
		JButton Keep = new JButton("KEEP");
		JButton EndTurn = new JButton("END TURN");

		Buttons.add(Roll);
		Buttons.add(Keep);
		Buttons.add(EndTurn);

		return Buttons;

	}

	public static JPanel Players() {
		
		JPanel Players = new JPanel(); 
		Players.setLayout(new BoxLayout(Players, BoxLayout.Y_AXIS)); 
		
		// create each players Name Label and Score label 
		//ArrayList<JPanel> Player = new ArrayList<JPanel>(); 
		
		for(int i = 0; i < 4; i++){
			JPanel temp = new JPanel(new GridLayout(2, 1));
			temp.setBorder(BorderFactory.createLineBorder(Color.black));
			String name = "Player" + (i+1);
			
			JLabel Score = new JLabel("Score: 0"); 
			JLabel Name = new JLabel(name);
			
			temp.add(Name); 
			temp.add(Score); 
			
			//Player.add(temp); 
			
			Players.add(temp); 
			
			temp = null;
			Name = null; 
			Score = null; 
			//Player = null; 
		}
		
		return Players; 
		
		
		
	}
	
}
