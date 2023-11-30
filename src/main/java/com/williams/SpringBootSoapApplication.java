package com.williams;

import com.williams.client.SoapClient;
import com.williams.wsdl.AddResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringBootSoapApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapApplication.class, args);
	}

	@Bean
	CommandLineRunner init(SoapClient soapClient){
		return args -> {
			AddResponse response = soapClient.addMethod(4,67);
			log.info("El resultado de {} y {} es: {}", 4,67,response.getAddResult());

		};
	}

}
