package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import app.core.auth.JwtUtilImpl;
import app.core.filters.SchoolApiFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootDataJpaMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaMappingsApplication.class, args);

	}

	@Bean
	@Order(2)
	FilterRegistrationBean<SchoolApiFilter> registrationBean(JwtUtilImpl util) {
		FilterRegistrationBean<SchoolApiFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new SchoolApiFilter(util));
		bean.addUrlPatterns("/api/school/*");
		return bean;
	}
	
	
	
	
	
	

}
