package view;

public interface IListPanel<T> {
	public void show(int id);
	public void create();
	public void sort();
	public void delete(int id);
}