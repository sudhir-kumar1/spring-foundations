package com.poc.chap1.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.poc.chap1.common.data.repository.CustomerRepository;
import com.poc.chap1.common.data.repository.InventoryItemRepository;
import com.poc.chap1.common.data.repository.SalesOrderRepository;
import com.poc.chap1.common.service.InventoryService;
import com.poc.chap1.common.service.OrderService;
import com.poc.chap1.common.service.impl.InventoryServiceImpl;
import com.poc.chap1.common.service.impl.OrderServiceImpl;

@Configuration
@Import(DataConfig.class)
@PropertySource("classpath:/application.properties")
public class AppConfig {

	@Value("${greeting.text}")
	private String greetingText;
	
	public class Worker{
		private String preamble;
		private String text;
		
		public Worker(String preamble, String text){
			this.preamble = preamble;
			this.text = text;
		}
		
		public void execute(){
			System.out.println(preamble + " " + text);
		}
	}
	
	@Bean
	@Profile("dev")
	public Worker workerForDev(){
		return new Worker("Hello", greetingText);
	}
	
	@Bean
	@Profile("prod")
	public Worker workerForProd(){
		return new Worker("Greetings", greetingText);
	}
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SalesOrderRepository salesOrderRepository;

	@Autowired
	private InventoryItemRepository inventoryItemRepository;

	@Bean
	public OrderService orderService(InventoryService inventoryService, CustomerRepository customerRepository,
			SalesOrderRepository salesOrderRepository) {
		return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
	}

	@Bean
	public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository) {
		return new InventoryServiceImpl(inventoryItemRepository);
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService orderService = context.getBean(OrderService.class);
		System.out.println(orderService == null ? "NULL" : "A OK");
		
		Worker worker = context.getBean(Worker.class);
		worker.execute();
	}
}
