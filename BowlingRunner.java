/*
 * Bowlarama by Brian Wilkinson
 * AP Summer Institute Goucher College
 * June 18, 2019 - Program works, but only with a single line file
 * June 19, 2019 - Now can read an entire file of data line by line.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class BowlingRunner {

	public static void main(String[] args) throws IOException {
		
		Scanner inFile = new Scanner(new File("input.txt"));
		
		while (inFile.hasNextLine()) {
			
			// Using a second scanner to get a single line of the file.
			Scanner lineScanner = new Scanner(inFile.nextLine());
			
		
			ArrayList<Integer> rolls = new ArrayList<Integer>();
		
			while (lineScanner.hasNextInt()) {
				rolls.add(lineScanner.nextInt());
			}
		
			Game game = new Game();
		
			// counter to keep track of each ball rolled
			// is the index of each position in the rolls ArrayList
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
		inFile.close();
	}


}
