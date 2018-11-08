package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pet {

	private PetType prtType;
	
	private Owner owner;
	
	private LocalDate birthDay;
	
}
