/**
 * Ett interface alla huvudvyer för alla views använder sig av. 
 * De metoder som implementeras är de mest grundläggande man vill ha möjlighet att använda sig av i GUI:t.
 * Tanken är att dessa metoder i sin tur ska egna mer detaljerade metoder i form av list, show osv.
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
