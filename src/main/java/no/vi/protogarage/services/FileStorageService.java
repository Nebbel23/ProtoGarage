package no.vi.protogarage.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import no.vi.protogarage.message.ResponseFile;
import no.vi.protogarage.message.ResponseMessage;
import no.vi.protogarage.models.FileDB;
import no.vi.protogarage.repositories.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@Service
public class FileStorageService
{
	@Autowired
	private FileDBRepository fileDBRepository;
	
	public FileDB store(MultipartFile file) throws IOException
	{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
		return fileDBRepository.save(FileDB);
	}
	
	public Stream<FileDB> getAllFiles()
	{
		return fileDBRepository.findAll().stream();
	}
	
	public ResponseEntity<List<ResponseFile>> getListFiles()
	{
		List<ResponseFile> files = getAllFiles().map(dbFile ->
		{
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path(PATH_PREFIX + "/files/")
					.path(dbFile.getId())
					.toUriString();
			return new ResponseFile(
					dbFile.getName(),
					fileDownloadUri,
					dbFile.getType(),
					dbFile.getData().length);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	public ResponseEntity<ResponseMessage> uploadFile(MultipartFile file)
	{
		String message = "";
		try
		{
			store(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e)
		{
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	public ResponseEntity<byte[]> getFile(String id)
	{
		FileDB fileDB = fileDBRepository.findById(id).get();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}
}