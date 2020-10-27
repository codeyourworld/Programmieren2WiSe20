package view;


/**
 * 
 * The ITickableListener listens to timer ticks. This interface can be used to notify objects at each timer tick.
 * 
 * @author Stephi
 * @version 1.1
 *
 */
public interface ITickableListener {
	
	/**
	 * The tick method could be used to notify objects at each timer tick.
	 * 
	 * @param elapsedTime time that elapsed
	 */
	public void tick(long elapsedTime);

}
