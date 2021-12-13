package com.example.gemfirebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.geode.config.annotation.EnableClusterAware;

@EnableCachingDefinedRegions
@EnableClusterAware
@SpringBootApplication
public class GemfireBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(GemfireBackendApplication.class, args);
	}

}
