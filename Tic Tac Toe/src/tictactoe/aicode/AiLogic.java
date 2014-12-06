package tictactoe.aicode;

import java.util.Random;

import tictactoe.CommonLogic;

public class AiLogic {
	Random rand = new Random();
	CommonLogic clogic = new CommonLogic();
	int[] gameBoard;
	
	public AiLogic() {
		
	}

	public int doMove(int aiIq, int aiTurn, int currentTurn, int[] gameBoard) {
		int move = 0;
		int var = 0;
		int oppPlayer = 0;
		int me = 0;
		int[] moves;
		this.gameBoard = gameBoard;

		// me is 1 for EVEN, 2 for ODD..
		me = (currentTurn % 2) + 1;
		// Then set oppPlayer to the "opposite"..
		oppPlayer = 3 - me;

		if (aiIq == 1) {
			move = rand.nextInt(9);
		} else {
			if ((var = aboutToWin(me)) != 9) {// check for a winning move for me
				move = var;
			} else if ((var = aboutToWin(oppPlayer)) != 9) {
				// check for a winning move for opp
				move = var;
			} else {// else use my strategy to pick move
				move = rand.nextInt(9); // pick random move in case of error
				switch (currentTurn) {
				case (0):
					// Player 1
					moves = getAvalMoves(true, true, false);
					var = rand.nextInt(moves.length);
					move = moves[var];
					break;
				case (1):
					// Player 2
					moves = getAvalMoves(false, true, false);
					if (moves.length == 0) {
						moves = getAvalMoves(true, false, false);
						var = rand.nextInt(moves.length);
						move = moves[var];
					} else {
						move = 4;
					}
					break;
				case (2):
					// Player 1
					moves = getAvalMoves(true, true, false);
					var = rand.nextInt(moves.length);
					move = moves[var];
					break;
				case (3):
					// Player 2
					if((move = finddoublecross(oppPlayer)) != 9){
						break;
					}
					if (gameBoard[4] == me) {
						moves = getAvalMoves(false, false, true);
						var = rand.nextInt(moves.length);
						move = moves[var];
					} else {
						moves = getAvalMoves(true, false, false);
						var = rand.nextInt(moves.length);
						move = moves[var];
					}
					break;
				case (4):
					// Player 1
					moves = getAvalMoves(true, true, false);
					var = rand.nextInt(moves.length);
					move = moves[var];
					break;
				case (5):
					// Player 2
					moves = getAvalMoves(true, true, true);
					var = rand.nextInt(moves.length);
					move = moves[var];
					break;
				case (6):
					// Player 1
					moves = getAvalMoves(true, true, true);
					var = rand.nextInt(moves.length);
					move = moves[var];
					break;
				case (7):
					// Player 2
					moves = getAvalMoves(true, true, true);
					var = rand.nextInt(moves.length);
					move = moves[var];
					break;
				case (8):
					// Player 1
					moves = getAvalMoves(true, true, true);
					var = rand.nextInt(moves.length);
					move = moves[var];
					break;
				}
			}
		}

		return move;
	}

	private int finddoublecross(int oppPlayer) {
		if(clogic.compareThree(gameBoard[3], gameBoard[1], oppPlayer) == oppPlayer){
			return 0;
		}
		if(clogic.compareThree(gameBoard[3], gameBoard[7], oppPlayer) == oppPlayer){
			return 6;
		}
		if(clogic.compareThree(gameBoard[5], gameBoard[7], oppPlayer) == oppPlayer){
			return 8;
		}
		if(clogic.compareThree(gameBoard[5], gameBoard[1], oppPlayer) == oppPlayer){
			return 2;
		}
		return 9;
	}

