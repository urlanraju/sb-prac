/**
 * 
 */
package com.sb.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author Venkatesh_Urlana
 *
 */
@Configuration
public class CorsConfig implements WebFluxConfigurer {
	 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowedOrigins("*");
    }
}