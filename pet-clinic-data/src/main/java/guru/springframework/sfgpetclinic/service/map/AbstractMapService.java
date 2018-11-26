package guru.springframework.sfgpetclinic.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;

public class AbstractMapService<T extends BaseEntity> {
	
	protected Map<Long, T> map = new HashMap<>();
	
	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	public T findById(Long id) {
		return map.get(id);
	}
	
	public T save(T object) {
		if (object == null) throw new RuntimeException("Object cannot be null.");

		Long id = object.getId();
		if (id == null) {
			id = getNextId();
		}
		
		object.setId(id);
		map.put(object.getId(), object);
		return object;
	}
	
	private Long getNextId() {
		Long nextId = map.keySet().size() > 0 ? Collections.max(map.keySet()) + 1 : 1; 
		return nextId;
	}

	public void deleteById(Long id) {
		map.remove(id);
	}
	
	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
}
