package app.core.bussiness.admin;

import org.springframework.stereotype.Component;

@Component
public class UsersAdmin {

	public void addUser() {
		System.out.println("user added");
	}

	public void removeUser() {
		System.out.println("user removed");
	}

}
