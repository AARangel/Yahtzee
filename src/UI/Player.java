package UI;

public class Player {

	private Boolean EndTurn = null; 
	private int[] CurrentValues = new int[5]; 

	public Player(){
		
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

}
