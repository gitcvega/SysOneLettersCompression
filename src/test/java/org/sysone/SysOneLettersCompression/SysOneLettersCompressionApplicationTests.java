package org.sysone.SysOneLettersCompression;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SysOneLettersCompressionApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCandidate() throws Exception{
		this.mockMvc.perform(get("/candidate")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"name\":\"Cesar Vega\"}"));
	}

	@Test
	public void testCompressOK() throws Exception{
		this.mockMvc.perform(post("/compress")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\"value\": \"AAABBAAAAABB\"}"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"compressed\":\"3A2B5A2B\"}"));
	}

	@Test
	public void testCompressMayMinOK() throws Exception{
		this.mockMvc.perform(post("/compress")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\"value\": \"AAaaCcCC\"}"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"compressed\":\"4A4C\"}"));
	}

	@Test
	public void testCompressOneLetterOK() throws Exception{
		this.mockMvc.perform(post("/compress")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\"value\": \"a\"}"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"compressed\":\"1A\"}"));
	}

	@Test
	public void testCompressError() throws Exception{
		this.mockMvc.perform(post("/compress")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\"value\": \"AAA222BB33CCCC\"}"))
				.andExpect(status().is4xxClientError());
	}
}
