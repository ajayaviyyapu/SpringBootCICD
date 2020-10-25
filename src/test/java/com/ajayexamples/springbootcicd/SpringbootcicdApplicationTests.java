package com.ajayexamples.springbootcicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;

@SpringBootTest
@AutoConfigureMockMvc
class SpringbootcicdApplicationTests {

	@Autowired
	private MockMvc mockmvc;

	@Test
	public void getAllRides() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/ride").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getSingleRide() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/ride/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getRideNotFoundException() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/ride/100").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound()).andReturn();
	}

	@Test
	public void createRide() throws Exception {

		/*	Usage	
		 * JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "Hello \"World\"");
		String payload = jsonObject.toString();*/

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "Giant Wheel");
		jsonObj.put("description", "Wheel Ride");
		jsonObj.put("thrillFactor", 4);
		jsonObj.put("vomitFactor", 1);



		String content = jsonObj.toString();
		mockmvc.perform(MockMvcRequestBuilders.post("/ride")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
	}

}
