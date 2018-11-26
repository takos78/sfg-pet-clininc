package guru.springframework.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	
	private final VetService vetService;
	
	private final PetTypeService petTypeService;
	
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cat");
		petTypeService.save(cat);
		
		System.out.println("Loaded PetTypes ---");
		
		Owner owner1 = new Owner();
		owner1.setFirstName("John");
		owner1.setLastName("Charmac");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("James");
		owner2.setLastName("Wire");
		
		ownerService.save(owner2);

		System.out.println("Loaded Owners ---");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Haho");
		vet2.setLastName("Jassa");
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets ---");
	}

}
