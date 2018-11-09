package guru.springframework.sfgpetclinic.service;

import java.util.Set;

public interface CrudService<T, ID> {

	T findById(ID id);
	
	T save(T entity);
	
	Set<T> findAll();
	
	void delete(T entity);
	
	void deleteById(ID id);
	
}