	private int doMovePlayer1(int currentMove, int[] gameBoard) {
		// int var = 0;
		// int move = 0;
		// int count = 0;
		//
		// int[] movesList;
		//
		// boolean countIsTooSmall = false;
		//
		// if (countWinningMoves(1, gameBoard).length != 0) {
		// movesList = countWinningMoves(1, gameBoard);
		// var = rand.nextInt(movesList.length);
		// move = movesList[var];
		// return move;
		// }
		// if (countWinningMoves(2, gameBoard).length != 0) {
		// movesList = countWinningMoves(2, gameBoard);
		// var = rand.nextInt(movesList.length);
		// move = movesList[var];
		// return move;
		// }
		// if (currentMove == 1) {
		// boolean cornerUsed = false;
		// boolean centerUsed = false;
		//
		// if ((getBoardState("corner", 0, gameBoard)) != 0) {
		// count++;
		// cornerUsed = true;
		// }
		// if ((getBoardState("corner", 1, gameBoard)) != 0) {
		// count++;
		// cornerUsed = true;
		// }
		// if ((getBoardState("corner", 2, gameBoard)) != 0) {
		// count++;
		// cornerUsed = true;
		// }
		// if ((getBoardState("corner", 3, gameBoard)) != 0) {
		// count++;
		// cornerUsed = true;
		// }
		// if ((getBoardState("center", 0, gameBoard)) != 0) {
		// count++;
		// centerUsed = true;
		// }
		// if (cornerUsed == true) {
		// return 4;
		//
		// } else if (centerUsed == true) {
		// // Pick a corner
		// if ((getBoardState("corner", 0, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("corner", 1, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("corner", 2, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("corner", 3, gameBoard)) == 0) {
		// count++;
		// }
		// movesList = new int[count];
		// count = 0;
		// if ((getBoardState("corner", 0, gameBoard)) == 0) {
		// movesList[count] = 0;
		// count++;
		// }
		// if ((getBoardState("corner", 1, gameBoard)) == 0) {
		// movesList[count] = 2;
		// count++;
		// }
		// if ((getBoardState("corner", 2, gameBoard)) == 0) {
		// movesList[count] = 6;
		// count++;
		// }
		// if ((getBoardState("corner", 3, gameBoard)) == 0) {
		// movesList[count] = 8;
		// count++;
		// }
		// var = rand.nextInt(movesList.length);
		// move = movesList[var];
		// return move;
		// }
		//
		// }
		//
		// if ((getBoardState("corner", 0, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("corner", 1, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("corner", 2, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("corner", 3, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("center", 0, gameBoard)) == 0) {
		// count++;
		// }
		//
		// if (count <= 1) {
		// countIsTooSmall = true;
		// if ((getBoardState("side", 0, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("side", 1, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("side", 2, gameBoard)) == 0) {
		// count++;
		// }
		// if ((getBoardState("side", 3, gameBoard)) == 0) {
		// count++;
		// }
		// }
		//
		// movesList = new int[count];
		// count = 0;
		// if ((getBoardState("corner", 0, gameBoard)) == 0) {
		// movesList[count] = 0;
		// count++;
		// }
		// if ((getBoardState("corner", 1, gameBoard)) == 0) {
		// movesList[count] = 2;
		// count++;
		// }
		// if ((getBoardState("corner", 2, gameBoard)) == 0) {
		// movesList[count] = 6;
		// count++;
		// }
		// if ((getBoardState("corner", 3, gameBoard)) == 0) {
		// movesList[count] = 8;
		// count++;
		// }
		// if ((getBoardState("center", 0, gameBoard)) == 0) {
		// movesList[count] = 4;
		//
		// }
		// if (countIsTooSmall) {
		// if ((getBoardState("side", 0, gameBoard)) == 0) {
		// movesList[count] = 3;
		// count++;
		// }
		// if ((getBoardState("side", 1, gameBoard)) == 0) {
		// movesList[count] = 1;
		// count++;
		// }
		// if ((getBoardState("side", 2, gameBoard)) == 0) {
		// movesList[count] = 5;
		// count++;
		// }
		// if ((getBoardState("side", 3, gameBoard)) == 0) {
		// movesList[count] = 7;
		// count++;
		// }
		//
		// }
		//
		// var = rand.nextInt(movesList.length);
		// move = movesList[var];
		// return move;
		return 0; // (DWN) to keep the compiler happy...
	}

	private int[] countWinningMoves(int player, int[] gameBoard) {
		int movecount = 0;
		int count = 0;
		int[] moves;
		int[] winmoves;

		if ((getBoardState("corner", 0)) == 0) {
			count++;
		}
		if ((getBoardState("corner", 1)) == 0) {
			count++;
		}
		if ((getBoardState("corner", 2)) == 0) {
			count++;
		}
		if ((getBoardState("corner", 3)) == 0) {
			count++;
		}
		if ((getBoardState("center", 0)) == 0) {
			count++;
		}
		if ((getBoardState("side", 0)) == 0) {
			count++;
		}
		if ((getBoardState("side", 1)) == 0) {
			count++;
		}
		if ((getBoardState("side", 2)) == 0) {
			count++;
		}
		if ((getBoardState("side", 3)) == 0) {
			count++;
		}

		moves = new int[count];
		count = 0;

		if ((getBoardState("corner", 0)) == 0) {
			moves[count] = 0;
			count++;
		}
		if ((getBoardState("corner", 1)) == 0) {
			moves[count] = 2;
			count++;
		}
		if ((getBoardState("corner", 2)) == 0) {
			moves[count] = 6;
			count++;
		}
		if ((getBoardState("corner", 3)) == 0) {
			moves[count] = 8;
			count++;
		}
		if ((getBoardState("center", 0)) == 0) {
			moves[count] = 4;
			count++;
		}
		if ((getBoardState("side", 0)) == 0) {
			moves[count] = 3;
			count++;
		}
		if ((getBoardState("side", 1)) == 0) {
			moves[count] = 1;
			count++;
		}
		if ((getBoardState("side", 2)) == 0) {
			moves[count] = 5;
			count++;
		}
		if ((getBoardState("side", 3)) == 0) {
			moves[count] = 7;
			count++;
		}

		for (int index = 0; index < count; index++) {
			// now check the open moves for a winning case
			if (isWinningMove(moves[index], player) == true) {
				movecount++;
			}
		}
		winmoves = new int[movecount];
		int var = 0;
		for (int index = 0; index < count; index++) {
			// now check the open moves for a winning case
			if (isWinningMove(moves[index], player) == true) {
				winmoves[var] = moves[index];
				var++;
			}
		}
		return winmoves;

	}

