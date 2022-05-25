package no.vi.protogarage.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppUserRoleTest
{
	/**
	 * Method under test: {@link AppUserRole#values()}
	 */
	@Test
	void testValues()
	{
		AppUserRole[] actualValuesResult = AppUserRole.values();
		assertEquals(4, actualValuesResult.length);
		assertEquals(AppUserRole.ADMIN, actualValuesResult[0]);
		assertEquals(AppUserRole.BACKOFFICE, actualValuesResult[1]);
		assertEquals(AppUserRole.CASHIER, actualValuesResult[2]);
		assertEquals(AppUserRole.MECHANIC, actualValuesResult[3]);
	}
}