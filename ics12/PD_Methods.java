import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PD_Mexico {
	static Scanner sc = new Scanner(System.in); // Our standard in scanner object
	static Random rand = new Random(); // Our random object
	static boolean chosenAllowedRolls = false; // Holds whether we have chosen the allowed rolls amount yet or not

	static int[] lives = { 6, 6, 6 }; // The lives of all the player
	// The order list holds all the possible roll values in a descending order of
	// value
	static ArrayList<Integer> order = new ArrayList<Integer>(
			Arrays.asList(21, 66, 55, 44, 33, 22, 11, 65, 64, 63, 62, 61, 54, 53, 52, 51, 43, 42, 41, 32, 31));
	static int loser = 0;

	public static void main(String[] args) { // Main method
		// Print the greeting
		System.out.println("=====================\nWelcome to ((MEXICO))\n=====================");
		// Keep looping rounds until 2 players have no more lives left
		while ((lives[0] > 0 && lives[1] > 0) || (lives[0] > 0 && lives[2] > 0) || (lives[1] > 0 && lives[2] > 0)) {
			// Create an array for the roll results
			int[] rollResults = new int[3];
			// Set the current allowed rolls to 3
			int allowedRolls = 3;
			// Reset the chosen allowed rolls variable back to false
			chosenAllowedRolls = false;
			// Loop through each player
			for (int player = 0; player < 3; player++) {
				int realPlayer = player;
				if (player != -1) {
					// Get the starting player from the last loser
					realPlayer = (player + loser) % 3;
				}
				// If the player is dead, don't bother with them
				if (lives[realPlayer] < 1) {
					continue;
				}
				// Set the allowed rolls to the result of the processing function
				allowedRolls = getPlayerRolls(realPlayer, allowedRolls, rollResults);
				// Print their roll result and end their turn.
				System.out.printf("+> Player [%d] ended this round with a roll of %d!\n", realPlayer + 1,
						rollResults[realPlayer]);
				System.out.println();
			}
			// Calculate the loser of the round
			loser = calculateLoser(rollResults);
			// If it wasn't a tie...
			if (loser != -1) {
				// Decrease 1 life from the loser
				lives[loser]--;
				// Print who lost the round and how many lives they have left
				System.out.printf(
						"===> Player [%d] lost this round with a roll of %d. They now have %d live(s) left. <===\n\n\n",
						loser + 1, rollResults[loser], lives[loser]);
			}
		}
		// When there is only one alive player, print who it is
		printWinner();
	}

	// Calculates the roll result of a player in a given turn and also returns the
	// amount of allowed rolls for the next players if the player is player 1
	private static int getPlayerRolls(int player, int allowedRolls, int[] rollResults) {
		// Quit short circuit variable
		boolean quit = false;
		// Loop through the amount of allowed rolls
		for (int roll = 1; roll <= allowedRolls && !quit; roll++) {
			// Get a random roll result as if we rolled a dice
			int rollResult = getRandomRoll();
			// Print the roll
			System.out.printf("Player [%d] roll: %d. You have %d roll(s) left.\n", player + 1, rollResult,
					allowedRolls - roll);
			// If we haven't reached the limit of our rolls...
			if (roll != allowedRolls) {
				// Ask if the user wants to roll again
				System.out.print("Are you happy with this roll? 1 = YES/0 = NO ");
				// Get their choice
				int wantQuit = sc.nextInt();
				// If they want to quit...
				if (wantQuit == 1) {
					// Set their roll result to their current roll
					rollResults[player] = rollResult;
					// If the allowed rolls hasn't been chosen yet...
					if (!chosenAllowedRolls) {
						// Set the allowed rolls to the amount of rolls used
						chosenAllowedRolls = true;
						allowedRolls = roll;
					}
					quit = true;
				}
			} else {
				// If they run out of rolls just set their roll result to their current roll
				// without asking
				rollResults[player] = rollResult;
			}
		}
		// Sets allowed rolls to make sure the first player doesn't have any issues
		if (!chosenAllowedRolls && !quit) {
			chosenAllowedRolls = true;
			allowedRolls = 3;
		}
		// Return the amount of allowed rolls
		return allowedRolls;
	}

	// This function calculates the loser of the players in a given round from the
	// roll results
	private static int calculateLoser(int[] rollResults) {
		// Calculates the position in the list from the rolls, lower is a higher score
		int[] position = { order.indexOf(rollResults[0]), order.indexOf(rollResults[1]),
				order.indexOf(rollResults[2]) };
		// Set the loser to nothing for the start
		int loser = -1;
		// Get the losing score as the largest index in the order array
		int losingScore = Math.max(Math.max(position[0], position[1]), position[2]);
		// List of all the losers
		ArrayList<Integer> losers = new ArrayList<Integer>();
		// Loop through all the players
		for (int player = 0; player < 3; player++) {
			// If a player is a loser...
			if (position[player] == losingScore) {
				// Add them to the loser list
				losers.add(player);
			}
		}
		// If all 3 have the same roll...
		if (losers.size() == 3) {
			// It's a tie.
			System.out.println("This round was a draw!\n\n");
			// If 2 have the same score...
		} else if (losers.size() == 2) {
			// Choose a random one and set that as the loser.
			System.out.printf("Player [%d] and player [%d] have tied! The loser is decided by a random coinflip...\n",
					losers.get(0) + 1, losers.get(1) + 1);
			loser = losers.get(rand.nextInt(2));
			System.out.printf("Player [%d] lost the coinflip! Unlucky.\n", loser + 1);
		} else {
			// Otherwise only 1 is the loser so set that
			loser = losers.get(0);
		}
		// Return the loser to the caller
		return loser;
	}

	// This function prints the winner from the amount of lives the player has (only
	// one player should be alive)
	private static void printWinner() {
		// Loop through the players
		for (int player = 0; player < 3; player++) {
			// If the player is alive...
			if (lives[player] > 0) {
				// Print that they are the winner
				System.out.printf("-=-=-=>> Player [%d] is the winner!! Thanks for playing. <<=-=-=-", player + 1);
			}
		}
	}

	// This function calculates a random dice roll
	private static int getRandomRoll() {
		// Get the first roll (1-6)
		int dice1 = rand.nextInt(6) + 1;
		// Get the second roll (1-6)
		int dice2 = rand.nextInt(6) + 1;
		// Calculate the roll result from which roll is higher.
		return dice1 > dice2 ? dice1 * 10 + dice2 : dice2 * 10 + dice1;
	}
}