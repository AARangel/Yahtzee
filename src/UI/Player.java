package UI;

//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.GridLayout;

import javax.swing.*;

public class Player extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean EndTurn = null; 
	private int[] CurrentValues = new int[5]; 
	private int[] ScoreCard = new int[14]; 
	private int TotalScore = 0; 
	private int TempScore = 0; 
	private Boolean Keep = false; 

	public int getTempScore() {
		return TempScore;
	}

	public void setTempScore(int tempScore) {
		TempScore = tempScore;
	}

	public Boolean getKeep() {
		return Keep;
	}

	public void setKeep(Boolean keep) {
		Keep = keep;
	}

	public Player(){
		for(int i = 0; i < ScoreCard.length; i++)
		{
			ScoreCard[i] = 0; 
		}
	}
		
	public int[] getCurrentValues() {
		return CurrentValues;
	}

	public void setCurrentValues(int[] currentValues) {
		CurrentValues = currentValues;
	}	

	public Boolean getEndTurn() {
		return EndTurn;
	}

	public void setEndTurn(Boolean endTurn) {
		EndTurn = endTurn;
	}

	public int[] getScoreCard() {
		return ScoreCard;
	}

	public void setScoreCard(int[] scoreCard) {
		ScoreCard = scoreCard;
	}

	public int getTotalScore() {
		return TotalScore;
	}

	public void setTotalScore(int totalScore) {
		TotalScore = totalScore;
	}

}
