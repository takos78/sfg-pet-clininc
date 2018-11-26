package guru.springframework.sfgpetclinic.service.map;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.service.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService {

}
