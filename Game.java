/*
 * Bowlarama by Brian Wilkinson
 * AP Summer Institute Goucher College
 * June 18, 2019
 * 
 * Main Class for a bowling game. Simulates spares, strikes, and open frames.
 */
public class Game {
	
	int[] scores;
	int frame;
	
	public Game() {
		scores = new int[10];
		frame = 0;
	}
	
	public void rolledAStrike(int ballOne, int ballTwo) {
		updateScore(10 + ballOne + ballTwo);
	}
	
	public void rolledASpare(int ballOne) {
		updateScore(10 + ballOne);
	}
	
	public void rolledOpen(int ballOne, int ballTwo) {
		updateScore(ballOne + ballTwo);
	}
	
	private void updateScore(int score) {
		if (frame == 0) {
			scores[frame] = score;
		} else {
			scores[frame] = scores[frame - 1] + score;
		}
		
		updateFrame();
	}
	
	private void updateFrame() {
		frame++;
	}
	
	public int currentFrame() {
		return frame;
	}
	
	public String toString() {
		String str = "";
		for (int i=0; i<scores.length; i++) {
			str += scores[i] + " ";
		}
		return str;
	}

}
