package no.vi.protogarage.services;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
	@Autowired
	CarRepository repo;
	
	//region Get
	public List<Car> getAllCars()
	{
		return repo.findAll();
	}
	
	public Car getCarById(Long id)
	{
		return repo.findById(id).get();
	}
	//region
	
	//region Post
	public Car addCar(Car car)
	{
		return repo.save(car);
	}
	
	public Car addReparationToCar(Long carId, Reparation reparation)
	{
		Car car = repo.findById(carId).get();
		car.addReparation(reparation);
		return repo.save(car);
	}
	//endregion
	
	//region Put
	public Car editCar(Long id, Car c)
	{
		return repo.findById(id)
				.map(
						car ->
						{
							car.setRegistration(c.getRegistration());
							car.setReparations(c.getReparations());
							car.setAtShop(c.isAtShop());
							car.setPayed(c.isPayed());
							
							//todo papers
							
							return repo.save(car);
						}
				).orElseGet(() ->
						{
							return addCar(c);
						}
				);
	}
	//endregion
	
	//region Delete
	public void deleteCar(Long id)
	{
		repo.deleteById(id);
	}
	//endregion
}