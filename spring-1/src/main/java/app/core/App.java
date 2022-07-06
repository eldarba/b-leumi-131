package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// spring container - create and manages spring beans
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config.class);
		System.out.println("up");
		String[] beans = ctx.getBeanDefinitionNames();
		for (String x : beans) {
			System.out.println(x);
		}
		// close the context
		ctx.close();
		System.out.println("down");

	}

}
