package guru.springframework.sfgpetclinic.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "owner")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Owner extends Person {
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "telephone")
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Pet> pets;
	
}
