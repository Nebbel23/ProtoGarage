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
	public CarController(CarService service)
	{
		this.service = service;
	}
	
	//region Get
	@GetMapping
	public List<Car> getAllCars()
	{
		return service.getAllCars();
	}
	
	//todo .get()
	//todo public maken
	@GetMapping("/{id}")
	public Car getCarById(@PathVariable("id") Long id)
	{
		return service.getCarById(id);
	}
	//endregion
	
	//region Post
	@PostMapping("/")
	public Car addCar(@RequestBody Car car)
	{
		return service.addCar(car);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	public Car editCar(@RequestBody Car car, @PathVariable("id") Long id)
	{
		return service.editCar(id, car);
	}
	//endregion
	
	//region Delete
	@DeleteMapping
	public void deleteCar(Long id)
	{
		service.deleteCar(id);
	}
	//endregion
}