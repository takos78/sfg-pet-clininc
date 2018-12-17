package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class Speciality extends BaseEntity {

	private String description;
	
}
