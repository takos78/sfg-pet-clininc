package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.PetTypeService;

@Service
@Profile({"default", "data-map"})
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {

	private final PetTypeService petTypeService;


	public PetServiceMap(PetTypeService petTypeService) {
		this.petTypeService = petTypeService;
	}
	
	@Override
	public Set<Pet> savePets(Set<Pet> pets) {
		if (pets == null) return null;

		pets.forEach(pet -> {
			pet.setPetType(petTypeService.save(pet.getPetType()));
			super.save(pet);
		});


		return pets;
	}

}
