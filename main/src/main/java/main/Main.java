package main;

import controller.Controller;
import controller.Game;
import model.Model;
import model.entities.creatures.Creature;
import model.entities.creatures.Player;
import view.View;


/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 */
	public static void main(final String[] args) {
		
		final Model model = new Model();
		
		
		Game gLoop = new Game("Tile Game ! GRP2", 1024, 768);
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		controller.control();
		gLoop.start();
		
	}
}


