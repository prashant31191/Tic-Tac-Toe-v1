package tictactoe.aicode;

import java.util.Scanner;

public class HumanLogic {
	Scanner in = new Scanner(System.in);

	public int doMove() {
		//boolean inputValid = false;
		//int input = 100;
		//while(inputValid == false){
			//input = getInput();
			//if(input != 0 || input != 1 || input != 2 || input != 3 || input != 4 || input != 5 || input != 6 || input != 7 || input != 8){
				//inputValid = false;
			//}else{
				//inputValid = true;
			//}
		//}
		return getInput();
	}
	private int getInput(){
		int input = 0;
		System.out.println("Enter the slot you wish to change");
		System.out.println("Slot 0 is the top left, Slot 8 is the bottom right");
		input = in.nextInt();
		return input;
	}
}
