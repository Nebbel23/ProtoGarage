package no.vi.protogarage.controllers;

import java.util.List;

import no.vi.protogarage.message.ResponseFile;
import no.vi.protogarage.message.ResponseMessage;
import no.vi.protogarage.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

//TODO Service maken

@Controller
@RequestMapping(PATH_PREFIX + "/files")
@CrossOrigin("http://localhost:8081")
public class FileController
{
	@Autowired
	private FileStorageService storageService;
	
	@GetMapping
	public ResponseEntity<List<ResponseFile>> getListFiles()
	{
		return storageService.getListFiles();
	}
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file)
	{
		return storageService.uploadFile(file);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id)
	{
		return storageService.getFile(id);
	}
}