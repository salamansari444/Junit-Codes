package in.expleo.service;

public class CensusService {
	public String exportData() {
		//...
		return "Data Exported";
	}
	
	public boolean isOdd(int num) {
		if(num%2==0) 
			return false;
		else
			return true;
	}
	
	public String sayHello(String user) {
		return "Hello : "+user;
	}
	
	public boolean isEmpty(String data) {
		return data.isBlank();
	}
}
