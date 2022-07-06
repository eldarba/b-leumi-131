package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Bank;

public class App2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {
			Bank poalim = ctx.getBean("bank-hapoalim", Bank.class);
			System.out.println(System.identityHashCode(poalim));
			
			Bank leumi = ctx.getBean("bank-leumi", Bank.class);
			Bank leumi1 = ctx.getBean("bank-leumi", Bank.class);
			Bank leumi2 = ctx.getBean("bank-leumi", Bank.class);
			System.out.println(System.identityHashCode(leumi));
			System.out.println(System.identityHashCode(leumi1));
			System.out.println(System.identityHashCode(leumi2));
		}

	}

}
