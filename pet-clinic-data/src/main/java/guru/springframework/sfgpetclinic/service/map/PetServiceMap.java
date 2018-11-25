package guru.springframework.sfgpetclinic.service.map;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {
	
	@Override
	public Pet save(Pet entity) {
		return super.save(entity);
	}

}
