package view;

import java.awt.event.KeyEvent;

/**
 * The IKeyboardListener listens to the keyboard. This interface can be used to notify objects when a specific key is down.
 * 
 * @author Stephi
 * @version 1.1
 */
public interface IKeyboardListener {

	/**
	 * The method defines keys the object want to get notify when a user use them.
	 * 
	 * @return an array of specific keys the object want to get notified
	 * @see KeyEvent
	 */
	public int[] getKeys();

	/**
	 * This method could use to notify when a specific key is down
	 * 
	 * @param key which the user pressed
	 * @see KeyEvent
	 */
	public void keyDown(int key);

	
}
