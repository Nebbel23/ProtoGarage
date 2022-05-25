package no.vi.protogarage.services;

import no.vi.protogarage.models.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class ReceiptService
{
	@Autowired
	CarService carService;
	
	public ResponseEntity<byte[]> downloadReceipt(Long carId)
	{
		Receipt receipt = new Receipt(carService.getCarById(carId));
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"receipt-" + carId.toString() + ".txt\"")
				.body(receipt.generate().getBytes(StandardCharsets.UTF_8));
	}
}