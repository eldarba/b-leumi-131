package app.core.beans.ctors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class App {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(App.class)){
			
			Teacher teacher = ctx.getBean(Teacher.class);
			teacher.teach();
			
		}
	}

}
