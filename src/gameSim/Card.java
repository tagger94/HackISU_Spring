package gameSim;

/**
 * 
 * @author Mike Onyszczak
 *
 *         There is not much here, but if you want to use a custom deck this
 *         interface is vital.
 *
 */
public interface Card {
	@Override
	boolean equals(Object other);

	@Override
	String toString();
}
