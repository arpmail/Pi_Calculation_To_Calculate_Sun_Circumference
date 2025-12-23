package com.naluri.api.controller;

import com.naluri.api.model.PiState;
import com.naluri.api.service.PiCalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiController {

    private final PiCalculationService service;

    public PiController(PiCalculationService service) {
        this.service = service;
    }

    @GetMapping("/pi")
    public PiState getCurrentPiInformation() {
        return service.getOrInitializePiState();
    }
}
