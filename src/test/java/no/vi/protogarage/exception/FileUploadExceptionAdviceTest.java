package no.vi.protogarage.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import no.vi.protogarage.message.ResponseMessage;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

class FileUploadExceptionAdviceTest
{
	/**
	 * Method under test: {@link FileUploadExceptionAdvice#handleMaxSizeException(MaxUploadSizeExceededException)}
	 */
	@Test
	void testHandleMaxSizeException()
	{
		FileUploadExceptionAdvice fileUploadExceptionAdvice = new FileUploadExceptionAdvice();
		ResponseEntity<ResponseMessage> actualHandleMaxSizeExceptionResult = fileUploadExceptionAdvice
				.handleMaxSizeException(new MaxUploadSizeExceededException(3L));
		assertTrue(actualHandleMaxSizeExceptionResult.hasBody());
		assertTrue(actualHandleMaxSizeExceptionResult.getHeaders().isEmpty());
		assertEquals(HttpStatus.EXPECTATION_FAILED, actualHandleMaxSizeExceptionResult.getStatusCode());
		assertEquals("File too large!", actualHandleMaxSizeExceptionResult.getBody().getMessage());
	}
}