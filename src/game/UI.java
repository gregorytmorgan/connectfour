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
public abstract class UI {

	int width;

	int height;

	abstract GameData gameProlog();

	abstract void draw(GameData data);

	abstract int getMove();

	abstract void message(String msg);

	abstract void gameEpilog(GameData data);
}

// end file
