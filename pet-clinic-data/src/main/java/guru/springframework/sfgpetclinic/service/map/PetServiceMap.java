package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
	
	@Override
	public Pet save(Pet entity) {
		return super.save(entity.getId(), entity);
	}

}
