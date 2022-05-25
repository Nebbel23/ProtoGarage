package no.vi.protogarage.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Part;
import no.vi.protogarage.models.Reparation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReceiptService.class})
@ExtendWith(SpringExtension.class)
class ReceiptServiceTest
{
	@MockBean
	private CarService carService;
	
	@Autowired
	private ReceiptService receiptService;
	
	/**
	 * Method under test: {@link ReceiptService#downloadReceipt(Long)}
	 */
	@Test
	void testDownloadReceipt()
	{
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		when(this.carService.getCarById((Long) any())).thenReturn(car);
		ResponseEntity<byte[]> actualDownloadReceiptResult = this.receiptService.downloadReceipt(123L);
		assertEquals(888, actualDownloadReceiptResult.getBody().length);
		assertEquals(HttpStatus.OK, actualDownloadReceiptResult.getStatusCode());
		assertEquals(1, actualDownloadReceiptResult.getHeaders().size());
		verify(this.carService).getCarById((Long) any());
	}
	
	/**
	 * Method under test: {@link ReceiptService#downloadReceipt(Long)}
	 */
	@Test
	void testDownloadReceipt2()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Garagé");
		
		ArrayList<Reparation> reparationList = new ArrayList<>();
		reparationList.add(reparation);
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(reparationList);
		when(this.carService.getCarById((Long) any())).thenReturn(car);
		ResponseEntity<byte[]> actualDownloadReceiptResult = this.receiptService.downloadReceipt(123L);
		assertEquals(1001, actualDownloadReceiptResult.getBody().length);
		assertEquals(HttpStatus.OK, actualDownloadReceiptResult.getStatusCode());
		assertEquals(1, actualDownloadReceiptResult.getHeaders().size());
		verify(this.carService).getCarById((Long) any());
	}
	
	/**
	 * Method under test: {@link ReceiptService#downloadReceipt(Long)}
	 */
	@Test
	void testDownloadReceipt3()
	{
		Part part = new Part();
		part.setCost(1);
		part.setName("Garagé");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(1);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(1);
		labor.setName("Garagé");
		
		ArrayList<Labor> laborList = new ArrayList<>();
		laborList.add(labor);
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(laborList);
		reparation.setName("Garagé");
		
		ArrayList<Reparation> reparationList = new ArrayList<>();
		reparationList.add(reparation);
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(reparationList);
		when(this.carService.getCarById((Long) any())).thenReturn(car);
		ResponseEntity<byte[]> actualDownloadReceiptResult = this.receiptService.downloadReceipt(123L);
		assertEquals(1116, actualDownloadReceiptResult.getBody().length);
		assertEquals(HttpStatus.OK, actualDownloadReceiptResult.getStatusCode());
		assertEquals(1, actualDownloadReceiptResult.getHeaders().size());
		verify(this.carService).getCarById((Long) any());
	}
}