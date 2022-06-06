package eCommerce.core.concretes;

import java.util.Scanner;

import eCommerce.core.abstracts.LoggerService;

public class EmailLogger implements LoggerService {

	@Override
	public void verify(String message) {
		
		System.out.println("Link has been sent to your e-mail adress.\n");
		Scanner confirm = new Scanner(System.in);
		
		int input = confirm.nextInt();
		if(input == 1) { System.out.println(message + " successful." + "\n"); }
		else { System.out.println(message + " unsuccessful!" + "\n"); }
		
	}

}
