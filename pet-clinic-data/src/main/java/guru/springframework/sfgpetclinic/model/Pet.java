package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends BaseEntity {

	private PetType petType;
	
	private Owner owner;
	
	private LocalDate birthDay;
	
}
