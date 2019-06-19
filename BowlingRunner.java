/*
 * Bowlarama by Brian Wilkinson
 * AP Summer Institute Goucher College
 * June 18, 2019
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class BowlingRunner {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// This program is designed to work with input files of one line right now.
		Scanner inFile = new Scanner(new File("input.txt"));
		
		ArrayList<Integer> rolls = new ArrayList<Integer>();
		
		while (inFile.hasNextInt()) {
			rolls.add(inFile.nextInt());
		}
		inFile.close();
		
		Game game = new Game();
		
		int x = 0;
		
		while (x < rolls.size()) {
			int currentRoll = rolls.get(x);
			
			if (currentRoll == 10 && game.currentFrame() <=9) {
				game.rolledAStrike(rolls.get(x+1), rolls.get(x+2));
				if (game.currentFrame() == 10) {
					break;
				}
				x++;
			} else {
				x++;
				int nextRoll = rolls.get(x);
				if (currentRoll + nextRoll == 10 && game.currentFrame() <=9) {
					game.rolledASpare(rolls.get(x+1));
				} else {
					game.rolledOpen(currentRoll, nextRoll);
				}
				if (game.currentFrame() == 10) {
					break;
				}
				x++;
			}
			
		}
		System.out.println(game);
	}


}
