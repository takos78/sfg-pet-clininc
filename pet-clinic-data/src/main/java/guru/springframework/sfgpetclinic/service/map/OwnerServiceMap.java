package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
	
	@Override
	public Owner save(Owner entity) {
		return super.save(entity.getId(), entity);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return map.values().stream()
						.filter(owner -> owner.getLastName().equals(lastName))
						.findAny()
						.orElse(null);
	}

}
