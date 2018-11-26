package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

	private final PetService petService;
	
		
	public OwnerServiceMap(PetService petService) {
		this.petService = petService;
	}

	@Override
	public Owner save(Owner owner) {
		if (owner == null) return null;
		
		Set<Pet> pets = petService.savePets(owner.getPets());
		owner.setPets(pets);
		
		Owner savedOwner = super.save(owner);
		
		// Reverse reference
		updatePetsOwner(pets, savedOwner);
		pets = petService.savePets(pets);
		
		return savedOwner;
	}
			
	private void updatePetsOwner(Set<Pet> pets, Owner owner) {
		if (pets == null) return;
		pets.forEach(pet -> pet.setOwner(owner));
	}

	@Override
	public Owner findByLastName(String lastName) {
		return map.values().stream()
						.filter(owner -> owner.getLastName().equals(lastName))
						.findAny()
						.orElse(null);
	}

}
