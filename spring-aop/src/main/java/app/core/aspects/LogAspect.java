package app.core.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
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
	public void logBeforeMethodsInUserPackage(JoinPoint jp) {
		Object[] args = jp.getArgs();
		System.out.print(">>> user method invoked: " + jp.getSignature().getName());
		System.out.println(": arguments: " + Arrays.toString(args));
	}
}
