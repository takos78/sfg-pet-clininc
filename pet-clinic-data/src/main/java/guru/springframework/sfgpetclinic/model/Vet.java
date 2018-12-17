package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vet extends Person {

	Set<Speciality> specialities = new HashSet<>();
	
}
