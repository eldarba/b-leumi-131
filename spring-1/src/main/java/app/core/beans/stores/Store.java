package app.core.beans.stores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Store {

	@Value("${store.name}")
	private String name;
	@Value("${store.address}")
	private String address;

}
