package in.expleo.service;

public class BankLoanService {
	public float calSimpleInteres(float pAmt, float rate, float time) {
		return pAmt*rate*time/100.0f;
	}
}
