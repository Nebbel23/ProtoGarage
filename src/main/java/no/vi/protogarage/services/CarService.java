package no.vi.protogarage.services;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
	@Autowired
	CarRepository carRepository;
	
	//region Get
	public List<Car> getAllCars()
	{
		return carRepository.findAll();
	}
	
	public Car getCarById(Long id)
	{
		return carRepository.findById(id).get();
	}
	//region
	
	//region Post
	public Car addCar(Car car)
	{
		return carRepository.save(car);
	}
	
	public Car addReparationToCar(Long carId, Reparation reparation)
	{
		Car car = carRepository.findById(carId).get();
		car.addReparation(reparation);
		return carRepository.save(car);
	}
	
	public Car setExecuteStatus(long id, boolean executeStatus)
	{
		Car car = carRepository.findById(id).get();
		car.setExecuteStatus(executeStatus);
		return carRepository.save(car);
	}
	//endregion
	
	//region Put
	public Car editCar(Long id, Car c)
	{
		return carRepository.findById(id)
				.map(
						car ->
						{
							car.setRegistration(c.getRegistration());
							car.setReparations(c.getReparations());
							car.setExecuteStatus(c.isExecuteStatus());
							car.setAtShop(c.isAtShop());
							car.setPayed(c.isPayed());
							
							return carRepository.save(car);
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
		carRepository.deleteById(id);
	}
	//endregion
}