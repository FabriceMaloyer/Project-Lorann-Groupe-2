package controller;

import java.awt.event.KeyEvent;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import model.entities.creatures.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;
	
	//private Creature creature;
	
	private Player player;
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		
		this.player = player;
		
		player = new Player(Player.getX(),Player.getY(), Player.width, Player.height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Press Z, Q, S, D to move the character and Space to shoot");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	@SuppressWarnings({ "static-access" })
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Z:
				player.moveUp();
				break;
			case S:
				player.moveDown();
				break;	
			case Q:
				player.moveLeft();
				break;
			case D:
				player.moveRight();
				break;
		}
			/*case SPACE:
				if(player.spellmsg == 0 && player.SpellCaught == false){
					//player.spellmsg = 1;
				}
				if(player.spellmsg == 0 && player.SpellCaught == true){	
		
						//player.spellmsg = 1;
					}
				 if (player.spellmsg == 1){
					player.callSpell();
					player.spellmsg = 0;
				}*/
				
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
