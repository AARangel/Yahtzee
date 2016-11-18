package UI;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MainPage {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Yahtzee!");
		frame.setSize(900,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		JPanel Main = new JPanel(); 
		Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS)); 
		Main.setSize(500, 500); 
		
		JPanel ScoreCard = ScoreCard();
		
		JPanel Dice = Dice(); 
		JPanel BottomButtons = RowButtons(); 
		
		Main.add(ScoreCard); 
		Main.add(Box.createHorizontalStrut(5)); 
		Main.add(Dice); 
		Main.add(Box.createHorizontalStrut(5)); 
		Main.add(BottomButtons); 
		
		JPanel PlayersScore = Players(); 
		
		JPanel flow = new JPanel(new FlowLayout()); 
		flow.add(PlayersScore); 
		flow.add(Box.createVerticalStrut(200)); 
		flow.add(Main);
		
		frame.add(flow);
		frame.setVisible(true); 
	}

	public static JPanel ScoreCard() {

		// Create the panel for the first score card
		JPanel LPanel = new JPanel(new GridLayout(13, 2));
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

		JToggleButton leftLabel10 = new JToggleButton("3 of a kind");
		leftLabel10.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel10);

		JLabel RightLabel10 = new JLabel("0");
		RightLabel10.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel10);

		JToggleButton leftLabel20 = new JToggleButton("4 of a king");
		leftLabel20.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel20);

		JLabel RightLabel20 = new JLabel("0");
		RightLabel20.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel20);

		JToggleButton leftLabel30 = new JToggleButton("Full House");
		leftLabel30.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel30);

		JLabel RightLabel30 = new JLabel("0");
		RightLabel30.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel30);

		JToggleButton leftLabel40 = new JToggleButton("Small Straight");
		leftLabel40.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel40);

		JLabel RightLabel40 = new JLabel("0");
		RightLabel40.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel40);

		JToggleButton leftLabel50 = new JToggleButton("Large Straight");
		leftLabel50.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel50);

		JLabel RightLabel50 = new JLabel("0");
		RightLabel50.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel50);

		JToggleButton leftLabel60 = new JToggleButton("Yahtzee");
		leftLabel60.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel60);

		JLabel RightLabel60 = new JLabel("0");
		RightLabel60.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel60);

		JToggleButton leftLabel70 = new JToggleButton("Chance");
		leftLabel70.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(leftLabel70);

		JLabel RightLabel70 = new JLabel("0");
		RightLabel70.setHorizontalAlignment(SwingConstants.CENTER);
		LPanel.add(RightLabel70);
		
		return LPanel;

	}

	public static JPanel Dice(){
			
			//Layout for the dice 
			JPanel Dice = new JPanel(new GridLayout(1, 5, 20, 20)); 
			Dice.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
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
		Players.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// create each players Name Label and Score label 
		//ArrayList<JPanel> Player = new ArrayList<JPanel>(); 
		
		for(int i = 0; i < 4; i++){
			JPanel temp = new JPanel(new GridLayout(2, 1));
			
			temp.setBorder(BorderFactory.createLineBorder(Color.black));
			temp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			
			String name = "Player " + (i+1);
			
			JLabel Score = new JLabel("Score: 0"); 
			JLabel Name = new JLabel(name);
			
			temp.add(Name); 
			temp.add(Score); 
			
			Players.add(temp); 
			
			temp = null;
			Name = null; 
			Score = null; 
		}
		
		return Players; 
		
		
		
	}
	
}
