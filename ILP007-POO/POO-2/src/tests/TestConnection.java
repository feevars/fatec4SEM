package tests;

import model.dao.DaoFactory;

public class TestConnection {

	public static void main(String[] args) {
		DaoFactory conFactory =  new DaoFactory();
		
		conFactory.getConnection();
		
		
		
	}

}
