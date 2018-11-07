/**
 * Interface för alla paneler som visar data i detalj. 
 * Förtutom att visa viss data i detalj kan även datat uppdateras direkt i visa-panelen.
 */

package view;

public interface IShowPanel<T> {	
	public void edit();
	public void save();
	public void enableFields();
	public void disableFields();
	public void cancel();
	public void refresh();
}