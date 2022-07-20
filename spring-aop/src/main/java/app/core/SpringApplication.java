package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.aspects.StatisticsAspect;
import app.core.bussiness.admin.UsersAdmin;
import app.core.bussiness.user.UserActions;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApplication.class)) {
			UsersAdmin usersAdmin = ctx.getBean(UsersAdmin.class);
			UserActions userActions = ctx.getBean(UserActions.class);
			
			usersAdmin.addUser();
			usersAdmin.removeUser();
			usersAdmin.addUser();
			
			userActions.login("123");
			userActions.addAccount();
			userActions.removeAccount();
			userActions.addAccount();
			
			System.out.println("================");
			StatisticsAspect stats = ctx.getBean(StatisticsAspect.class);
			System.out.println("adds: " + stats.getAddCount());
			System.out.println("removes: " + stats.getRemoveCount());
			System.out.println("total: " + stats.getTotalCount());
			
		}
	}
}
