package app.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.beans.vehicles.Car;
import app.core.beans.vehicles.Engine;
import app.core.beans.vehicles.TurboEngine;
import app.core.beans.vehicles.Vehicle;

@ComponentScan
@Configuration
public class App4 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App4.class);) {

			Vehicle v = ctx.getBean("car", Vehicle.class);
			v.move();
			v.stop();
		}

	}

	@Bean
	@Scope("prototype")
	public Car raceCar(@Qualifier("turboEngine") Engine engine) {
		Car car = new Car(engine);
		return car;
	}

}
