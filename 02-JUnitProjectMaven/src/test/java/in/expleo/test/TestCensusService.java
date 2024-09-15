package in.expleo.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import in.expleo.service.CensusService;

public class TestCensusService {
	
	public static CensusService service;
	
	@BeforeAll
	public static void setUpOnce() {
		service = new CensusService();
	}
	
	@DisplayName("Testing Data Export")
	@RepeatedTest(value = 10, name = "execution of {displayName} - {currentRepetition}/ {totalRepetitions}")
	@Disabled
	public void testExportData() {
		assertEquals("Data Exported", service.exportData());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {10,21,24,15,7,8,12,35})
	@Disabled
	public void testIsOdd(int data) {
		System.out.println("TestCensusService.testIsOdd() :: "+data);
		boolean result = service.isOdd(data);
		assertTrue(result);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"sachin", "Dhoni", "Kohli"})
	@Disabled
	public void testSayHello(String name) {
		String actualOutput = service.sayHello(name);
		String expectedOutput = "Hello : "+name;
		assertEquals(expectedOutput, actualOutput);
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	public void testIsEmpty(String data) {
		assertTrue(service.isEmpty(data));
		
	}
	@AfterAll
	public static void cleanUpOnce() {
		service=null;
	}

}
