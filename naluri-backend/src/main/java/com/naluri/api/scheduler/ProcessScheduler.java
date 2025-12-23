package com.naluri.api.scheduler;

import com.naluri.api.service.PiCalculationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProcessScheduler {

    private final PiCalculationService service;

    public ProcessScheduler(PiCalculationService service) {
        this.service = service;
    }

    @Scheduled(fixedDelay = 1000)
    public void processCalculationContinuously() {
        service.calculateNextPi();
    }

}
