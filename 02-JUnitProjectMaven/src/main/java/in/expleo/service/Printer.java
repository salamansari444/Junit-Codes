package in.expleo.service;
//Singletone Class
public class Printer {
	private static Printer INSTANCE = new Printer();
	
	private Printer() {}
	
	public static Printer getInstance() {
		return INSTANCE;
	}
}
