package in.expleo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestMockVsSpy {
	@Test
	public void testList() {
		ArrayList<String> listMock = Mockito.mock(ArrayList.class);
		ArrayList<String> listSpy = Mockito.spy(new ArrayList<String>());
		Mockito.when(listMock.size()).thenReturn(10);
		listMock.add("sachin");
		
		Mockito.when(listSpy.size()).thenReturn(10);
		listSpy.add("Sachin");
		
		System.out.println(listMock.size() +" :: "+listSpy.size());
	}
}
