package com.github.seratch.signedrequest;

import static org.junit.Assert.*;
import com.github.seratch.signedrequest.HttpMethod;
import org.junit.Test;

public class HttpMethodTest {

	@Test
	public void type() throws Exception {
		assertNotNull(HttpMethod.class);
	}

	@Test
	public void toString_A$() throws Exception {
		HttpMethod target = HttpMethod.GET;
		String actual = target.toString();
		String expected = "GET";
		assertEquals(expected, actual);
	}

}