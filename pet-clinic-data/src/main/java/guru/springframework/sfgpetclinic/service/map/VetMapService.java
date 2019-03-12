package guru.springframework.sfgpetclinic.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import guru.springframework.sfgpetclinic.service.VetService;

@Service
@Profile({"default", "data-map"})
public class VetMapService extends AbstractMapService<Vet> implements VetService {

	private SpecialityService specialityService;
	

	public VetMapService(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}
	
	@Override
	public Vet save(Vet object) {
		Vet result = super.save(object);
		result.getSpecialities().forEach(specialty -> {
			specialityService.save(specialty);
		});
		
		return result;
	}

	
}
