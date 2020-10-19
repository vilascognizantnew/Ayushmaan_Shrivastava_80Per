package com.stock;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stock.dao.StockDAO;
import com.stock.model.Stock;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(final StockDAO repository) {

		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return args -> {
			repository.save(new Stock(1, "Reliance", 100, 5, format.parse("2020-01-01")));
			repository.save(new Stock(2, "Infosys", 120,2, format.parse("2020-02-01")));
			repository.save(new Stock(3, "Adani", 80, 2, format.parse("2020-04-01")));
			repository.save(new Stock(4, "Cognizant", 9, 1000, format.parse("2019-04-01")));
			repository.save(new Stock(5, "TCS", 140, 10, format.parse("2018-04-01")));
			repository.save(new Stock(6, "Wipro", 80, 1, format.parse("2017-01-01")));
		};
	}

}
