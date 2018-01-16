package eu.h2020.symbiote.cbat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient    
@EnableAutoConfiguration
@SpringBootApplication
public class CoreBarteringAndTrading {

	public static void main(String[] args) {
		SpringApplication.run(CoreBarteringAndTrading.class, args);
    }
}
