package UI;

import java.awt.*;
import java.util.ArrayList;

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

	@SuppressWarnings("deprecation")
	public MainPage() {


			JFrame frame = new JFrame("Yahtzee!");
			frame.setSize(900, 550);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel Main = new JPanel();
			Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS));
			Main.setSize(500, 500);

			ScoreCard = new ScoreCard();

			Dice = new ButtonsAndDice();

			Round = new JLabel("Round 1/13");

			Main.add(Round);
			Main.add(ScoreCard);
			Main.add(Box.createHorizontalStrut(5));
			Main.add(Dice);
			Main.add(Box.createHorizontalStrut(5));
			// Main.add(BottomButtons);

			JPanel PlayersScore = Players();
			// Player PlayersScore = new Player();
			PlayersScore.setPreferredSize(new Dimension(200, 480));

			JPanel flow = new JPanel(new FlowLayout());

			flow.add(PlayersScore);
			flow.add(Box.createVerticalStrut(200));
			flow.add(Main);
			frame.add(flow);
			frame.setVisible(true);

			StartGame();

	}
	
	public static void RunMain(){
		JFrame frame = new JFrame("Yahtzee!");
		frame.setSize(900, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel Main = new JPanel();
		Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS));
		Main.setSize(500, 500);

		ScoreCard = new ScoreCard();

		Dice = new ButtonsAndDice();

		Round = new JLabel("Round 1/13");

		Main.add(Round);
		Main.add(ScoreCard);
		Main.add(Box.createHorizontalStrut(5));
		Main.add(Dice);
		Main.add(Box.createHorizontalStrut(5));
		// Main.add(BottomButtons);

		JPanel PlayersScore = Players();
		// Player PlayersScore = new Player();
		PlayersScore.setPreferredSize(new Dimension(200, 480));

		JPanel flow = new JPanel(new FlowLayout());

		flow.add(PlayersScore);
		flow.add(Box.createVerticalStrut(200));
		flow.add(Main);
		frame.add(flow);
		frame.setVisible(true);

		StartGame();
	}

	public static JPanel Players() {

		JPanel Players = new JPanel();
		Players.setLayout(new BoxLayout(Players, BoxLayout.Y_AXIS));
		Players.setBorder(BorderFactory.createLineBorder(Color.black));

		JPanel temp = new JPanel(new GridLayout(2, 1));
		temp.setBorder(BorderFactory.createLineBorder(Color.black));
		temp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		temp.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		JPanel temp2 = new JPanel(new GridLayout(2, 1));
		temp2.setBorder(BorderFactory.createLineBorder(Color.black));
		temp2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		temp2.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		Player1Score = new JLabel("Score: 0");
		Player1Score.setSize(100, 100);
		Player1Score.setPreferredSize(new Dimension(50, 48));
		Player1Score.setHorizontalAlignment(SwingConstants.CENTER);

		Player2Score = new JLabel("Score: 0");
		Player2Score.setSize(100, 100);
		Player2Score.setPreferredSize(new Dimension(50, 48));
		Player2Score.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Player1Name = new JLabel("Player 1");
		Player1Name.setSize(100, 100);
		Player1Name.setPreferredSize(new Dimension(50, 48));
		Player1Name.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Player2Name = new JLabel("Player 2");
		Player2Name.setSize(100, 100);
		Player2Name.setPreferredSize(new Dimension(50, 48));
		Player2Name.setHorizontalAlignment(SwingConstants.CENTER);

		temp.add(Player1Name);
		temp.add(Player1Score);
		temp2.add(Player2Name);
		temp2.add(Player2Score);

		PlayerPanel[0] = temp;
		PlayerPanel[1] = temp2;

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
				// JOptionPane.showMessageDialog(null,start);

				if (j == 0) {
					PlayerPanel[1].setBorder(BorderFactory.createEmptyBorder());
					PlayerPanel[0].setBorder(BorderFactory.createLineBorder(
							Color.blue, 5));
				}

				// Same as above
				if (j == 1) {
					PlayerPanel[0].setBorder(BorderFactory.createEmptyBorder());
					PlayerPanel[1].setBorder(BorderFactory.createLineBorder(
							Color.blue, 5));
				}

				while (!Players[j].getEndTurn()) {

					System.out.println(Players[j].getEndTurn());
				}

				int TotalCurrent = 0;
				int[] array = Dice.getCurrentPlayer().getScoreCard();
				for (int z = 0; z < 14; z++) {
					TotalCurrent = array[i] + TotalCurrent;
				}

				if (j == 1) {
					String string1 = "Score: " + TotalCurrent;
					Player2Score.setText(string1);
					array = null;
				}
				if (j == 0) {
					String string2 = "Score: " + TotalCurrent;
					Player1Score.setText(string2);
					array = null;
				}

				String curr = "End of Player " + (j + 1) + " Turn.";
				// JOptionPane.showMessageDialog(null,curr);

				ScoreCard.reset();

			}

			String Rounds = "Round " + (i + 1) + "/13";
			Round.setText(Rounds);
		}

	}

}
