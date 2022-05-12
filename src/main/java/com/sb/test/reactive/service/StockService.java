package com.sb.test.reactive.service;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sb.test.reactive.models.Stock;
import com.sb.test.reactive.repositary.StockRepositary;

import reactor.core.publisher.Flux;

@Service
public class StockService {
	
	private EventListener eventListener;
	Random r = new Random();
	@Autowired
	private StockRepositary stockRepositary;
	
	public void registerEventListener(EventListener eventListener) {
		this.eventListener = eventListener;
	}
	
	@KafkaListener(topics = "user", groupId = "user-group")
	public void listenGroupFoo(Stock stock) {
		this.pushlishStock(stock);
	}
	
	public void pushlishStock(Stock stock) {
		if(eventListener != null) {
			eventListener.onData(stock);
		}
	}
	
	public void saveStockAndPublish(String name) {
		Stock stock = new Stock(null, name, new BigDecimal(r.nextInt()), r.nextFloat());
		stockRepositary.save(stock).subscribe(rs->{
			this.pushlishStock(rs);
		});
	}
	
	public Flux<Stock> getAllStocks(){
		return stockRepositary.findAll();
	}
}
