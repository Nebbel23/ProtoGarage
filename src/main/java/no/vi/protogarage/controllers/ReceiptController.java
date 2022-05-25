package no.vi.protogarage.controllers;

import no.vi.protogarage.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/receipt")
public class ReceiptController
{
	private final ReceiptService receiptService;
	
	@Autowired
	private ReceiptController(ReceiptService receiptService)
	{
		this.receiptService = receiptService;
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<byte[]> getReceipt(@PathVariable("id") Long carId)
	{
		return receiptService.downloadReceipt(carId);
	}
}