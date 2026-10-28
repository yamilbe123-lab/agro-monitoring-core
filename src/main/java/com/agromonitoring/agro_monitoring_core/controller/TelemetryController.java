package com.agromonitoring.agro_monitoring_core.controller;

import com.agromonitoring.agro_monitoring_core.DTO.TelemetryRequest;
import com.agromonitoring.agro_monitoring_core.entity.SensorReading;
import com.agromonitoring.agro_monitoring_core.service.TelemetryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/telemetry")
@RequiredArgsConstructor
public class TelemetryController {

    private final TelemetryService service;

    @PostMapping
    public ResponseEntity<SensorReading> ingestTelemetry(@Valid @RequestBody TelemetryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.recordTelemetry(request));
    }

    @GetMapping("/{stationId}/recent")
    public ResponseEntity<List<SensorReading>> getRecent(@PathVariable String stationId) {
        return ResponseEntity.ok(service.getRecentMetrics(stationId));
    }
}
