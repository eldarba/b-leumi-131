package app.core.beans.stores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
@Lazy(false)
public class Store {

	{
		System.out.println("Store intanciated");
	}

	@Value("${store.name}")
	private String name;
	@Value("${store.address}")
	private String address;

}
