package view;

public interface IView<T> {
	public void list();
	public void create();
	public void show(int id);
	public void insert(T object);
	public void update(T object);
	public void delete(int id);
}
