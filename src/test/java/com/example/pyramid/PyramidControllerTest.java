package com.example.pyramid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PyramidControllerTest {

	// bind the above RANDOM_PORT
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getTest1() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/pyramid/banana").toString(), String.class);
		assertEquals("true", response.getBody());

	}

	@Test
	public void getTest2() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/pyramid/bananaa").toString(), String.class);
		assertEquals("false", response.getBody());

	}
	
	@Test
	public void getTest3() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/pyramid/bananassss").toString(), String.class);
		assertEquals("true", response.getBody());

	}
	
	
	@Test
	public void getTest4() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/pyramid/banananab").toString(), String.class);
		assertEquals("false", response.getBody());

	}
	
	@Test
	public void getTest5() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/pyramid/abc").toString(), String.class);
		assertEquals("false", response.getBody());

	}
	
	@Test
	public void getTest6() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/pyramid/_banana_").toString(), String.class);
		assertEquals("false", response.getBody());

	}
	
	@Test
	public void getTest7() throws Exception {
		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/pyramid/aaaaaaabbcccddddeeeeeffffffo").toString(), String.class);
		assertEquals("true", response.getBody());

	}
	
	@Test
	public void getTest8() throws Exception {
		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/pyramid/ccccaaabbbe").toString(), String.class);
		assertEquals("false", response.getBody());

	}

}
