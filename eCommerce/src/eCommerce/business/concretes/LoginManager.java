package eCommerce.business.concretes;

import eCommerce.business.abstracts.LoginService;
import eCommerce.dataAccess.abstracts.CustomerDao;
import eCommerce.entities.concretes.Customer;

public class LoginManager implements LoginService {
	
	private CustomerDao customerDao;
	
	public LoginManager(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public void login(String email, String password) {
		for(Customer customer : this.customerDao.getAll()) {
			if(customer.getEmail() == email || customer.getPassword() == password) {
				System.out.println(customer.getFirstName() + " is succesfuly logined.");
			}
			else {
				System.out.println("Your email or password is invalid.");
			}
		}
		
	}

}
