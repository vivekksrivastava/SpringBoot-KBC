package com.hcl.kbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = KbcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class KbcApplicationTestsIT {

	@LocalServerPort
	private int port;
	
	@SuppressWarnings("deprecation")
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	@Before
	public void before() {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", createHttpHeadersAuthValue("admin1", "secret1"));
	}
	
	
	private String createHttpHeadersAuthValue(String userId, String password) {
		String auth = userId + ":" + password;
		
		byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
		
		String headerValue = "Basic "+ new String(encodedAuth);
		
		
		return headerValue;
	}

	
	@Test
	public void testRefreshQuestionList() {
		
		HttpEntity entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getSpecificUrl()+"/refreshList", HttpMethod.GET, entity, String.class);
		String expected = "The List of Questions is refreshed.";
		String actual = response.getBody();
		System.out.println("Response: "+actual);
		assertEquals(expected, actual);
		
	}
	
	
	
	@Test
	public void testRerieveQuestion() {
		
		HttpEntity entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getSpecificUrl()+"/retrieveQuestion", HttpMethod.GET, entity, String.class);
		String actual = response.getBody();
		System.out.println("Response: "+actual);
		if(!actual.contains("correctAnswer"))
			fail("Unknown JSON String");
		
	}
	
	
	
	
	public String getSpecificUrl() {
		return "http://localhost:"+port;
	}
	
	
}
