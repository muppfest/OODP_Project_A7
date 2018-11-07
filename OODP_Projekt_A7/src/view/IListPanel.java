/**
 * Interface för paneler som ska lista data. De mest grundläggande metoderna ligger inuti denna view.
 * I och med att man listar något så ska även metoder som visa, skapa, ta bort, m.m finnas tillgängliga för användaren.
 */

package view;

public interface IListPanel<T> {
	public void show(int id);
	public void create();
	public void sort();
	public void delete(int id);
}