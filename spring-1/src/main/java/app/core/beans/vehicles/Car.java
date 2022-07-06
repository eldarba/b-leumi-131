package app.core.beans.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car implements Vehicle {

	private Engine engine;

	@Autowired
	public Car(Engine turboEngine) {
		super();
		this.engine = turboEngine;
	}

	@Override
	public void move() {
		engine.turnOn();
		System.out.println("car moved");
	}

	@Override
	public void stop() {
		engine.turnOff();
		System.out.println("car stopped");
	}

}
