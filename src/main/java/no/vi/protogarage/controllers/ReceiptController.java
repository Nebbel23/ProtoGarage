package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Receipt;
import no.vi.protogarage.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/receipt")
public class ReceiptController
{
	private final ReceiptService service;
	
	@Autowired
	private ReceiptController(ReceiptService service)
	{
		this.service = service;
	}
	
	@GetMapping("/{id}")
	private Receipt getReceipt(@PathVariable("id") Long carId)
	{
		return service.getReceipt(carId);
	}
	
	@GetMapping("/{id}")
	private String getGeneratedReceipt(@PathVariable("id") Long carId)
	{
		return service.getGeneratedReceipt(carId);
	}
}