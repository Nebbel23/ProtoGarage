package no.vi.protogarage.controllers;

import no.vi.protogarage.services.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CarController.class})
@ExtendWith(SpringExtension.class)
class CarControllerTest
{
	@Autowired
	private CarController carController;
	
	@MockBean
	private CarService carService;
	
	/**
	 * Method under test: {@link CarController#uploadPapers(Long, org.springframework.web.multipart.MultipartFile)}
	 */
	@Test
	void testUploadPapers() throws Exception
	{
		MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/v1/car/{id}/papers", "Uri Vars",
				"Uri Vars");
		MockHttpServletRequestBuilder requestBuilder = postResult.param("file", String.valueOf((Object) null));
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
	}
}