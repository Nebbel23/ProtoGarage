package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Reparation;
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
	
	@GetMapping("/cancel/{id}")
	private Car setExecuteStatus(@PathVariable("id") Long id)
	{
		return service.setExecuteStatus(id, false);
	}
	//endregion
	
	//region Post
	@PostMapping
	private Car addCar(@RequestBody Car car)
	{
		return service.addCar(car);
	}
	
	@PostMapping("/{id}")
	private Car addReparationToCar(@PathVariable("id") Long id, @RequestBody Reparation reparation)
	{
		return service.addReparationToCar(id, reparation);
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
	@DeleteMapping("/{id}")
	private void deleteCar(@PathVariable("id") Long id)
	{
		service.deleteCar(id);
	}
	//endregion
}