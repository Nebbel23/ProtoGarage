package no.vi.protogarage.services;

import no.vi.protogarage.models.Receipt;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService
{
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