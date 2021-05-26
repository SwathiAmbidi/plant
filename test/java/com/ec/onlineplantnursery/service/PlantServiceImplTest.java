package com.ec.onlineplantnursery.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.PlantRepository;
import com.ec.onlineplantnursery.plant.service.IPlantServiceImpl;

import java.util.Optional;

@SpringBootTest
public class PlantServiceImplTest {

	//@Mock
	PlantRepository repo;
	private static IPlantServiceImpl service;//
	private static AutoCloseable ac;
	
	
	//private TestEntityManager em;
	
	@BeforeEach
	public void doinit() {
		repo = mock(PlantRepository.class);
		service = new IPlantServiceImpl(repo);
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd() throws Exception{
		ac.close();
	}
	
	@Test
	void testSavePlant() {
		Plant input = new Plant(1,10,"6 inches","Ice Plant","Throughout year","culinary","Easy to grow","20-35 C","Succulent","This is a delightful,easy to grow plant",10,150.0);
		
		Plant savedProduct = new Plant(1,10,"6 inches","Ice Plant","Throughout year","culinary","Easy to grow","20-35 C","Succulent","This is a delightful,easy to grow plant",10,150.0);
		
	
		when(repo.save(input)).thenReturn(savedProduct);
		service.addPlant(input);
		verify(repo).save(input);
		
	}
	
	@Test
	@DisplayName("test- get all Plants")
	void testGetAllPlants() {
		
		List<Plant> pList = mock(List.class);
		when(repo.findAll()).thenReturn(pList);
		service.viewAllPlants();
		verify(repo).findAll();
		
	}
	
	@Test
	void deletePlant() {
		Plant input = new Plant(1,10,"6 inches","Ice Plant","Throughout year","culinary","Easy to grow","20-35 C","Succulent","This is a delightful,easy to grow plant",10,150.0);
		repo.save(input);
		service.deletePlant(input);
		
		verify(repo).delete(input);
	}
	
	@Test
	void testViewPlantByName() {
		Plant p = mock(Plant.class);
		when(repo.viewPlant("Ice Plant")).thenReturn(p);
		service.viewPlant("Ice Plant");
		verify(repo).viewPlant("Ice Plant");
	}
	@Test
	void testViewPlantByTypeOfPlant() {
		List<Plant> p = mock(List.class);
		when(repo.viewAllPlants("Air Plant")).thenReturn(p);
		service.viewAllPlants("Air Plant");
		verify(repo).viewAllPlants("Air Plant");
	}
	
	@Test
    void viewPlantById() {
		Optional<Plant> p = Optional.empty();
		when(repo.findById(1)).thenReturn(p);
		service.viewPlant(1);
		/*try{
			Plant output = service.viewPlant(1);
			verify(repo).findById(1);
			//assertEquals(expected,output);
		}
		catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}*/
		verify(repo).findById(1);
		
	}
	
	
}//end




