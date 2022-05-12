package com.sb.test.reactive.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Stock {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name;

	private BigDecimal price;

	private Float offset;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Float getOffset() {
		return offset;
	}

	public void setOffset(Float offset) {
		this.offset = offset;
	}

	public Stock(String userId, String name, BigDecimal price, Float offset) {
		super();
		this.id = userId;
		this.name = name;
		this.price = price;
		this.offset = offset;
	}

	public Stock() {
		super();
	}

}
