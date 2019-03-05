package guru.springframework.sfgpetclinic.service.springjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repository.VetRepository;
import guru.springframework.sfgpetclinic.service.VetService;

@Service
@Profile("springjpa")
public class VetSpringJpaService implements VetService {
	
	private final VetRepository vetRepository;

	
	@Autowired
	public VetSpringJpaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	
	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet entity) {
		return vetRepository.save(entity);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public void delete(Vet entity) {
		vetRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}



}
