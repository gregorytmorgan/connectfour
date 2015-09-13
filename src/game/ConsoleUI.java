/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gmorgan
 */
public class ConsoleUI extends UI {

	/**
	 * Game instructions, setup, ...
	 *
	 * @return
	 */
	@Override
	GameData gameProlog() {
		System.out.print("Player 1 is '0', Player 2 is 'X'\n");
		System.out.print("To play your turn, enter a column number.");
		return new GameData(8, 6, 4, "player1", "player2");	// get game setup from user
	}

	/**
	 * Draw the header displayed on top of the board.
	 *
	 * @param data
	 */
	void drawHeader(GameData data) {
		System.out.print("Turn: " + data.getCurrentPlayer() + "\n");
	}

	/**
	 * Draw the entire game screen.
	 *
	 * Called every turn.
	 *
	 * @param data
	 */
	@Override
	void draw(GameData data) {
		drawHeader(data);
		drawBoard(data);
	}

	/**
	 * Draw the game board.
	 *
	 * @param data
	 */
	protected void drawBoard (GameData data) {

		// draw top to bottom
		for (int i = data.getBoardHeight(); i >= 1 ; i--) {
			drawRow(i, data);
		}

		// draw the board bottom
		System.out.print("+");
		for (int j = 0; j < data.getBoardWidth(); j++) {
			System.out.print("---+");
		}
		System.out.print("\n");
	}

	/**
	 * Draw an individual game board row.
	 *
	 * @param position
	 * @param data
	 */
	protected void drawRow (int position, GameData data) {
		String piece;
		System.out.print("|");
		for (int col = 0; col < data.getBoardWidth(); col++) {
			switch(data.getCell(col, position - 1)) { // columns are 0 based so - 1
				case 0:
					piece= "0";
					break;
				case 1:
					piece = "X";
					break;
				default:
					piece = " ";
			}

			System.out.print(" " + piece + " |");
		}
		System.out.print("\n");
	}

	/**
	 * Prompt the user for a move.
	 *
	 * Returns the column (integer) selected by the player on success, 0 to quite,
	 * -1 on error, -2 to save.
	 * @return
	 */
	@Override
	int getMove() {
		String input;
		int move;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter your move:");

		try {
			input = in.readLine();
		} catch (IOException ex) {
			Logger.getLogger(Connectfour.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}

		try {
			move = Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			System.out.print("Invalid move");
			return -1;
		}

		return move;
	}

	/**
	 * Game teardown
	 *
	 * @param data
	 */
	@Override
	void gameEpilog(GameData data) {
		int[] scores = data.getScores();

		System.out.print("Game over\n");

		if (scores[0] > scores[1]) {
			System.out.print(data.getPlayerName(0) + " wins with a score of " + scores[0] + ".\n");
		} else if (scores[0] < scores[1]) {
			System.out.print(data.getPlayerName(0) + " wins with a score of " + scores[1] + ".\n");
		} else {
			System.out.print(data.getPlayerName(0) + " and " + data.getPlayerName(1) + " tied with a score of " + scores[0] + ".\n");
		}
	}

	/**
	 * Display an arbitrary message to the user.
	 *
	 * @param msg
	 */
	@Override
	void message(String msg) {
		System.out.print(msg);
	}

}

// end file