package jboss.as.bond.market.managed.ejb.dao;


public interface Dao<T> {
		
	public void save(T t);
	
	public T find(int id);
	
	public void remove(T t);
	
}
