package guru.springframework.sfgpetclinic.service.springjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repository.SpecialtyRepository;
import guru.springframework.sfgpetclinic.service.SpecialityService;


@Service
@Profile("springjpa")
public class SpecialtySpringJpaService implements SpecialityService {

	private final SpecialtyRepository specialtyRepository;

	
	public SpecialtySpringJpaService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	
	@Override
	public Speciality findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality entity) {
		return specialtyRepository.save(entity);
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> result = new HashSet<>();
		specialtyRepository .findAll().forEach(result::add);
		return result;
	}

	@Override
	public void delete(Speciality entity) {
		specialtyRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}

}
