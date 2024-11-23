package com.devesuperior.desafio_componente_injecao_dependencia;

import com.devesuperior.desafio_componente_injecao_dependencia.model.Order;
import com.devesuperior.desafio_componente_injecao_dependencia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.devesuperior.desafio_componente_injecao_dependencia"})
public class DesafioComponenteInjecaoDependenciaApplication implements CommandLineRunner {


	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioComponenteInjecaoDependenciaApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe o código do pedido:");
		int code = scanner.nextInt();

		System.out.println("Informe o valor básico:");
		double basic = scanner.nextDouble();

		System.out.println("Informe a porcentagem de desconto:");
		double discount = scanner.nextDouble();

		Order order = new Order(code, basic, discount);
		double total = orderService.total(order);

		System.out.printf("Pedido código: %d\nValor total: R$ %.2f\n", order.getCode(), total);
	}


}


