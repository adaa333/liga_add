package dao;

import java.util.List;

public interface DAO <T>{
	public void insert(T entity);
	public void delete(T entity);
	public List<T> selectAll();
	public T select(long id);
	public void update(T entity);
	
	//public boolean entityExists(T entity);
	
}
