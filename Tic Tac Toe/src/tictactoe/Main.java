package tictactoe;

import java.util.Random;

import tictactoe.aicode.AiLogic;
import tictactoe.aicode.HumanLogic;

public class Main {
	int[] gameBoard = new int[9];
	int currentMove = 0;
	Random rand = new Random();
	AiLogic mrartificial = new AiLogic();
	HumanLogic mrreal = new HumanLogic();
	CommonLogic clogic = new CommonLogic();
	
	public Main() {
	}

	public static void main(String[] args) {
		int currentTurn = 1;
		int returnedInput = 0;
		int winner = 0;
		int aiIq = 0;
		int aiTurn = 1;

		boolean inputIsValid = false;
		boolean dualAi = false;

		Main var = new Main();
		if (args.length <= 0) { // No args case. Show Usage and exit
			var.showUsage();
			return;
		}

		if (args.length >= 1) { // Handle "AI Intelligence" logic
			switch (args[0]) { // We know we have at least one arg. Process
								// args[0]
			case ("0"): // Ai Disabled
				aiIq = 0;
				break;
			case ("1"): // Ai Level 1
				aiIq = 1;
				break;
			case ("2"): // Ai Level 2
				aiIq = 2;
				break;
			default:
				var.showUsage();
				System.exit(1);
			}
		}
		if (args.length >= 2) { // Handle "AI Player" logic
			switch (args[1]) { // We know we have at least two args. Process
								// args[1]
			case ("1"):
				aiTurn = 1;
				break;
			case ("2"):
				aiTurn = 2;
				break;
			}
		}
		var.gameBoard[0] = 0;
		var.gameBoard[1] = 0;
		var.gameBoard[2] = 0;
		var.gameBoard[3] = 0;
		var.gameBoard[4] = 0;
		var.gameBoard[5] = 0;
		var.gameBoard[6] = 0;
		var.gameBoard[7] = 0;
		var.gameBoard[8] = 0;
		
		
		do { // Main gameloop

			var.drawScreen(currentTurn, false); // Print gameboard to screen
			returnedInput = var.getInput(aiIq, aiTurn, currentTurn, dualAi); // Get input from current player
			inputIsValid = var.checkInput(returnedInput, currentTurn); // Make sure the input is valid - the slot picked is aval and a real slot
			if (inputIsValid) {
				var.setBoard(returnedInput, currentTurn); // Change Board
			}
			currentTurn = var.setTurn(currentTurn, inputIsValid); // Set the turn

			if ((winner = var.checkForWinner()) != 0) { // Check game over
				break;
			} else {
				winner = var.checkGameTie();
			}

		} while (winner == 0);

		var.drawScreen(currentTurn, true);
		System.out.println("Game Over!");
		if (winner == 3) {
			System.out.println("Aww, it's a tie");
		} else {
			System.out.println("Player " + winner + " has won!");
		}
		System.exit(0);
	}

	private int setTurn(int currentTurn, boolean inputIsValid) {
		if (inputIsValid) {
			currentTurn = 3 - currentTurn;
			currentMove++;
		}
		return currentTurn;
	}

	private static String[] map = { " ", "X", "O" }; // Set to char

	private String getPosition(int position) {
		if (position >= 0 && position < gameBoard.length) {
			return map[gameBoard[position]];
		}
		return map[0];
	}

