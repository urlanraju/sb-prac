/**
 * 
 */
package com.sb.test.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.test.reactive.models.Stock;
import com.sb.test.reactive.service.EventListener;
import com.sb.test.reactive.service.StockService;

import reactor.core.publisher.Flux;

/**
 * @author Venkatesh_Urlana
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "reactive")
public class KafkaController {

	@Autowired
	private StockService stockService;

	private Flux<Stock> bridge = createBridge().publish().autoConnect().cache(10);
	
	@GetMapping(value = "/stocks")
	public Flux<Stock> getStocks() {
		return stockService.getAllStocks().concatWith(bridge).distinct(s->s.getId());
	}
	
	@GetMapping("/add-stock/{stockName}")
	public String addStock(@PathVariable("stockName") String stockName) {
		stockService.saveStockAndPublish(stockName);
		return "Stock sent.";
	}
	
	private Flux<Stock> createBridge() {
        Flux<Stock> bridge = Flux.create(sink -> { // (2)
        	stockService.registerEventListener(new EventListener() {

                 @Override
                 public void processComplete() {
                     sink.complete();
                 }

                 @Override
                 public void onData(Stock data) {
                     sink.next(data);
                 }
              });
        });
        return bridge;
   }
}
