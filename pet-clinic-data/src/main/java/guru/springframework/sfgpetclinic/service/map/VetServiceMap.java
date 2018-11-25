package guru.springframework.sfgpetclinic.service.map;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {
	
	@Override
	public Vet save(Vet entity) {
		return super.save(entity);
	}

}
