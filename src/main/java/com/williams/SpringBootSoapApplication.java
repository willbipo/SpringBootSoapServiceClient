package com.williams;

import com.williams.client.SoapClient;
import com.williams.wsdl.AddResponse;
import com.williams.wsdl.DivideResponse;
import com.williams.wsdl.MultiplyResponse;
import com.williams.wsdl.SubtractResponse;
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
			AddResponse add = soapClient.addMethod(4,67);
			log.info("El resultado de {} + {} es: {}", 4,67,add.getAddResult());
			SubtractResponse substract = soapClient.substractMethod(9,2);
			log.info("El resultado de {} - {} es: {}", 9,2,substract.getSubtractResult());
			MultiplyResponse multipy = soapClient.multiplyMethod(2,5);
			log.info("El resultado de {} * {} es: {}", 2,5,multipy.getMultiplyResult());
			DivideResponse divide = soapClient.divideMethod(34,2);
			log.info("El resultado de {} / {} es: {}", 34,2,divide.getDivideResult());


		};
	}

}
