package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ScoreCard extends JPanel {

	private static JToggleButton Aces;
	private static JToggleButton Twos;
	private static JToggleButton Threes;
	private static JToggleButton Fours;
	private static JToggleButton Fives;
	private static JToggleButton Sixs;
	private static JToggleButton ThreeKind;
	private static JToggleButton FourKind;
	private static JToggleButton SmallStraight;
	private static JToggleButton FullHouse;
	private static JToggleButton LargeSraight;
	private static JToggleButton Yahtzee;
	private static JToggleButton Chance;
	private static JToggleButton YahtzeeBonus; 
	
	private static JLabel AcesValue;
	private static JLabel TwosScore;
	private static JLabel ThreesValue;
	private static JLabel FoursValue;
	private static JLabel FivesValue;
	private static JLabel SixsValue;
	private static JLabel ThreeKindValue;
	private static JLabel FourKindValue;
	private static JLabel SmallStraightValue;
	private static JLabel FullHouseValue;
	private static JLabel LargeSraightValue;
	private static JLabel YahtzeeValue;
	private static JLabel ChanceValue;
	private static JLabel YahtzeeBonusValue; 
	
	private Player CurrentPlayer;
	private Boolean SetTotalValue;
	private static Color Wine = Color.decode("#722f37");
	private static Color Gold = Color.decode("#FFD700");
	
	public Player getCurrentPlayer() {
		return CurrentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		CurrentPlayer = currentPlayer;
	}

	public ScoreCard() {
		init();
	}

	private void init() {
		// Create the panel for the first score card
		JPanel ScoreCardPanel = new JPanel(new GridLayout(14, 2, 10, 5));
		ScoreCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ScoreCardPanel.setPreferredSize(new Dimension(500, 400)); 

		Aces = new JToggleButton("Aces");
		Aces.setHorizontalAlignment(SwingConstants.CENTER);
		Aces.addActionListener(new AcesValueListener());
		Aces.setBackground(Wine); 
		Aces.setForeground(Color.WHITE);
		Aces.setFocusPainted(false); 
		Aces.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(Aces);

		AcesValue = new JLabel("0");
		AcesValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(AcesValue);

		Twos = new JToggleButton("2s");
		Twos.addActionListener(new TwosValueListener());
		Twos.setHorizontalAlignment(SwingConstants.CENTER);
		Twos.setBackground(Wine); 
		Twos.setForeground(Color.WHITE);
		Twos.setFocusPainted(false); 
		Twos.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(Twos);

		TwosScore = new JLabel("0");
		TwosScore.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(TwosScore);

		Threes = new JToggleButton("3s");
		Threes.addActionListener(new ThreesValueListener());
		Threes.setHorizontalAlignment(SwingConstants.CENTER);
		Threes.setBackground(Wine); 
		Threes.setForeground(Color.WHITE);
		Threes.setFocusPainted(false); 
		Threes.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(Threes);

		ThreesValue = new JLabel("0");
		ThreesValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(ThreesValue);

		Fours = new JToggleButton("4s");
		Fours.addActionListener(new FoursValueListener());
		Fours.setHorizontalAlignment(SwingConstants.CENTER);
		Fours.setBackground(Wine); 
		Fours.setForeground(Color.WHITE);
		Fours.setFocusPainted(false); 
		Fours.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(Fours);

		FoursValue = new JLabel("0");
		FoursValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(FoursValue);

		Fives = new JToggleButton("5s");
		Fives.addActionListener(new FivesValueListener());
		Fives.setHorizontalAlignment(SwingConstants.CENTER);
		Fives.setBackground(Wine); 
		Fives.setForeground(Color.WHITE);
		Fives.setFocusPainted(false); 
		Fives.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(Fives);
		
		FivesValue = new JLabel("0");
		FivesValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(FivesValue);

		Sixs = new JToggleButton("6s");
		Sixs.addActionListener(new SixesValueListener());
		Sixs.setHorizontalAlignment(SwingConstants.CENTER);
		Sixs.setBackground(Wine); 
		Sixs.setForeground(Color.WHITE);
		Sixs.setFocusPainted(false); 
		Sixs.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(Sixs);

		SixsValue = new JLabel("0"); 
		SixsValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(SixsValue);

		ThreeKind = new JToggleButton("3 of a kind");
		ThreeKind.addActionListener(new ThreeValueListener());
		ThreeKind.setHorizontalAlignment(SwingConstants.CENTER);
		ThreeKind.setBackground(Wine); 
		ThreeKind.setForeground(Color.WHITE);
		ThreeKind.setFocusPainted(false); 
		ThreeKind.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(ThreeKind);

		ThreeKindValue = new JLabel("0");
		ThreeKindValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(ThreeKindValue);

		FourKind = new JToggleButton("4 of a king");
		FourKind.addActionListener(new FourValueListener());
		FourKind.setHorizontalAlignment(SwingConstants.CENTER);
		FourKind.setBackground(Wine); 
		FourKind.setForeground(Color.WHITE);
		FourKind.setFocusPainted(false); 
		FourKind.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(FourKind);

		FourKindValue = new JLabel("0");
		FourKindValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(FourKindValue);

		FullHouse = new JToggleButton("Full House");
		FullHouse.addActionListener(new FullHouseValueListener()); 
		FullHouse.setHorizontalAlignment(SwingConstants.CENTER);
		FullHouse.setBackground(Wine); 
		FullHouse.setForeground(Color.WHITE);
		FullHouse.setFocusPainted(false); 
		FullHouse.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(FullHouse);

		FullHouseValue = new JLabel("0");
		FullHouseValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(FullHouseValue);

		SmallStraight = new JToggleButton("Small Straight");
		SmallStraight.addActionListener(new smallStraightValueListener()); 
		SmallStraight.setHorizontalAlignment(SwingConstants.CENTER);
		SmallStraight.setBackground(Wine); 
		SmallStraight.setForeground(Color.WHITE);
		SmallStraight.setFocusPainted(false); 
		SmallStraight.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(SmallStraight);

		SmallStraightValue = new JLabel("0");
		SmallStraightValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(SmallStraightValue);

		LargeSraight = new JToggleButton("Large Straight");
		LargeSraight.addActionListener(new LargeStraightValueListener());
		LargeSraight.setHorizontalAlignment(SwingConstants.CENTER);
		LargeSraight.setBackground(Wine); 
		LargeSraight.setForeground(Color.WHITE);
		LargeSraight.setFocusPainted(false); 
		LargeSraight.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(LargeSraight);

		LargeSraightValue = new JLabel("0");
		LargeSraightValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(LargeSraightValue);

		Yahtzee = new JToggleButton("Yahtzee");
		Yahtzee.addActionListener(new YahtzeeValueListener()); 
		Yahtzee.setHorizontalAlignment(SwingConstants.CENTER);
		Yahtzee.setBackground(Wine); 
		Yahtzee.setForeground(Color.WHITE);
		Yahtzee.setFocusPainted(false); 
		Yahtzee.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(Yahtzee);

		YahtzeeValue = new JLabel("0");
		YahtzeeValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(YahtzeeValue);

		Chance = new JToggleButton("Chance");
		Chance.addActionListener(new ChanceValueListener()); 
		Chance.setHorizontalAlignment(SwingConstants.CENTER);
		Chance.setBackground(Wine); 
		Chance.setForeground(Color.WHITE);
		Chance.setFocusPainted(false); 
		Chance.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(Chance);

		ChanceValue = new JLabel("0");
		ChanceValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(ChanceValue);
		
		YahtzeeBonus = new JToggleButton("Yahtzee Bonus");
		YahtzeeBonus.setHorizontalAlignment(SwingConstants.CENTER);
		YahtzeeBonus.setBackground(Wine); 
		YahtzeeBonus.setForeground(Color.WHITE);
		YahtzeeBonus.setFocusPainted(false); 
		YahtzeeBonus.setBorder(BorderFactory.createLineBorder(Gold, 1));
		ScoreCardPanel.add(YahtzeeBonus);

		YahtzeeBonusValue = new JLabel("0");
		YahtzeeBonusValue.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreCardPanel.add(YahtzeeBonusValue);

		ScoreCardPanel.setBackground(Color.black);
		this.add(ScoreCardPanel);
	}

	void reset() {
		AcesValue.setText("0");
		TwosScore.setText("0");
		ThreesValue.setText("0");
		FoursValue.setText("0");
		FivesValue.setText("0");
		SixsValue.setText("0");
		ThreeKindValue.setText("0");
		FourKindValue.setText("0");
		SmallStraightValue.setText("0");
		FullHouseValue.setText("0");
		LargeSraightValue.setText("0");
		YahtzeeValue.setText("0");
		ChanceValue.setText("0");

		AcesValue.setForeground(null); 
		TwosScore.setForeground(null); 
		ThreesValue.setForeground(null); 
		FoursValue.setForeground(null); 
		FivesValue.setForeground(null); 
		SixsValue.setForeground(null); 
		ThreeKindValue.setForeground(null); 
		FourKindValue.setForeground(null); 
		SmallStraightValue.setForeground(null); 
		FullHouseValue.setForeground(null); 
		LargeSraightValue.setForeground(null); 
		YahtzeeValue.setForeground(null); 
		ChanceValue.setForeground(null); 
		
		// reset any that are selected to not be
		Aces.setSelected(false); 
		Twos.setSelected(false);
		Threes.setSelected(false);
		Fours.setSelected(false);
		Fives.setSelected(false);
		Sixs.setSelected(false);
		ThreeKind.setSelected(false);
		FourKind.setSelected(false);
		SmallStraight.setSelected(false);
		FullHouse.setSelected(false);
		LargeSraight.setSelected(false);
		Yahtzee.setSelected(false);
		Chance.setSelected(false);
	}

	private class AcesValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[0] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					for (int i = 0; i < 5; i++) {
						System.out.println(Current[i]);
						if (Current[i] == 1) {
							total += 1;

						}
					}

					String str = total + " ";
					AcesValue.setText(str);
					AcesValue.setForeground(Gold); 
					ScoreCardValues[0] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class TwosValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[1] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					for (int i = 0; i < 5; i++) {
						System.out.println(Current[i]);
						if (Current[i] == 2) {
							total += 2;

						}
					}

					String str = total + " ";
					TwosScore.setText(str);
					TwosScore.setForeground(Gold);
					ScoreCardValues[1] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class ThreesValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[2] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					for (int i = 0; i < 5; i++) {
						System.out.println(Current[i]);
						if (Current[i] == 3) {
							total += 3;

						}
					}

					String str = total + " ";
					ThreesValue.setText(str);
					ThreesValue.setForeground(Gold);
					ScoreCardValues[2] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class FoursValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[3] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					for (int i = 0; i < 5; i++) {
						System.out.println(Current[i]);
						if (Current[i] == 4) {
							total += 4;

						}
					}

					String str = total + " ";
					FoursValue.setText(str);
					FoursValue.setForeground(Gold);
					ScoreCardValues[3] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class FivesValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[4] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					for (int i = 0; i < 5; i++) {
						System.out.println(Current[i]);
						if (Current[i] == 5) {
							total += 5;

						}
					}

					String str = total + " ";
					FivesValue.setText(str);
					FivesValue.setForeground(Gold);
					ScoreCardValues[4] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class SixesValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[5] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					for (int i = 0; i < 5; i++) {
						System.out.println(Current[i]);
						if (Current[i] == 6) {
							total += 6;

						}
					}

					String str = total + " ";
					SixsValue.setText(str);
					SixsValue.setForeground(Gold);
					ScoreCardValues[5] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class ThreeValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[6] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					int count = 0;
					for (int i = 0; i < 5; i++) {
						for (int j = i + 1; j < 5; j++) {
							if (Current[i] == Current[j])
								count++;
						}

						if (count >= 2) {
							total = Current[i] * 3;
							break;
						} else
							count = 0;
					}

					if (total != 0) {
						total = 0;
						for (int i = 0; i < 5; i++)
							total = Current[i] + total;
					}

					String str = total + " ";
					ThreeKindValue.setText(str);
					ThreeKindValue.setForeground(Gold);
					ScoreCardValues[6] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class FourValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[7] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					int count = 0;
					for (int i = 0; i < 5; i++) {
						for (int j = i + 1; j < 5; j++) {
							if (Current[i] == Current[j])
								count++;
						}

						if (count >= 3) {
							total = 1;
							break;
						} else
							count = 0;
					}

					if (total != 0) {
						for (int i = 0; i < 5; i++)
							total = Current[i] + total;
					}

					String str = total + " ";
					FourKindValue.setText(str);
					FourKindValue.setForeground(Gold);
					ScoreCardValues[7] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class FullHouseValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[8] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					int triple = 0;
					for (int i = 0; i < 5; i++) {
						for (int j = i + 1; j < 5; j++) {
							if (Current[i] == Current[j])
								triple++;
						}

						if (triple >= 2) {
							triple = 1;
							break;
						} else
							triple = 0;
					}
					
					int doubles = 0;
					for (int i = 0; i < 5; i++) {
						for (int j = i + 1; j < 5; j++) {
							if (Current[i] == Current[j])
								doubles++;
						}

						if (doubles >= 1){
							doubles = 1;
							break;
						} else
							doubles = 0;
					}

					if (doubles == 1 && triple == 1) 
					{
						total = 25; 
					}

					String str = " " + total + " ";
					FullHouseValue.setText(str);
					FullHouseValue.setForeground(Gold);
					ScoreCardValues[8] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class smallStraightValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[9] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					Current = BubbleSort(Current); 
					
					int counter = 0;
					for(int i =0; i < 5; i++)
					{
						int num = Current[i] + 1; 
						for(int j = i+1; j < 5; j++)
						{
							if(num == Current[j])
							{
								counter++; 
								num++;
								continue; 
							}
							if(counter == 3)
							{
								total = 1; 
								break;
							}
							
							
								 
						}
						
						if(counter == 3)
						{
							total = 1; 
							break;
						}
						
						counter= 0; 
					}
					
					if(total == 1)
						total = 30; 
					else 
						total = 0; 
					
					String str = " " + total + " ";
					SmallStraightValue.setText(str);
					SmallStraightValue.setForeground(Gold);
					ScoreCardValues[9] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class LargeStraightValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[10] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					Current = BubbleSort(Current); 
					
					int counter = 0;
					for(int i =0; i < 5; i++)
					{
						int num = Current[i] + 1; 
						for(int j = i+1; j < 5; j++)
						{
							if(num == Current[j])
							{
								counter++; 
								num++;
								continue; 
							}
							if(counter == 4)
							{
								total = 1; 
								break;
							}
							
							
								 
						}
						
						if(counter == 4)
						{
							total = 1; 
							break;
						}
						
						counter= 0; 
					}
					
					if(total == 1)
						total = 40; 
					else 
						total = 0; 
					
					String str = " " + total + " ";
					LargeSraightValue.setText(str);
					LargeSraightValue.setForeground(Gold);
					ScoreCardValues[10] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class YahtzeeValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[11] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					Current = BubbleSort(Current); 
					
					int counter = 0;
					int Number = Current[0]; 
					for(int i = 1; i < 5; i++)
					{
						if(Current[i] == Number)
							counter++; 
					}
					
					if(counter == 4)
						total = 50; 
					else 
						total = 0; 
					
					
					
					String str = " " + total + " ";
					YahtzeeValue.setText(str);
					YahtzeeValue.setForeground(Gold);
					ScoreCardValues[11] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}

	private class ChanceValueListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int[] ScoreCardValues = CurrentPlayer.getScoreCard();

			if (ScoreCardValues[12] == 0) {
				if (ae.getSource() instanceof JToggleButton) {

					int total = 0;

					int[] Current = CurrentPlayer.getCurrentValues();

					Current = BubbleSort(Current); 
					
					total = Current[0] + Current[1] + Current[2] + Current[3] + Current[4];  
					
					String str = " " + total + " ";
					ChanceValue.setText(str);
					ChanceValue.setForeground(Gold);
					ScoreCardValues[12] = total;
					CurrentPlayer.setScoreCard(ScoreCardValues); 
				}
			}
		}
	}
	
	public static int[] BubbleSort( int [ ] num )
	{
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < num.length -1;  j++ )
	            {
	                   if ( num[ j ] > num[j+1] )   // change to > for ascending sort
	                   {
	                           temp = num[ j ];                //swap elements
	                           num[ j ] = num[ j+1 ];
	                           num[ j+1 ] = temp;
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      } 
	     
	     return num; 
	} 
	 
	
}
