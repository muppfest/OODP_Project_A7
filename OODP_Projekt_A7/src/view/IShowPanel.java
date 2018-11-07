/**
 * Interface f�r alla paneler som visar data i detalj. 
 * F�rtutom att visa viss data i detalj kan �ven datat uppdateras direkt i visa-panelen.
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