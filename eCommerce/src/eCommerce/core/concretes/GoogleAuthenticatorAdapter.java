package eCommerce.core.concretes;

import eCommerce.core.abstracts.RegisterService;
import eCommerce.googleApi.GoogleAuthenticator;

public class GoogleAuthenticatorAdapter implements RegisterService {

	@Override
	public void memberAdd(String email, String password) {
		GoogleAuthenticator member = new GoogleAuthenticator();
		member.register(email, password);
		
	}

}
