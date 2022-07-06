package app.core.beans.vehicles;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//@Primary
public class BasicEngine implements Engine {

	@Override
	public void turnOn() {
		System.out.println("basic engine on");
	}

	@Override
	public void turnOff() {
		System.out.println("basic engine off");
	}

}
