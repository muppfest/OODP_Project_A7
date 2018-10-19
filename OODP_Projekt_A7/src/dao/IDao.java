package dao;

import java.util.List;

public interface IDao<T> {
	T getById(int id);
	List<T> getAll();
	void insert(T object);
	void delete(int id);
	void update(T object);
}