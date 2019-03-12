package guru.springframework.sfgpetclinic.service.springjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repository.VisitRepository;
import guru.springframework.sfgpetclinic.service.VisitService;

@Service
@Profile("springjpa")
public class VisitSpringJpaService implements VisitService {

	private final VisitRepository visitRepository;

	@Autowired
	public VisitSpringJpaService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}
	
	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit entity) {
		// TODO Remove
		System.out.println("####################");
		System.out.println("####################");
		System.out.println("####################");
		System.out.println("####################");
		System.out.println("####################");
		System.out.println("####################");
		return visitRepository.save(entity);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public void delete(Visit entity) {
		visitRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);		
	}


}
