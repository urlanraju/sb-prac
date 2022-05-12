package com.sb.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.sb.test.reactive.repositary.StockRepositary;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = StockRepositary.class)
public class MongoConfig extends AbstractReactiveMongoConfiguration {

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create();
	}

	@Override
	protected String getDatabaseName() {
		return "mongo";
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(mongoClient(), getDatabaseName());
	}
}