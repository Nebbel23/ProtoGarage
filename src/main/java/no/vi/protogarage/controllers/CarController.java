package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/car")
public class CarController
{
	
	private final CarService service;
	
	@Autowired
	private CarController(CarService service)
	{
		this.service = service;
	}
	
	//region Get
	@GetMapping
	private List<Car> getAllCars()
	{
		return service.getAllCars();
	}
	
	@GetMapping("/{id}")
	private Car getCarById(@PathVariable("id") Long id)
	{
		return service.getCarById(id);
	}
	//endregion
	
	//region Post
	@PostMapping("/")
	private Car addCar(@RequestBody Car car)
	{
		return service.addCar(car);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	private Car editCar(@RequestBody Car car, @PathVariable("id") Long id)
	{
		return service.editCar(id, car);
	}
	//endregion
	
	//region Delete
	@DeleteMapping
	private void deleteCar(Long id)
	{
		service.deleteCar(id);
	}
	//endregion
}