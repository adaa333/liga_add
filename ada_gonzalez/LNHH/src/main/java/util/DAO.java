package util;

import java.util.List;

public interface DAO <T>{
	public void insert(T entity);
	public void delete(int id);
	public List<T> selectAll();
	public T select(int id);
	
}
