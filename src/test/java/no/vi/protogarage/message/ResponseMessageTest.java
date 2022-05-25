package no.vi.protogarage.message;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResponseMessageTest
{
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link ResponseMessage#ResponseMessage(String)}
	 *   <li>{@link ResponseMessage#setMessage(String)}
	 *   <li>{@link ResponseMessage#getMessage()}
	 * </ul>
	 */
	@Test
	void testConstructor()
	{
		ResponseMessage actualResponseMessage = new ResponseMessage("Not all who wander are lost");
		actualResponseMessage.setMessage("Not all who wander are lost");
		assertEquals("Not all who wander are lost", actualResponseMessage.getMessage());
	}
}