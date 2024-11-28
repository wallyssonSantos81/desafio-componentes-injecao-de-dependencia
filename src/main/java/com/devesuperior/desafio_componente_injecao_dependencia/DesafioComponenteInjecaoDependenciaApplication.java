package com.devesuperior.desafio_componente_injecao_dependencia;

import com.devesuperior.desafio_componente_injecao_dependencia.model.Order;
import com.devesuperior.desafio_componente_injecao_dependencia.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.devesuperior.desafio_componente_injecao_dependencia"})
public class DesafioComponenteInjecaoDependenciaApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DesafioComponenteInjecaoDependenciaApplication.class);

    private final OrderService orderService;

    public DesafioComponenteInjecaoDependenciaApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioComponenteInjecaoDependenciaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("====================================");
            System.out.println("       Sistema de Pedidos");
            System.out.println("====================================");

            System.out.print("Informe o código do pedido: ");
            int code = scanner.nextInt();

            System.out.print("Informe o valor básico: ");
            double basic = scanner.nextDouble();

            System.out.print("Informe a porcentagem de desconto: ");
            double discount = scanner.nextDouble();

            Order order = new Order(code, basic, discount);
            double total = orderService.total(order);

            System.out.println("\n====================================");
            System.out.println("          Resumo do Pedido");
            System.out.println("====================================");
            System.out.printf("Pedido Código: %d%n", order.getCode());
            System.out.printf("Valor Total: R$ %.2f%n", total);
            System.out.println("====================================");

        } catch (Exception e) {
            logger.error("Erro ao processar o pedido: ", e);
            System.out.println("Ocorreu um erro ao processar o pedido. Verifique os dados e tente novamente.");
        }
    }
}
