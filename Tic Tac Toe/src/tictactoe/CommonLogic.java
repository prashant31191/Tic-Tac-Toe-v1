package tictactoe;

public class CommonLogic {
	
	public int compareThree(int a, int b, int c) {
		int winner = 0;
		if ((a != 0) && (b != 0) && (c != 0)) {
			if ((a == b) && (b == c) && (c == a)) {
				winner = a;
			}
		}
		return winner;
	}
	
	
	
}
