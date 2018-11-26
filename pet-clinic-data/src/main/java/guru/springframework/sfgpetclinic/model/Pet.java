package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(exclude={"owner"})
public class Pet extends BaseEntity {

	private PetType petType;
	
	private String name;
	
	private Owner owner;
	
	private LocalDate birthDay;
	
}
