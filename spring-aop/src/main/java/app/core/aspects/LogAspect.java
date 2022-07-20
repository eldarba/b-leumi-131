package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	// execution - pointcut designator
	@Before("execution(void addUser())")
	public void logBeforeAddingUser() {
		System.out.println(">>> attempting to add user");
	}
	
	@Before("execution(* app.core.bussiness.user.*.*(..))")
	public void logBeforeMethodsInUserPackage() {
		System.out.println(">>> user method invoked");
	}
}
