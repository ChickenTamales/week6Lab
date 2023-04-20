package week6;

import java.util.Arrays;

public class GameBoard {

	//an array of String called 'board' with 9 spaces in a grid
	String[] board = new String[9];
	
	//a way to initialize the board
	public void initialize() {
		for (int i = 1; i <= 9; i++) {
			this.board[i-1] = String.valueOf(i);//this.board[i-1] because the first index is 0
		}
	}
	//print gameboard to the console
	public void display() {
		System.out.println("     +---+---+---+");//top border of the gameboard
		System.out.println("     | " + this.board[0] + " | " + this.board[1] + " | " + this.board[2] + " | ");
		System.out.println("     +---+---+---+");
		System.out.println("     | " + this.board[3] + " | " + this.board[4] + " | " + this.board[5] + " | ");
		System.out.println("     +---+---+---+");
		System.out.println("     | " + this.board[6] + " | " + this.board[7] + " | " + this.board[8] + " | ");
		System.out.println("     +---+---+---+");//bottom border of the gameboard
	}
	public boolean ifValidSetSquare(int squareNumber, String readInput, String player) {
		if (this.board[squareNumber-1].equals(readInput)) {//if board contains the String 'readInput' then we can set it to the value of the player
			this.board[squareNumber-1] = player;
			return true;
		}else {
		return false;
	}
	}
	public String checkWinStatus() {//checks to see if someone has won
		for (int pos = 0; pos < 8; pos++) {
			String winningCombo = "";//starts the winningCombo at empty, to be filled when game is over
			
			switch (pos) {
			case 0:
				winningCombo = this.board[0] + this.board[1] + this.board[2];//first row across
				break;
			case 1:
				winningCombo = this.board[3] + this.board[4] + this.board[5];//second row across
				break;
			case 2:
				winningCombo = this.board[6] + this.board[7] + this.board[8];//third row across
				break;
			case 3:
				winningCombo = this.board[0] + this.board[3] + this.board[6];//first column from the left
				break;
			case 4:
				winningCombo = this.board[1] + this.board[4] + this.board[7];//second column from the left
				break;
			case 5:
				winningCombo = this.board[2] + this.board[5] + this.board[8];//third column from the left
				break;
			case 6:
				winningCombo = this.board[0] + this.board[4] + this.board[8];//diagonal line from top left to bottom right
				break;
			case 7:
				winningCombo = this.board[2] + this.board[4] + this.board[6];//diagonal line from top right to bottom left
				break;
			}
			if (winningCombo.equals("XXX")) {
				return "X";
			}else if (winningCombo.equals("OOO")) {
				return "O";			}
		}
		for (int pos = 1; pos <=9; pos++) {//check for a draw
			if (Arrays.asList(this.board).contains(String.valueOf(pos))) {//if there is no number
				break;
			}else if (pos ==9) {//if we are actually at the last position with no numbers left, declare a draw
				return "draw";
			}
			
		}
		return "";//means there is no winner and it is not a draw
	}
}
