package com.choicehotels.dap.indicators;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.support.*;

import org.springframework.context.annotation.*;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GithubAPIHealthIndicator implements HealthIndicator{
	

	private final RestTemplate restTemplate;

	 @Override
	    public Health health() {
	        try {
	            ParameterizedTypeReference<Map<String, String>> reference = new ParameterizedTypeReference<Map<String, String>> () {};
	            ResponseEntity<Map<String, String>> result = restTemplate.exchange("https://api.github.com/", HttpMethod.GET, null, reference);
	            if (result.getStatusCode().is2xxSuccessful() && result.getBody() != null) {
	                return Health.up().withDetails(result.getBody()).build();
	            } else {
	                return Health.down().withDetail("status", result.getStatusCode()).build();
	            }
	        } catch (RestClientException ex) {
	            return Health.down().withException(ex).build();
	        }
	    }
	 
	
}
