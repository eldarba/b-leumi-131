package app.core.bussiness.user;

import org.springframework.stereotype.Component;

@Component
public class UserActions {

	public void login(String password) {
		System.out.println("logged in");
	}

	public void addAccount() {
		System.out.println("user account added");
	}

	public void removeAccount() {
		System.out.println("user account removed");
	}

}
