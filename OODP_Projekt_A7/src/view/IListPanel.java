/**
 * Interface f�r paneler som ska lista data. De mest grundl�ggande metoderna ligger inuti denna view.
 * I och med att man listar n�got s� ska �ven metoder som visa, skapa, ta bort, m.m finnas tillg�ngliga f�r anv�ndaren.
 */

package view;

public interface IListPanel<T> {
	public void show(int id);
	public void create();
	public void sort();
	public void delete(int id);
}