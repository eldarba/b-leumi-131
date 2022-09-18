package app.core.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerA {

	@Autowired
	private RestTemplate rt;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@HystrixCommand(fallbackMethod = "handleAFallback")
	@GetMapping("/service/a")
	public String handleA() {
//		String baseUri = getUriLB("service-b").toString();
//		String url = baseUri + "/service/b";
		String url = "http://service-b/service/b";
		String response = rt.getForObject(url, String.class);
		return "service A calls B: " + response;
	}
	
	public String handleAFallback(Throwable t) {
		return "Service A fallback. cant call B: " + t;
	}
	
	

	// LB
	URI getUriLB(String serviceId) {
		return this.loadBalancerClient.choose(serviceId).getUri();
	}

	// NO LB
	URI getUri(String serviceId) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
		return instances.get(1).getUri();
	}
}
