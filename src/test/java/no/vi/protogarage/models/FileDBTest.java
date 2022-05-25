package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

class FileDBTest
{
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link FileDB#FileDB()}
	 *   <li>{@link FileDB#setData(byte[])}
	 *   <li>{@link FileDB#setName(String)}
	 *   <li>{@link FileDB#setType(String)}
	 *   <li>{@link FileDB#getId()}
	 *   <li>{@link FileDB#getName()}
	 *   <li>{@link FileDB#getType()}
	 * </ul>
	 */
	@Test
	void testConstructor() throws UnsupportedEncodingException
	{
		FileDB actualFileDB = new FileDB();
		actualFileDB.setData("AAAAAAAA".getBytes("UTF-8"));
		actualFileDB.setName("Name");
		actualFileDB.setType("Type");
		assertNull(actualFileDB.getId());
		assertEquals("Name", actualFileDB.getName());
		assertEquals("Type", actualFileDB.getType());
	}
	
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link FileDB#FileDB(String, String, byte[])}
	 *   <li>{@link FileDB#setData(byte[])}
	 *   <li>{@link FileDB#setName(String)}
	 *   <li>{@link FileDB#setType(String)}
	 *   <li>{@link FileDB#getId()}
	 *   <li>{@link FileDB#getName()}
	 *   <li>{@link FileDB#getType()}
	 * </ul>
	 */
	@Test
	void testConstructor2() throws UnsupportedEncodingException
	{
		FileDB actualFileDB = new FileDB("Name", "Type", "AAAAAAAA".getBytes("UTF-8"));
		actualFileDB.setData("AAAAAAAA".getBytes("UTF-8"));
		actualFileDB.setName("Name");
		actualFileDB.setType("Type");
		assertNull(actualFileDB.getId());
		assertEquals("Name", actualFileDB.getName());
		assertEquals("Type", actualFileDB.getType());
	}
}