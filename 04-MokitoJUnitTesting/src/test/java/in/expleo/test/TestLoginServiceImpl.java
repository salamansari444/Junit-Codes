package in.expleo.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import in.expleo.dao.ILoginDao;
import in.expleo.service.LoginServiceImpl;

public class TestLoginServiceImpl {
	
	public static ILoginDao loginDaoMock;
	public static LoginServiceImpl loginService;
	
	@BeforeAll
	public static  void setUpOnce() {
		loginDaoMock = Mockito.mock(ILoginDao.class);
		System.out.println("Implementation class is : "+loginDaoMock.getClass().getName());
		
		loginService = new LoginServiceImpl(loginDaoMock);
	}
	@Test
	@Disabled
	public void testLoginWithValidCredential() {
		Mockito.when(loginDaoMock.authenticate("sachin", "tendulkar")).thenReturn(1);
		boolean actualOutput = loginService.login("sachin", "tendulkar");
		assertTrue(actualOutput);		
	}
	@Test
	@Disabled
	public void testLoginWithInvalidCredential() {
		Mockito.when(loginDaoMock.authenticate("sachin", "sachin11")).thenReturn(0);
		boolean actualOutput = loginService.login("sachin", "sachiin11");
		assertFalse(actualOutput);	
	}
	@Test
	@Disabled
	public void testLoginWithNoCredential() {
		assertThrows(IllegalArgumentException.class, ()->  loginService.login("", "") );
	}
	
	@Test
	public void testRegisterWithUser() {
		ILoginDao spy = Mockito.spy(ILoginDao.class);
		System.out.println("Spy Object : "+spy.getClass().getName());
		
		LoginServiceImpl loginService = new LoginServiceImpl(spy);
		loginService.registerUser("sachin", "admin");
		loginService.registerUser("virat", "");
		loginService.registerUser("dhoni", "visitor");
		
		Mockito.verify(spy, Mockito.times(1)).addUser("sachin", "admin");
		Mockito.verify(spy, Mockito.times(0)).addUser("virat", "");
		Mockito.verify(spy, Mockito.times(0)).addUser("dhoni", "visitor");
	}
	
	@AfterAll
	public static void clearOnce() {
		loginDaoMock = null;
		loginService = null;
	}
}
