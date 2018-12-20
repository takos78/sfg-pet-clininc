package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
public class Speciality extends BaseEntity {

	@Column
	private String description;
	
}
