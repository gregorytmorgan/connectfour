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
public class Connectfour {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int move;
		boolean done = false;

		ConsoleUI ui = new ConsoleUI();

		GameData data = ui.gameProlog();

		do {
			ui.draw(data);

			move = ui.getMove();

			if (move == 0) {
				done = true;
			} else if (move == 0) {

			} else {
				int retval = data.playMove(move);
				if (retval == 0) {
					ui.message("Invalid move\n");
				}
			}

//System.out.print("Debug - move:" + move + "\n");

		} while (!done);

		ui.gameEpilog(data);
	}

}
