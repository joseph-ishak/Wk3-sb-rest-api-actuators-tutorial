package com.choicehotels.dap.config;

import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.choicehotels.dap.repositories.ProfileRepository;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@Configuration
public class HttpTracingConfiguration {
	
    
	@Bean
	public InMemoryHttpTraceRepository httpTraceRepository() {
	    return new InMemoryHttpTraceRepository();
	}
}