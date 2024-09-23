package com.moacyr_soares.challenge_components_and_dependency_injection;

import com.moacyr_soares.challenge_components_and_dependency_injection.model.Order;
import com.moacyr_soares.challenge_components_and_dependency_injection.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.moacyr_soares.challenge_components_and_dependency_injection"})
public class ChallengeComponentsAndDependencyInjectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeComponentsAndDependencyInjectionApplication.class, args);
	}

	private OrderService orderService;

	public ChallengeComponentsAndDependencyInjectionApplication(OrderService orderService){

		this.orderService = orderService;
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		Integer code = sc.nextInt();
		Double basicValue = sc.nextDouble();
		Double discount = sc.nextDouble();

		Order order = new Order(code, basicValue, discount);

		double totalValue = orderService.total(order);

		System.out.println("Pedido código " + order.getCode());

		System.out.printf("Valor total: R$ %.2f%n", totalValue);

		sc.close();	
	}
}
