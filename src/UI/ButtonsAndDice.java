package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonsAndDice extends JPanel {

	private Random rand = new Random();
	private JButton Roll;
	private JButton Keep;
	private JButton EndTurn;
	private JToggleButton[] Dices = new JToggleButton[5];
	private Boolean[] Selected = new Boolean[5];
	private int[] DiceValue = new int[5];
	private int Rolls;
	private Player CurrentPlayer;
	private ScoreCard CurrentScoreCard; 
	private static Color Wine = Color.decode("#722f37");
	private static Color Gold = Color.decode("#FFD700");
	
	public ScoreCard getCurrentScoreCard() {
		return CurrentScoreCard;
	}

	public void setCurrentScoreCard(ScoreCard currentScoreCard) {
		CurrentScoreCard = currentScoreCard;
	}

	// Constructor
	public ButtonsAndDice() {
		init();
	}

	// construct the Section where the dice are located
	private void init() {
		JPanel LowerSection = new JPanel();
		LowerSection.setBackground(Color.BLACK); 
		LowerSection.setForeground(Color.WHITE); 
		LowerSection.setLayout(new BoxLayout(LowerSection, BoxLayout.Y_AXIS));

		JPanel Dice = new JPanel(new GridLayout(1, 5, 20, 20));
		Dice.setBackground(Color.BLACK); 
		Dice.setForeground(Color.WHITE); 
		Dice.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		for (int i = 0; i < 5; i++) {
			JToggleButton temp = new JToggleButton();
			temp.setPreferredSize(new Dimension(65, 65));
			temp.setBackground(Wine);
			temp.setBorder(BorderFactory.createLineBorder(Wine, 5));
			// temp.setIcon(DieImage(i));
			temp.addActionListener(new DiceListener());
			Dices[i] = temp;
			Dice.add(Dices[i]);
			Selected[i] = false;
		}

		JPanel Buttons = new JPanel(new GridLayout(1, 3, 20, 20));
		Buttons.setBackground(Color.BLACK); 
		Buttons.setForeground(Color.WHITE); 
		
		Roll = new JButton("ROLL");
		Roll.setBackground(Wine); 
		Roll.setForeground(Color.WHITE);
		Roll.setFocusPainted(false); 
		Roll.setBorder(BorderFactory.createLineBorder(Gold, 2));
		
		Keep = new JButton("KEEP");
		Keep.setBackground(Wine); 
		Keep.setForeground(Color.WHITE);
		Keep.setFocusPainted(false); 
		Keep.setBorder(BorderFactory.createLineBorder(Gold, 2));
		
		EndTurn = new JButton("END TURN");
		EndTurn.setBackground(Wine); 
		EndTurn.setForeground(Color.WHITE);
		EndTurn.setFocusPainted(false); 
		EndTurn.setBorder(BorderFactory.createLineBorder(Gold, 2));

		
		Roll.addActionListener(new RollButtonListener());
		Keep.addActionListener(new KeepButtonListener());
		EndTurn.addActionListener(new EndTurnButtonListener());

		Buttons.add(Roll);
		Buttons.add(Keep);
		Buttons.add(EndTurn);

		LowerSection.add(Dice);
		LowerSection.add(Buttons);

		this.add(LowerSection, BorderLayout.CENTER);

	}

	// Gets the Image of the Die
	private ImageIcon DieImage(int Number) {

		ImageIcon dieImage = null;

		switch (Number) {
		case 1:
			dieImage = new ImageIcon(getClass().getResource(
					"./Images/Side 1.png"));
			break;
		case 2:
			dieImage = new ImageIcon(getClass().getResource(
					"./Images/side 2.png"));
			break;
		case 3:
			dieImage = new ImageIcon(getClass().getResource(
					"./Images/side 3.png"));
			break;
		case 4:
			dieImage = new ImageIcon(getClass().getResource(
					"./Images/side 4.png"));
			break;
		case 5:
			dieImage = new ImageIcon(getClass().getResource(
					"./Images/side 5.png"));
			break;
		case 6:
			dieImage = new ImageIcon(getClass().getResource(
					"./Images/side 6.png"));
			break;
		}

		// dieImage = imageResize(dieImage);
		return dieImage;
	}

	private class RollButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			if (Rolls < 3) {

				// increment the amount of rolls left in this turn
				Rolls++;

				// Roll the dice that are not selected
				for (int i = 0; i < 5; i++) {

					if (Selected[i] == true && DiceValue[i] > 0)
						continue;

					// select random number
					int n = rand.nextInt(6) + 1;

					// store it the array of values
					DiceValue[i] = n;

					// change the face icon of the current dice
					Dices[i].setBackground(null);
					Dices[i].setIcon(DieImage(n));

				}
			} else {
				for (int i = 0; i < 5; i++) {
					System.out.println("Dice " + i + ": " + DiceValue[i]);
				}
			}

		}
	}

	private class KeepButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			// Check if any of the dice are selected.
			for (int i = 0; i < 5; i++) {
				if (Dices[i].isSelected() && DiceValue[i] > 0) {
					Selected[i] = true;
					Dices[i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					
				}
			}
			
			Boolean check = false;
			for (int i = 0; i < 5; i++) {
				if (Selected[i] == false)
					check = true;
			}
			
			if(check == false)
			{
				CurrentScoreCard.setCurrentPlayer(CurrentPlayer);
				CurrentPlayer.setCurrentValues(DiceValue);
			}
			
		}
	}

	private class DiceListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			boolean selected = false;

			if (ae.getSource() instanceof JToggleButton) {

				JToggleButton button = (JToggleButton) ae.getSource();
				selected = button.isSelected();

				if (selected)
					button.setBorder(BorderFactory.createLineBorder(
							Gold, 5));
				else
					button.setBorder(BorderFactory.createLineBorder(null));

			}
		}
	}

	public Player getCurrentPlayer() {
		return CurrentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		Rolls = 0;
		CurrentPlayer = currentPlayer;
		CurrentPlayer.setEndTurn(false);
	}

	private class EndTurnButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			Boolean check = false;

			for (int i = 0; i < 5; i++) {
				if (Selected[i] == false)
					check = true;
			}

			if (check == false) {
				CurrentPlayer.setEndTurn(true);
				//CurrentPlayer.setCurrentValues(DiceValue);
				
				for (int i = 0; i < 5; i++) {
					Dices[i].setBorder(BorderFactory.createLineBorder(null));
				}
				
				for(int y = 0; y < 5; y++)
				{
					Dices[y].setIcon(null); 
					Dices[y].setBackground(Wine); 
					Dices[y].setSelected(false); 
					DiceValue[y] = 0;
					Selected[y] = false; 
				}		
				
				
				Rolls = 0;
			}
			

		}
	}

}
