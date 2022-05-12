package com.sb.test.reactive.service;

import com.sb.test.reactive.models.Stock;

public interface EventListener {
	 void onData(Stock stock);
	    void processComplete();
}
