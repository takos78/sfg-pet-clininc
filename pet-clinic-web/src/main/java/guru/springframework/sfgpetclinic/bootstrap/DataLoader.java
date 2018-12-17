package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import guru.springframework.sfgpetclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	
	private final VetService vetService;
	
	private final SpecialityService specialityService;
	
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, SpecialityService specialityService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		int count = ownerService.findAll().size();
		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");

		PetType cat = new PetType();
		dog.setName("Cat");
		
		System.out.println("Loaded PetTypes ---");
				
		Pet drake = new Pet();
		drake.setName("Drake");
		drake.setPetType(dog);
		drake.setBirthDay(LocalDate.of(2018, Month.JUNE, 15));
		
		Pet johni = new Pet();
		johni.setName("Johni");
		johni.setPetType(cat);
		johni.setBirthDay(LocalDate.of(2017, 05, 11));

		Pet saffi = new Pet();
		saffi.setName("Saffi");
		saffi.setPetType(cat);
		saffi.setBirthDay(LocalDate.of(2017, 05, 12));
		
		Set<Pet> johnPets = new HashSet<>();
		johnPets.add(drake);
		johnPets.add(johni);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("John");
		owner1.setLastName("Charmac");
		owner1.setCity("Kimle-east");
		owner1.setAddress("Secret street 42");
		owner1.setTelephone("+36 77 4586789");
		owner1.setPets(johnPets);
				
		ownerService.save(owner1);
		
		Set<Pet> emmaPets = new HashSet<>();
		emmaPets.add(saffi);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Emma");
		owner2.setLastName("Flower");
		owner2.setCity("Kimle");
		owner2.setAddress("Secret street 52");
		owner2.setTelephone("+36 77 7786790");
		owner2.setPets(emmaPets);
		
		ownerService.save(owner2);

		System.out.println("Loaded Owners ---");
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");

		Speciality savedRadiology = specialityService.save(radiology);
		Speciality savedSurgery = specialityService.save(surgery);
		Speciality savedDentistry = specialityService.save(dentistry);
		System.out.println(savedDentistry);
		System.out.println("Loaded Specialties ---");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Haho");
		vet2.setLastName("Jassa");
		vet2.getSpecialities().add(savedSurgery);
		vet2.getSpecialities().add(savedDentistry);
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets ---");
	}

}