	private boolean isWinningMove(int movetocheck, int forplayer) {
		switch (movetocheck) {// for every move check all posible three in a row
								// combos
		case (0):
			if (clogic.compareThree(gameBoard[1], gameBoard[2], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[3], gameBoard[6], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[4], gameBoard[8], forplayer) == forplayer) {
				return true;
			}
			break;
		case (1):
			if (clogic.compareThree(gameBoard[0], gameBoard[2], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[4], gameBoard[7], forplayer) == forplayer) {
				return true;
			}
			break;
		case (2):
			if (clogic.compareThree(gameBoard[5], gameBoard[8], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[0], gameBoard[1], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[6], gameBoard[4], forplayer) == forplayer) {
				return true;
			}
			break;
		case (3):
			if (clogic.compareThree(gameBoard[0], gameBoard[6], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[4], gameBoard[5], forplayer) == forplayer) {
				return true;
			}
			break;
		case (4):
			if (clogic.compareThree(gameBoard[1], gameBoard[7], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[3], gameBoard[5], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[0], gameBoard[8], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[6], gameBoard[2], forplayer) == forplayer) {
				return true;
			}
			break;
		case (5):
			if (clogic.compareThree(gameBoard[8], gameBoard[2], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[3], gameBoard[4], forplayer) == forplayer) {
				return true;
			}
			break;
		case (6):
			if (clogic.compareThree(gameBoard[0], gameBoard[3], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[7], gameBoard[8], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[4], gameBoard[2], forplayer) == forplayer) {
				return true;
			}
			break;
		case (7):
			if (clogic.compareThree(gameBoard[6], gameBoard[8], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[4], gameBoard[1], forplayer) == forplayer) {
				return true;
			}
			break;
		case (8):
			if (clogic.compareThree(gameBoard[7], gameBoard[6], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[5], gameBoard[2], forplayer) == forplayer) {
				return true;
			}
			if (clogic.compareThree(gameBoard[0], gameBoard[4], forplayer) == forplayer) {
				return true;
			}
			break;
		}

		return false;
	}

	private int aboutToWin(int playerToCheck) {
		int count = 9;
		int[] list;
		boolean var = false;

		list = getAvalMoves(true, true, true);

		for (int index = 0; index < list.length; index++) {
			var = isWinningMove(list[index], playerToCheck);
			if (var == true) {
				return list[index];
			}
		}
		return count;
	}

	private int[] getAvalMoves(boolean doCheckCorners, boolean doCheckCenter, boolean doCheckSides) {
		int[] avalMoves;
		int[] moves = new int[9];
		int count = 0;

		if (doCheckCorners == true) {
			if ((getBoardState("corner", 0)) == 0) {
				moves[count] = 0;
				count++;
			}
			if ((getBoardState("corner", 1)) == 0) {
				moves[count] = 2;
				count++;

			}
			if ((getBoardState("corner", 2)) == 0) {
				moves[count] = 6;
				count++;

			}
			if ((getBoardState("corner", 3)) == 0) {
				moves[count] = 8;
				count++;

			}
		}

		if (doCheckCenter == true) {
			if ((getBoardState("center", 0)) == 0) {
				moves[count] = 4;
				count++;

			}
		}

		if (doCheckSides == true) {
			if ((getBoardState("side", 0)) == 0) {
				moves[count] = 3;
				count++;

			}
			if ((getBoardState("side", 1)) == 0) {
				moves[count] = 1;
				count++;

			}
			if ((getBoardState("side", 2)) == 0) {
				moves[count] = 5;
				count++;

			}
			if ((getBoardState("side", 3)) == 0) {
				moves[count] = 7;
				count++;

			}
		}
		avalMoves = new int[count];
		for (int index = 0; index < avalMoves.length; index++) {
			avalMoves[index] = moves[index];
		}
		System.out.println("done");
		return avalMoves;
	}

	private int getBoardState(String checkFor, int boardLocation) {
		int reply = 0;
		loop: switch (checkFor) {
		case ("corner"):// Are the corners taken
			switch (boardLocation) {
			case (0):
				reply = gameBoard[0];
				break loop;
			case (1):
				reply = gameBoard[2];
				break loop;
			case (2):
				reply = gameBoard[6];
				break loop;
			case (3):
				reply = gameBoard[8];
				break loop;
			}
		case ("center"):// Is the center taken
			reply = gameBoard[4];
			break loop;
		case ("side"):// Are the sides taken
			switch (boardLocation) {
			case (0):
				reply = gameBoard[3];
				break loop;
			case (1):
				reply = gameBoard[1];
				break loop;
			case (2):
				reply = gameBoard[5];
				break loop;
			case (3):
				reply = gameBoard[7];
				break loop;
			}
		}

		return reply;
	}

}
