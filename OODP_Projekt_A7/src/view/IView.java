/**
 * Ett interface alla huvudvyer f�r alla views anv�nder sig av. 
 * De metoder som implementeras �r de mest grundl�ggande man vill ha m�jlighet att anv�nda sig av i GUI:t.
 * Tanken �r att dessa metoder i sin tur ska egna mer detaljerade metoder i form av list, show osv.
 */

package view;

public interface IView<T> {
	public void list();
	public void create();
	public void show(int id);
	public void insert(T object);
	public void update(T object);
	public void delete(int id);
}
