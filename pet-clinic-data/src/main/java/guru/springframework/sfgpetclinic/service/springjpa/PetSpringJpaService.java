package guru.springframework.sfgpetclinic.service.springjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repository.PetRepository;
import guru.springframework.sfgpetclinic.service.PetService;

@Service
@Profile("springjpa")
public class PetSpringJpaService implements PetService {

	private final PetRepository petRepository;
	
	
	public PetSpringJpaService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	
	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet entity) {
		return petRepository.save(entity);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public void delete(Pet entity) {
		petRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

	@Override
	public Set<Pet> savePets(Set<Pet> pets) {
		Set<Pet> savedPets = new HashSet<>();
		pets.stream().forEach(pet -> {
			Pet savedPet = this.save(pet);
			savedPets.add(savedPet);
		});
		return savedPets;
	}


}
