package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pet extends BaseEntity {

	private PetType prtType;
	
	private Owner owner;
	
	private LocalDate birthDay;
	
}
