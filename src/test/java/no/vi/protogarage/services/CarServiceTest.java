package no.vi.protogarage.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import no.vi.protogarage.message.ResponseMessage;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.FileDB;
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.repositories.CarRepository;
import no.vi.protogarage.repositories.FileDBRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CarService.class})
@ExtendWith(SpringExtension.class)
class CarServiceTest
{
	@MockBean
	private CarRepository carRepository;
	
	@Autowired
	private CarService carService;
	
	@MockBean
	private FileDBRepository fileDBRepository;
	
	/**
	 * Method under test: {@link CarService#getAllCars()}
	 */
	@Test
	void testGetAllCars()
	{
		ArrayList<Car> carList = new ArrayList<>();
		when(this.carRepository.findAll()).thenReturn(carList);
		List<Car> actualAllCars = this.carService.getAllCars();
		assertSame(carList, actualAllCars);
		assertTrue(actualAllCars.isEmpty());
		verify(this.carRepository).findAll();
	}
	
	/**
	 * Method under test: {@link CarService#getCarById(Long)}
	 */
	@Test
	void testGetCarById()
	{
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		Optional<Car> ofResult = Optional.of(car);
		when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
		assertSame(car, this.carService.getCarById(123L));
		verify(this.carRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CarService#getPapers(Long)}
	 */
	@Test
	void testGetPapers() throws UnsupportedEncodingException
	{
		FileDB fileDB = new FileDB();
		fileDB.setData("AAAAAAAA".getBytes("UTF-8"));
		fileDB.setName("Name");
		fileDB.setType("Type");
		Optional<FileDB> ofResult = Optional.of(fileDB);
		when(this.fileDBRepository.findById((String) any())).thenReturn(ofResult);
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		Optional<Car> ofResult1 = Optional.of(car);
		when(this.carRepository.findById((Long) any())).thenReturn(ofResult1);
		ResponseEntity<byte[]> actualPapers = this.carService.getPapers(123L);
		assertEquals(8, actualPapers.getBody().length);
		assertEquals(HttpStatus.OK, actualPapers.getStatusCode());
		assertEquals(1, actualPapers.getHeaders().size());
		verify(this.fileDBRepository).findById((String) any());
		verify(this.carRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CarService#addCar(Car)}
	 */
	@Test
	void testAddCar()
	{
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		when(this.carRepository.save((Car) any())).thenReturn(car);
		
		Car car1 = new Car();
		car1.setAtShop(true);
		car1.setExecuteStatus(true);
		car1.setPapersId("42");
		car1.setPayed(true);
		car1.setRegistration("Registration");
		car1.setReparations(new ArrayList<>());
		assertSame(car, this.carService.addCar(car1));
		verify(this.carRepository).save((Car) any());
	}
	
	/**
	 * Method under test: {@link CarService#addReparationToCar(Long, Reparation)}
	 */
	@Test
	void testAddReparationToCar()
	{
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		Optional<Car> ofResult = Optional.of(car);
		
		Car car1 = new Car();
		car1.setAtShop(true);
		car1.setExecuteStatus(true);
		car1.setPapersId("42");
		car1.setPayed(true);
		car1.setRegistration("Registration");
		car1.setReparations(new ArrayList<>());
		when(this.carRepository.save((Car) any())).thenReturn(car1);
		when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		assertSame(car1, this.carService.addReparationToCar(123L, reparation));
		verify(this.carRepository).save((Car) any());
		verify(this.carRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CarService#setExecuteStatus(long, boolean)}
	 */
	@Test
	void testSetExecuteStatus()
	{
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		Optional<Car> ofResult = Optional.of(car);
		
		Car car1 = new Car();
		car1.setAtShop(true);
		car1.setExecuteStatus(true);
		car1.setPapersId("42");
		car1.setPayed(true);
		car1.setRegistration("Registration");
		car1.setReparations(new ArrayList<>());
		when(this.carRepository.save((Car) any())).thenReturn(car1);
		when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
		assertSame(car1, this.carService.setExecuteStatus(123L, true));
		verify(this.carRepository).save((Car) any());
		verify(this.carRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CarService#uploadPapers(Long, org.springframework.web.multipart.MultipartFile)}
	 */
	@Test
	void testUploadPapers() throws UnsupportedEncodingException
	{
		FileDB fileDB = new FileDB();
		fileDB.setData("AAAAAAAA".getBytes("UTF-8"));
		fileDB.setName("Name");
		fileDB.setType("Type");
		when(this.fileDBRepository.save((FileDB) any())).thenReturn(fileDB);
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		Optional<Car> ofResult = Optional.of(car);
		
		Car car1 = new Car();
		car1.setAtShop(true);
		car1.setExecuteStatus(true);
		car1.setPapersId("42");
		car1.setPayed(true);
		car1.setRegistration("Registration");
		car1.setReparations(new ArrayList<>());
		when(this.carRepository.save((Car) any())).thenReturn(car1);
		when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
		ResponseEntity<ResponseMessage> actualUploadPapersResult = this.carService.uploadPapers(123L,
				new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8")));
		assertTrue(actualUploadPapersResult.hasBody());
		assertTrue(actualUploadPapersResult.getHeaders().isEmpty());
		assertEquals(HttpStatus.OK, actualUploadPapersResult.getStatusCode());
		assertEquals("Uploaded the file successfully: ", actualUploadPapersResult.getBody().getMessage());
		verify(this.fileDBRepository).save((FileDB) any());
		verify(this.carRepository).save((Car) any());
		verify(this.carRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CarService#editCar(Long, Car)}
	 */
	@Test
	void testEditCar()
	{
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		
		Car car1 = new Car();
		car1.setAtShop(true);
		car1.setExecuteStatus(true);
		car1.setPapersId("42");
		car1.setPayed(true);
		car1.setRegistration("Registration");
		car1.setReparations(new ArrayList<>());
		Optional<Car> ofResult = Optional.of(car1);
		when(this.carRepository.save((Car) any())).thenReturn(car);
		when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
		
		Car car2 = new Car();
		car2.setAtShop(true);
		car2.setExecuteStatus(true);
		car2.setPapersId("42");
		car2.setPayed(true);
		car2.setRegistration("Registration");
		car2.setReparations(new ArrayList<>());
		assertSame(car, this.carService.editCar(123L, car2));
		verify(this.carRepository).save((Car) any());
		verify(this.carRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CarService#editCar(Long, Car)}
	 */
	@Test
	void testEditCar2()
	{
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		when(this.carRepository.save((Car) any())).thenReturn(car);
		when(this.carRepository.findById((Long) any())).thenReturn(Optional.empty());
		
		Car car1 = new Car();
		car1.setAtShop(true);
		car1.setExecuteStatus(true);
		car1.setPapersId("42");
		car1.setPayed(true);
		car1.setRegistration("Registration");
		car1.setReparations(new ArrayList<>());
		assertSame(car, this.carService.editCar(123L, car1));
		verify(this.carRepository).save((Car) any());
		verify(this.carRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CarService#deleteCar(Long)}
	 */
	@Test
	void testDeleteCar()
	{
		doNothing().when(this.carRepository).deleteById((Long) any());
		this.carService.deleteCar(123L);
		verify(this.carRepository).deleteById((Long) any());
		assertTrue(this.carService.getAllCars().isEmpty());
	}
}