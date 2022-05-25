package no.vi.protogarage.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import no.vi.protogarage.message.ResponseFile;
import no.vi.protogarage.message.ResponseMessage;

import no.vi.protogarage.models.FileDB;

import no.vi.protogarage.repositories.FileDBRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FileStorageService.class})
@ExtendWith(SpringExtension.class)
class FileStorageServiceTest
{
	@MockBean
	private FileDBRepository fileDBRepository;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	/**
	 * Method under test: {@link FileStorageService#store(org.springframework.web.multipart.MultipartFile)}
	 */
	@Test
	void testStore() throws IOException
	{
		FileDB fileDB = new FileDB();
		fileDB.setData("AAAAAAAA".getBytes("UTF-8"));
		fileDB.setName("Name");
		fileDB.setType("Type");
		when(this.fileDBRepository.save((FileDB) any())).thenReturn(fileDB);
		assertSame(fileDB, this.fileStorageService.store(new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8"))));
		verify(this.fileDBRepository).save((FileDB) any());
	}
	
	/**
	 * Method under test: {@link FileStorageService#getAllFiles()}
	 */
	@Test
	void testGetAllFiles()
	{
		when(this.fileDBRepository.findAll()).thenReturn(new ArrayList<>());
		this.fileStorageService.getAllFiles();
		verify(this.fileDBRepository).findAll();
	}
	
	/**
	 * Method under test: {@link FileStorageService#getListFiles()}
	 */
	@Test
	void testGetListFiles()
	{
		ArrayList<FileDB> fileDBList = new ArrayList<>();
		when(this.fileDBRepository.findAll()).thenReturn(fileDBList);
		ResponseEntity<List<ResponseFile>> actualListFiles = this.fileStorageService.getListFiles();
		assertEquals(fileDBList, actualListFiles.getBody());
		assertEquals(HttpStatus.OK, actualListFiles.getStatusCode());
		assertTrue(actualListFiles.getHeaders().isEmpty());
		verify(this.fileDBRepository).findAll();
	}
	
	/**
	 * Method under test: {@link FileStorageService#uploadFile(org.springframework.web.multipart.MultipartFile)}
	 */
	@Test
	void testUploadFile() throws UnsupportedEncodingException
	{
		FileDB fileDB = new FileDB();
		fileDB.setData("AAAAAAAA".getBytes("UTF-8"));
		fileDB.setName("Name");
		fileDB.setType("Type");
		when(this.fileDBRepository.save((FileDB) any())).thenReturn(fileDB);
		ResponseEntity<ResponseMessage> actualUploadFileResult = this.fileStorageService
				.uploadFile(new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8")));
		assertTrue(actualUploadFileResult.hasBody());
		assertTrue(actualUploadFileResult.getHeaders().isEmpty());
		assertEquals(HttpStatus.OK, actualUploadFileResult.getStatusCode());
		assertEquals("Uploaded the file successfully: ", actualUploadFileResult.getBody().getMessage());
		verify(this.fileDBRepository).save((FileDB) any());
	}
	
	/**
	 * Method under test: {@link FileStorageService#getFile(String)}
	 */
	@Test
	void testGetFile() throws UnsupportedEncodingException
	{
		FileDB fileDB = new FileDB();
		fileDB.setData("AAAAAAAA".getBytes("UTF-8"));
		fileDB.setName("Name");
		fileDB.setType("Type");
		Optional<FileDB> ofResult = Optional.of(fileDB);
		when(this.fileDBRepository.findById((String) any())).thenReturn(ofResult);
		ResponseEntity<byte[]> actualFile = this.fileStorageService.getFile("42");
		assertEquals(8, actualFile.getBody().length);
		assertEquals(HttpStatus.OK, actualFile.getStatusCode());
		assertEquals(1, actualFile.getHeaders().size());
		verify(this.fileDBRepository).findById((String) any());
	}
}