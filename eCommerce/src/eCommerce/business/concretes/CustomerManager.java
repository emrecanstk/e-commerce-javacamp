package eCommerce.business.concretes;

import java.util.List;

import eCommerce.business.abstracts.CustomerService;
import eCommerce.core.abstracts.EmailService;
import eCommerce.core.abstracts.LoggerService;
import eCommerce.core.abstracts.RegisterService;
import eCommerce.dataAccess.abstracts.CustomerDao;
import eCommerce.entities.concretes.Customer;

public class CustomerManager implements CustomerService {
	
	private CustomerDao customerDao;
	private EmailService emailService;
	private LoggerService loggerService;
	private RegisterService registerService;
	
	public CustomerManager(RegisterService registerService, LoggerService loggerService) {
		this.registerService = registerService;
		this.loggerService = loggerService;
	}
	
	public CustomerManager(CustomerDao customerDao, EmailService emailService, LoggerService loggerService) {
		this.customerDao = customerDao;
		this.emailService = emailService;
		this.loggerService = loggerService;
	}
	
	@Override
	public void memberAdd(Customer customer) {
		
		if(customer.getPassword().length() <= 5 || emailService.validator(customer) == false) {
			System.out.println("Your email or password is invalid." + "\n");
			return;
		}
		
		for(Customer user:this.customerDao.getAll()) {
			if(user.getEmail() == customer.getEmail()) {
				System.out.println("This email already exists." + "\n");
				return;
			};
		}
		
		if(customer.getFirstName().length() <= 1 || customer.getFirstName().length() <= 1) {
			System.out.println("Your name or surname is invalid." + "\n");
			return;
		}
		
		this.loggerService.verify(customer.getFirstName());
		this.customerDao.add(customer);
		
	}

	@Override
	public void memberDelete(Customer customer) {
		customerDao.delete(customer);
		
	}

	@Override
	public void memberUpdate(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberAddWithGoogle(String email, String password) {
		this.loggerService.verify(email);
		this.registerService.memberAdd(email, password);
	}

}
