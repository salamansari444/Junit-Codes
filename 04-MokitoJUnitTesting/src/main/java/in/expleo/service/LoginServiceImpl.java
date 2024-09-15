package in.expleo.service;

import in.expleo.dao.ILoginDao;

public class LoginServiceImpl implements ILoginService {

	private ILoginDao dao;

	public LoginServiceImpl(ILoginDao dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if (username.equals("") || password.equals(""))
			throw new IllegalArgumentException("Empty Credentials");
		int count = dao.authenticate(username, password);
		if (count == 0)
			return false;
		else
			return true;
	}

	@Override
	public String registerUser(String username, String role) {
		if(!username.endsWith("") || !role.equals("") && !role.equals("visitor")) {
			dao.addUser(username, role);
			return "User Added";
		}else
			return "User not added";
	}

}
