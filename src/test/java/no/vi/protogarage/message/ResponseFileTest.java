package no.vi.protogarage.message;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResponseFileTest
{
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link ResponseFile#ResponseFile(String, String, String, long)}
	 *   <li>{@link ResponseFile#setName(String)}
	 *   <li>{@link ResponseFile#setSize(long)}
	 *   <li>{@link ResponseFile#setType(String)}
	 *   <li>{@link ResponseFile#setUrl(String)}
	 *   <li>{@link ResponseFile#getName()}
	 *   <li>{@link ResponseFile#getSize()}
	 *   <li>{@link ResponseFile#getType()}
	 *   <li>{@link ResponseFile#getUrl()}
	 * </ul>
	 */
	@Test
	void testConstructor()
	{
		ResponseFile actualResponseFile = new ResponseFile("Name", "https://example.org/example", "Type", 3L);
		actualResponseFile.setName("Name");
		actualResponseFile.setSize(3L);
		actualResponseFile.setType("Type");
		actualResponseFile.setUrl("https://example.org/example");
		assertEquals("Name", actualResponseFile.getName());
		assertEquals(3L, actualResponseFile.getSize());
		assertEquals("Type", actualResponseFile.getType());
		assertEquals("https://example.org/example", actualResponseFile.getUrl());
	}
}