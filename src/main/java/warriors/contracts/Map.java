package warriors.contracts;

import warriors.engine.Case;

import java.util.List;

/**
 * This interface contains all data needed by the client about the game map
 */
public interface Map {

	/**
	 * @return The name of the map
	 */
	String getName();
	
	/**
	 * @return the number of case
	 */
	int getNumberOfCase();

	List<Case> getPlateau();
	Case getCasePlateau(int index);
}
