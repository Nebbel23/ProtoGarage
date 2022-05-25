package no.vi.protogarage.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import no.vi.protogarage.services.FileStorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FileController.class})
@ExtendWith(SpringExtension.class)
class FileControllerTest
{
	@Autowired
	private FileController fileController;
	
	@MockBean
	private FileStorageService fileStorageService;
	
	/**
	 * Method under test: {@link FileController#getListFiles()}
	 */
	@Test
	void testGetListFiles() throws Exception
	{
		when(this.fileStorageService.getListFiles()).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/files");
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.fileController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
	}
	
	/**
	 * Method under test: {@link FileController#getListFiles()}
	 */
	@Test
	void testGetListFiles2() throws Exception
	{
		when(this.fileStorageService.getListFiles()).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
		MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/files");
		getResult.contentType("https://example.org/example");
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.fileController).build().perform(getResult);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
	}
	
	/**
	 * Method under test: {@link FileController#getFile(String)}
	 */
	@Test
	void testGetFile() throws Exception
	{
		when(this.fileStorageService.getFile((String) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/files/{id}", "42");
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.fileController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
	}
	
	/**
	 * Method under test: {@link FileController#getFile(String)}
	 */
	@Test
	void testGetFile2() throws Exception
	{
		when(this.fileStorageService.getFile((String) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
		MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/files/{id}", "42");
		getResult.contentType("https://example.org/example");
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.fileController).build().perform(getResult);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
	}
	
	/**
	 * Method under test: {@link FileController#getFile(String)}
	 */
	@Test
	void testGetFile3() throws Exception
	{
		when(this.fileStorageService.getListFiles()).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
		when(this.fileStorageService.getFile((String) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/files/{id}", "", "Uri Vars");
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.fileController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
	}
}