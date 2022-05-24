package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Receipt;
import no.vi.protogarage.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	private Receipt getReceipt(@PathVariable("id") Long carId) throws IOException
	{
		String content = service.getReceipt(carId).generate();
		String path = "/receipt.txt";
		Files.write( Paths.get(path), content.getBytes());
		
		return service.getReceipt(carId);
	}

	@GetMapping("/generated/{id}")
	private String getGeneratedReceipt(@PathVariable("id") Long carId)
	{
		return service.getGeneratedReceipt(carId);
	}
	
	//TODO DOWNLOADER VOOR RECEIPT
	//TODO DIT WEGHALEN
	
	/*
	https://stackoverflow.com/questions/35680932/download-a-file-from-spring-boot-rest-service
	
	
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/app")
public class ImageResource {

    private static final String EXTENSION = ".jpg";
    private static final String SERVER_LOCATION = "/server/images";

    @RequestMapping(path = "/download", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(@RequestParam("image") String image) throws IOException {
        File file = new File(SERVER_LOCATION + File.separator + image + EXTENSION);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

}
	 */
}