package app.core.beans.stores;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class App {

	public static void main(String[] args) throws InterruptedException {
		
		try(AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(App.class)){
			
			System.out.println("up");
			
			Thread.sleep(3000);
			
			 Store store = ctx.getBean(Store.class);
			 System.out.println(store);

			 Thread.sleep(3000);
			 
			 Store store1 = ctx.getBean(Store.class);
			 System.out.println(store1);
			
			System.out.println("end");
			
		}

	}

}
