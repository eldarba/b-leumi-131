package app.core.beans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data

// spring bean definition
@Component("bank-hapoalim")
public class Bank {
	
	{
		// System.out.println("bank created");
	}

	private int id;
	private String name;
	private String address;

}
