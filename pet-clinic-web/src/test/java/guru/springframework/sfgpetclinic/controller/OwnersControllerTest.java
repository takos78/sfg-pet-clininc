package guru.springframework.sfgpetclinic.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;

@RunWith(SpringRunner.class)
@WebMvcTest(OwnersController.class)
public class OwnersControllerTest {

	@Autowired
    private MockMvc ownerController; // Class under test
	
	@MockBean
    private OwnerService ownerService;
	
	Set<Owner> owners;
	
	@Before
	public void setUp() {
		owners = new HashSet<Owner>();
		Owner owner = new Owner();
		owner.setId(1L);
		owner.setFirstName("Hoppa");
		
		owners.add(owner);
		
		owner = new Owner();
		owner.setId(2L);
		owner.setFirstName("Bokor");
		
		owners.add(owner);
		
		when(ownerService.findAll()).thenReturn(owners);
	}
	
	@Test
	public void givenOwners_whenGetAllOwners_thenReturnAllOwners() throws Exception {
		ownerController.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/index.html"))
			.andExpect(model().attribute("owners", hasSize(2)));
	}
	
	@Test
	public void givenOwners_whenFindOwners_thenReturnNotImplemented() throws Exception {
		ownerController.perform(get("/owners/find"))
			.andExpect(status().isOk())
			.andExpect(view().name("notimplemented"));
		
		verifyZeroInteractions(ownerService);
	}
}
