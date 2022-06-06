package eCommerce;

import eCommerce.business.abstracts.CustomerService;
import eCommerce.business.abstracts.LoginService;
import eCommerce.business.concretes.CustomerManager;
import eCommerce.business.concretes.LoginManager;
import eCommerce.core.concretes.EmailLogger;
import eCommerce.core.concretes.EmailValidator;
import eCommerce.core.concretes.GoogleAuthenticatorAdapter;
import eCommerce.dataAccess.concretes.HibernateCustomerDao;
import eCommerce.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {

		CustomerService customerService = new CustomerManager(new HibernateCustomerDao(), new EmailValidator(), new EmailLogger());
		CustomerService customerService2 = new CustomerManager(new GoogleAuthenticatorAdapter(), new EmailLogger());
		
		Customer emre = new Customer(1, "Emre Can", "Satık", "emrecanstk@gmail.com", "1796");
		Customer gulnur = new Customer(2, "Gülnur", "Vırdınlı", "gvv@gmail.com", "19070");
		
		customerService.memberAdd(emre);
		customerService2.memberAddWithGoogle("gvv@gmail.com","19070");
		
		LoginService loginService = new LoginManager(new HibernateCustomerDao());
		loginService.login(gulnur.getEmail(), gulnur.getPassword());
		loginService.login("emrecanstk@gmail.com", "1796");
	}

}
