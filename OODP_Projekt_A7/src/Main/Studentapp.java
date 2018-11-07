/**
 * Mainklass för att köra applikationen.
 * OBS. Databaskopplingen måste vara korrekt för att applikationen ska fungera.
 */

package Main;
import java.sql.SQLException;

import view.View;

public class Studentapp {

	public static void main(String[] args) throws SQLException {
		View t = new View();
	} 
}
