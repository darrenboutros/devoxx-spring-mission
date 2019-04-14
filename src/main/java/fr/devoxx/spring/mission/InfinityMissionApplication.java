package fr.devoxx.spring.mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import fr.devoxx.spring.mission.utils.RestTemplateResponseErrorHandler;

@SpringBootApplication
public class InfinityMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinityMissionApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}
}
