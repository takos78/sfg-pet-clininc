package guru.springframework.sfgpetclinic.service.map;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		return map.values().stream()
						.filter(owner -> owner.getLastName().equals(lastName))
						.findAny()
						.orElse(null);
	}

}
