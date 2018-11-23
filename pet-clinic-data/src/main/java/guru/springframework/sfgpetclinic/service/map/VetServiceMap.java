package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	
	@Override
	public Vet save(Vet entity) {
		return super.save(entity.getId(), entity);
	}

}
