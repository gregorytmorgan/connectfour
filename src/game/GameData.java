/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author gmorgan
 */
public class GameData {

	protected int[][] data;

	protected int turn = 0;

	protected int winLength;

	protected String[] playerNames = new String[2];

	/**
	 *
	 * @param nColumns
	 * @param nCells
	 * @param length
	 * @param player1Name
	 * @param player2Name
	 */
	public GameData(int nColumns, int nCells, int length, String player1Name, String player2Name) {

		// do some error checking
		// w x h
		// length < w, h
		// player names

		winLength = length;

		playerNames[0] = player1Name;
		playerNames[1] = player2Name;

		data = new int[nColumns][nCells];

		// initialize the game board
		for (int i = 0; i < nColumns; i++) {
			for (int j = 0; j < nCells; j++) {
				data[i][j] = -1;
			}
		}
	}

	/**
	 * Get the value of a given cell.
	 *
	 * @param column
	 * @param position
	 * @return
	 */
	int getCell(int column, int position) {
		return data[column][position];
	}

	/**
	 * Return the position of the cell where the token was placed. 0 if the row was full
	 * or the move was invalid.
	 *
	 * @param move
	 * @return
	 */
	int playMove(int move) {

		turn++;

		if (move < 1 || move > getBoardWidth()) {
			return 0;
		}

		int position = getColumnTop(--move); // column data is zero based, so adjust user input by -1

		if (position == -1) {
			return 0;
		}

		if (getCell(move, position) != -1) {
			return 0;
		}

		data[move][position] = turn % 2; // player number = turn % 2

		return position + 1;
	}

	/**
	 * Return the first available cell in a column (Zero based). Returns -1 if
	 * the column is full
	 *
	 * @param column
	 * @return
	 */
	protected int getColumnTop(int column) {
		for (int i = 0; i < getBoardHeight(); i++) {
			if (data[column][i] == -1) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Given a the player id, return the players name
	 *
	 * @param playerId
	 * @return
	 */
	String getPlayerName(int playerId) {
		return playerNames[playerId];
	}

	/**
	 * Set a players name
	 *
	 * @param playerId
	 * @param playerName
	 */
	void setPlayerName(int playerId, String playerName) {
		playerNames[playerId] = playerName;
	}

	/**
	 * Get the current players name.
	 * @return
	 */
	String getCurrentPlayer() {
		return playerNames[turn % 2];
	}

	/**
	 * Get the board width
	 *
	 * @return
	 */
	int getBoardWidth() {
		return data.length;
	}

	/**
	 * Get the board height.
	 * @return
	 */
	int getBoardHeight() {
		return data[0].length;
	}

	/**
	 * Get the user scores.  
	 *
	 * @return
	 */
	int[] getScores() {
		int[] scores = {0, 0};

		// calc scores for each user

		return scores;
	}
}

// end file