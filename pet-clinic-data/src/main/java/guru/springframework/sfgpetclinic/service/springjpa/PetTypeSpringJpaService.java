package guru.springframework.sfgpetclinic.service.springjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repository.PetTypeRepository;
import guru.springframework.sfgpetclinic.service.PetTypeService;

public class PetTypeSpringJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;
	

	@Autowired
	public PetTypeSpringJpaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}
	
	
	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType entity) {
		return petTypeRepository.save(entity);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>(); 
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public void delete(PetType entity) {
		petTypeRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}


}
