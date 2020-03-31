package rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;


import pages.TimezonePage;

class GET
{
	private RestTemplate restTemplate;
	private String URL = "http://worldtimeapi.org/api/timezone/America/Los_Angeles";
	
	@BeforeEach
	void setUp()
	{
		restTemplate  = new RestTemplate();
	}
	
	@Test
	void GETasString()
	{
		String response = restTemplate.getForObject(URL, String.class);
		System.out.println(response);
	}
	
	@Test
	void GETasPOJO()
	//plain old java object
	{
		TimezonePage response = restTemplate.getForObject(URL, TimezonePage.class);
		assertEquals(1, response.getDay_of_week());
		assertEquals("PDT", response.getAbbreviation());
		
		
	}
}
