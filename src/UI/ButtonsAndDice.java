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

	// Constructor
	public ButtonsAndDice() {
		init();
	}

	// construct the Section where the dice are located
	private void init() {
		JPanel LowerSection = new JPanel();
		LowerSection.setLayout(new BoxLayout(LowerSection, BoxLayout.Y_AXIS));

		JPanel Dice = new JPanel(new GridLayout(1, 5, 20, 20));
		Dice.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		for (int i = 0; i < 5; i++) {
			JToggleButton temp = new JToggleButton();
			temp.setPreferredSize(new Dimension(65, 65));
			temp.setBackground(Color.gray);
			// temp.setIcon(DieImage(i));
			temp.addActionListener(new DiceListener());
			Dices[i] = temp;
			Dice.add(Dices[i]);
			Selected[i] = false;
		}

		JPanel Buttons = new JPanel(new GridLayout(1, 3, 20, 20));

		Roll = new JButton("ROLL");
		Keep = new JButton("KEEP");
		EndTurn = new JButton("END TURN");

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

				// Check if any of the dice are selected.
				// for (int i = 0; i < 5; i++) {
				// if (Dices[i].isSelected()) {
				// Selected[i] = true;
				// Dices[i].setBorder(BorderFactory.createLineBorder(
				// Color.GREEN, 5));
				// }
				// }

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
					Dices[i].setBorder(BorderFactory.createLineBorder(
							Color.GREEN, 5));
				}
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
							Color.yellow, 5));
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
				CurrentPlayer.setCurrentValues(DiceValue);
				JOptionPane.showMessageDialog(null, "End of Turn.");

				for (int i = 0; i < 5; i++) {
					Dices[i].setBorder(BorderFactory.createLineBorder(null));
				}
			}

		}
	}

}
