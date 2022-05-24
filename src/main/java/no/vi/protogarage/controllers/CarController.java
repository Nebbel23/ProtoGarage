package no.vi.protogarage.controllers;

import no.vi.protogarage.message.ResponseMessage;
import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("/{id}/cancel")
	private Car setExecuteStatus(@PathVariable("id") Long id)
	{
		return service.setExecuteStatus(id, false);
	}
	
	@GetMapping("/{id}/papers")
	private ResponseEntity<byte[]> getPapers(@PathVariable("id") Long id)
	{
		return service.getPapers(id);
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
	
	@PostMapping("/{id}/papers")
	public ResponseEntity<ResponseMessage> uploadPapers(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file)
	{
		return service.uploadPapers(id, file);
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