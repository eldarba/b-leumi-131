package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.bussiness.admin.UsersAdmin;
import app.core.bussiness.user.UserActions;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApplication.class)) {
			UsersAdmin usersAdmin = ctx.getBean(UsersAdmin.class);
			System.out.println(usersAdmin.getClass());
			usersAdmin.addUser();
			
			UserActions userActions = ctx.getBean(UserActions.class);
			userActions.login("123");
			userActions.addAccount();
			
		}
	}
}
