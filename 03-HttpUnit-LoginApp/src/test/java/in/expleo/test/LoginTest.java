package in.expleo.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LoginTest {
	public static WebConversation conversation;
	
	@BeforeAll
	public static void setUpOnce() {
		conversation = new WebConversation();
	}
	
	@Test
	@DisplayName("Testing with Valid Inputs")
	public void testWithValidCredential() throws Exception {
		System.out.println("LoginTest.testWithValidCredential()");
		String url = "http://localhost:9999/03-HttpUnit-LoginApp/index.html";
		// get response by sending the request to the URL
		WebResponse response = conversation.getResponse(url);
		
		// get access to the form from the response
		WebForm form = response.getForms()[0];
		
		// setting the request params values to the form object
		form.setParameter("uname", "sachin");
		form.setParameter("password", "tendulkar");
		
		// submit the form to get the response
		WebResponse actualResponse = form.submit();
		
		// Get the output from the response object
		String actualOutput = actualResponse.getText().trim();
		
		// perform assertion to validate the output
		assertEquals("valid credentials", actualOutput);
		
	}
	
	@Test
	@DisplayName("Testing with Invalid Inputs")
	public void testWithInValidCredential() throws Exception {
		System.out.println("LoginTest.testWithInValidCredential()");
		String url = "http://localhost:9999/03-HttpUnit-LoginApp/index.html";
		// get response by sending the request to the URL
		WebResponse response = conversation.getResponse(url);
		
		// get access to the form from the response
		WebForm form = response.getForms()[0];
		
		// setting the request params values to the form object
		form.setParameter("uname", "sachin234");
		form.setParameter("password", "tendulkar");
		
		// submit the form to get the response
		WebResponse actualResponse = form.submit();
		
		// Get the output from the response object
		String actualOutput = actualResponse.getText().trim();
		
		// perform assertion to validate the output
		assertEquals("invalid credentials", actualOutput);
		
	}
	
	@Test
	@DisplayName("Testing with No Inputs")
	public void testWithNoInputs() throws Exception {
		System.out.println("LoginTest.testWithNoInputs()");
		
		// get response by sending the request to the URL
		String url = "http://localhost:9999/03-HttpUnit-LoginApp/index.html";
		WebResponse response = conversation.getResponse(url);

		// get access to the form from the response
		WebForm form = response.getForms()[0];

		// setting the request params values to the form object
		form.setParameter("uname", "");
		form.setParameter("password", "");

		// submit the form to get the response
		WebResponse actualResponse = form.submit();

		// Get the output from the response object
		String actualOutput = actualResponse.getText().trim();

		// perform assertion to validate the output
		assertEquals("provide credentials", actualOutput);
	}
	
	@AfterAll
	public static void cleanUpOnce() {
		conversation = null;
	}
}
