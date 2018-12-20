package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Pet extends BaseEntity {

	@Column
	private String name;

	@Column
	private LocalDate birthDay;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Owner owner;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Visit> visits = new HashSet<>();
}
