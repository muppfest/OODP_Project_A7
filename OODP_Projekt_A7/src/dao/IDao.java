/**
 * DAO-interface gjord av Marcus Vretling Pistelli
 */

package dao;

import java.util.List;

public interface IDao<T> {
	T getById(int id);
	List<T> getAll();
	boolean insert(T object);
	boolean delete(int id);
	boolean update(T object);
}