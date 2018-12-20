package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class PetType extends BaseEntity {

	@Column
	private String name;
	
}
