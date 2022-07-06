package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App3 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {
			int a = ctx.getBean(Integer.class);
			int b = ctx.getBean(Integer.class);
			int c = ctx.getBean(Integer.class);
			
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			
			String msg = ctx.getBean(String.class);
			System.out.println(msg);
		}

	}

}
