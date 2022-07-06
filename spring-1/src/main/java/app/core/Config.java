package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import app.core.beans.Bank;

@ComponentScan
@Configuration
public class Config {

	// beans definitions

	@Bean("bank-leumi")
	@Lazy
	public Bank bankLeumi() {
		Bank bank = new Bank();
		return bank;
	}

	@Bean
	@Scope("prototype")
	public Integer random() {
		return (int) (Math.random() * 101);
	}
	
	@Bean
	public String msg() {
		return "the msg bean";
	}

}
