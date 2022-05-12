package com.sb.test.reactive.repositary;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.test.reactive.models.Stock;

@Repository
public interface StockRepositary extends ReactiveCrudRepository<Stock, String> {

}