	private void drawScreen(int currentTurn2, boolean gamedone) {
		// System.out.println("a"+"\n"+"hi"); // new line test

		clearScreen(50);
		if (gamedone == true) {
			System.out.println("================================================================================");
			System.out.println();
			System.out.println((getPosition(0)) + " | " + (getPosition(1)) + " | " + (getPosition(2)));
			System.out.println("---------");
			System.out.println((getPosition(3)) + " | " + (getPosition(4)) + " | " + (getPosition(5)));
			System.out.println("---------");
			System.out.println((getPosition(6)) + " | " + (getPosition(7)) + " | " + (getPosition(8)));
			System.out.println();
			System.out.println("================================================================================");
		} else {
			System.out.println("================================================================================");
			System.out.println("Player " + currentTurn2 + "'s turn");
			System.out.println();
			System.out.println("================================================================================");
			System.out.println();
			System.out.println();
			System.out.println("               Slot  Key");
			System.out.println((getPosition(0)) + " | " + (getPosition(1)) + " | " + (getPosition(2)) + "      0 | 1 | 2");
			System.out.println("---------      ---------");
			System.out.println((getPosition(3)) + " | " + (getPosition(4)) + " | " + (getPosition(5)) + "      3 | 4 | 5");
			System.out.println("---------      ---------");
			System.out.println((getPosition(6)) + " | " + (getPosition(7)) + " | " + (getPosition(8)) + "      6 | 7 | 8");
			System.out.println();
			System.out.println();
			System.out.println("================================================================================");
		}
	}

	private int getInput(int aiIq, int aiPlayer, int currentTurn, boolean AIvsAI) {
		int input = 0;

		if (AIvsAI == true) {
			input = doAITurn(aiIq, aiPlayer);
		} else {
			if (aiIq == 0)
				aiPlayer = 0;
			if (aiPlayer == currentTurn){
				input = doAITurn(aiIq, aiPlayer);
			}else{
				input = mrreal.doMove();
			}
		}
		return input;
	}

	private boolean checkInput(int input, int currentTurn1) {
		boolean valid = false;
		if (gameBoard[input] == 0) {// value 0 means unclaimed
			valid = true;
		} else {
			valid = false;
			System.out.println("That slot has already been used");
		}
		return valid;
	}

	private void setBoard(int Location, int changeFor) {
		gameBoard[Location] = changeFor;
	}

	private int checkForWinner() {
		int winner = 0;

		loop1: for (int combo = 0; combo < 8; combo++) {
			if (winner != 0) {
				break loop1;
			}
			switch (combo) {
			case 0:
				winner = clogic.compareThree(gameBoard[0], gameBoard[1], gameBoard[2]);
				break;
			case 1:
				winner = clogic.compareThree(gameBoard[3], gameBoard[4], gameBoard[5]);
				break;
			case 2:
				winner = clogic.compareThree(gameBoard[6], gameBoard[7], gameBoard[8]);
				break;
			case 3:
				winner = clogic.compareThree(gameBoard[0], gameBoard[3], gameBoard[6]);
				break;
			case 4:
				winner = clogic.compareThree(gameBoard[1], gameBoard[4], gameBoard[7]);
				break;
			case 5:
				winner = clogic.compareThree(gameBoard[2], gameBoard[5], gameBoard[8]);
				break;
			case 6:
				winner = clogic.compareThree(gameBoard[0], gameBoard[4], gameBoard[8]);
				break;
			case 7:
				winner = clogic.compareThree(gameBoard[2], gameBoard[4], gameBoard[6]);
				break;
			}
		}
		return winner;
	}

	private int checkGameTie() {
		int isTie = 3;
		loop: for (int index = 0; index <= 8; index++) {
			if (gameBoard[index] == 0) {
				isTie = 0;
				break loop;
			}
		}
		return isTie;
	}

	private void clearScreen(int makeLines) {
		for (int count = 0; count <= makeLines; count++) {
			System.out.println();
		}
	}

	private int doAITurn(int aiIq, int aiPlayer) {
//		int waittime = 0;
//		String text = "Computer Thinking";
//
//		for (int index = 0; index <= 3; index++) {
//			try {
//				Thread.sleep(waittime);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(text = text + ".");
//		}
		return mrartificial.doMove(aiIq, aiPlayer, currentMove, gameBoard);
	}
	
	private void showUsage() {
		System.out.println("Usage: command <AI Intelegence> [AI Player]");
		System.out.println("For no AI put 0");
	}


}
