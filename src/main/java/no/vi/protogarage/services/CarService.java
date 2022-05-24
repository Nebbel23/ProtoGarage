package no.vi.protogarage.services;

import no.vi.protogarage.message.ResponseMessage;
import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.FileDB;
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.repositories.CarRepository;
import no.vi.protogarage.repositories.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CarService
{
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private FileDBRepository fileDBRepository;
	
	//region Get
	public List<Car> getAllCars()
	{
		return carRepository.findAll();
	}
	
	public Car getCarById(Long id)
	{
		return carRepository.findById(id).get();
	}
	
	public ResponseEntity<byte[]> getPapers(Long id)
	{
		String papersId = carRepository.findById(id).get().getPapersId();
		
		FileDB fileDB = fileDBRepository.findById(papersId).get();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
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
	
	public ResponseEntity<ResponseMessage> uploadPapers(Long id, MultipartFile file)
	{
		Car car = carRepository.findById(id).get();
		
		String message = "";
		try
		{
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
			fileDBRepository.save(FileDB);
			
			car.setPapersId(FileDB.getId());
			carRepository.save(car);
			
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e)
		{
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
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
							car.setPapersId(c.getPapersId());
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