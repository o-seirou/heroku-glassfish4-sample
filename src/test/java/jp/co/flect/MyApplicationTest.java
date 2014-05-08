package jp.co.flect;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplicationTest extends TestCase {

	public void setUp() throws Exception {
		super.setUp();

	}

	@Test
	public void testConstractor() throws Exception {

		List<String> data = Arrays.asList("Java","Ruby","Python","Rerl");
		data.forEach(s -> { System.out.println(s); });

		MyApplication target = new MyApplication();

	}


	public void tearDown() throws Exception {

	}
}