package guru.springframework.sfgpetclinic.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.service.VisitService;

@Service
@Profile({"default", "data-map"})
public class VisitMapService extends AbstractMapService<Visit> implements VisitService {

	@Override
	public Visit save(Visit visit) {
		if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
				|| visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		
		return super.save(visit);
	}
	
	
}
