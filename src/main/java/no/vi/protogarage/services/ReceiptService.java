package no.vi.protogarage.services;

import no.vi.protogarage.models.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService
{
	//TODO ALS TXT EXPORTEREN DIE RECEIPT, NONDEJU
	@Autowired
	CarService carService;
	
	public Receipt getReceipt(Long carId)
	{
		return new Receipt(carService.getCarById(carId));
	}
	
	public String getGeneratedReceipt(Long carId)
	{
		return new Receipt(carService.getCarById(carId)).generate();
	}
}