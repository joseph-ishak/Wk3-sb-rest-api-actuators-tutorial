package com.choicehotels.dap.controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.choicehotels.dap.config.ProfileMetricsConfiguration;
import com.choicehotels.dap.dto.ProfileDTO;
import com.choicehotels.dap.repositories.ProfileRepository;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Timer;
import lombok.SneakyThrows;

@RestController
public class MetricsController {

	private final ProfileRepository profileRepository;
	
	MetricsController(ProfileRepository profileRepository){
		this.profileRepository = profileRepository;
	}
	
	@Autowired
	@Qualifier("createdProfilesCounter")
	Counter createdProfilesCounter;
	
	@Autowired
	@Qualifier("ageDistributionSummary")
	DistributionSummary ageDistributionSummary;
	
	@Autowired
	@Qualifier("createdProfileTimer")
	Timer createdProfileTimer;
	
	
	
	
	@GetMapping("/api/profile-with-counter")
	@SneakyThrows
	public ProfileDTO createWithCounter() {
		createdProfilesCounter.increment();
	    return profileRepository.save(new ProfileDTO("Joseph","SE1"));
	}
	
	@GetMapping("/api/profile-with-timer")
	@SneakyThrows
	public ProfileDTO createWithTimer() {
	    return createdProfileTimer.recordCallable(() -> profileRepository.save(new ProfileDTO("John Wick" , "SE2")));
	}
	
	
	@GetMapping("/api/profile-with-distribution-timer")
	@SneakyThrows
	public void createWithDistSummary() {
		ageDistributionSummary.record(100);
	}
	
	
}
