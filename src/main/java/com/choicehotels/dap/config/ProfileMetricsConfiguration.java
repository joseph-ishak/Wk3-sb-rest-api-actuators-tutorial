package com.choicehotels.dap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.choicehotels.dap.repositories.ProfileRepository;

import ch.qos.logback.core.util.Duration;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@Configuration
public class ProfileMetricsConfiguration {
	
    @Bean
    public Counter createdProfilesCounter(MeterRegistry registry) {
        return Counter
            .builder("api.profiles.created")
            .description("Amount of profiles created")
            .register(registry);
    }
    
    @Bean
    public Gauge countProfilesGauge(MeterRegistry registry, ProfileRepository profileRepository) {
        return Gauge
            .builder("api.profiles.count", profileRepository::count)
            .description("Amount of existing profiles")
            .register(registry);
    }
    
    
    @Bean
    public Timer createdProfileTimer(MeterRegistry registry) {
        return Timer
            .builder("api.profiles.created.time")
            .description("Time taken to create a profile")
            .register(registry);
    }
    
    @Bean
    public Timer createdProfilesTimerWithSLAAndPercentiles(MeterRegistry registry) {
        return Timer
                .builder("api.profiles.created.time")
                .description("Time taken to create a profile")
                .sla(java.time.Duration.ofMillis(10))
                .minimumExpectedValue(java.time.Duration.ofMillis(1))
                .maximumExpectedValue(java.time.Duration.ofSeconds(2))
                .publishPercentiles(0.5, 0.95)
                .publishPercentileHistogram()
                .register(registry);
    }
    
    @Bean
    public DistributionSummary ageDistributionSummary(MeterRegistry registry) {
        return DistributionSummary
            .builder("api.profiles.age")
            .description("Age of created profiles")
            .sla(20, 50, 100)
            .distributionStatisticExpiry(java.time.Duration.ofMinutes(5)) // Add this
            .distributionStatisticBufferLength(100) // Add this
            .register(registry);
    }
    
}
