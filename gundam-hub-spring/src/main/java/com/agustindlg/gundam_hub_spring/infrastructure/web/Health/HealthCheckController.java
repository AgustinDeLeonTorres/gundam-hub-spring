package com.agustindlg.gundam_hub_spring.infrastructure.web.Health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1. This marks the class as a REST API controller
public class HealthCheckController {

    @GetMapping("/health") // 2. This maps HTTP GET requests to this method
    public String healthCheck() {
        return "OK Lao Bi! Gundam Hub API is up and running!"; // 3. The response body
    }
}