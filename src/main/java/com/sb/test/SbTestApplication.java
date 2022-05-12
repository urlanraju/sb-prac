package com.sb.test;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.test.reactive.models.Stock;
import com.sb.test.reactive.repositary.StockRepositary;

@SpringBootApplication
public class SbTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbTestApplication.class, args);
	}

	@Autowired
	private StockRepositary stockRepositary;

	@Override
	public void run(String args[]) {
		Random r = new Random();
		Stock stock = new Stock(null, "TATA", new BigDecimal(r.nextInt()), r.nextFloat());
		stockRepositary.save(stock);
	}

}