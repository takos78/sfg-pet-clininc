package guru.springframework.sfgpetclinic.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.service.SpecialityService;

@Service
@Profile({"default", "data-map"})
public class SpecialityMapService extends AbstractMapService<Speciality> implements SpecialityService {

}
