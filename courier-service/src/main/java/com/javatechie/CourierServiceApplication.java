package com.javatechie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.List;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CourierServiceApplication {

	private static Logger logger = LoggerFactory.getLogger(CourierServiceApplication.class);

	@StreamListener(Sink.INPUT)
	public void orderDispatch(List<Product> products) {
		products.forEach(product ->
				logger.info("Order Dispatched to your mailing address {} ", product)
		);
	}
	public static void main(String[] args) {
		SpringApplication.run(CourierServiceApplication.class, args);
	}

}
