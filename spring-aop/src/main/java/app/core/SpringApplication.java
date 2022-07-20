package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.bussiness.admin.UsersAdmin;

@ComponentScan
@Configuration
public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApplication.class)) {
			UsersAdmin usersAdmin = ctx.getBean(UsersAdmin.class);
			usersAdmin.addUser();
		}
	}
}
