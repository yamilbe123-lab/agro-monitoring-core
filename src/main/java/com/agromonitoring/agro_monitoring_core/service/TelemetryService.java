package com.agromonitoring.agro_monitoring_core.service;

import com.agromonitoring.agro_monitoring_core.DTO.TelemetryRequest;
import com.agromonitoring.agro_monitoring_core.entity.SensorReading;
import com.agromonitoring.agro_monitoring_core.repository.SensorReadingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TelemetryService {

    private final SensorReadingRepository repository;

    @Transactional
    public SensorReading recordTelemetry(TelemetryRequest req) {
        SensorReading reading = SensorReading.builder()
                .stationId(req.getStationId())
                .temperature(req.getTemperature())
                .humidity(req.getHumidity())
                .soilMoisture(req.getSoilMoisture())
                .timestamp(Instant.now())
                .build();
        return repository.save(reading);
    }

    @Transactional(readOnly = true)
    public List<SensorReading> getRecentMetrics(String stationId) {
        return repository.findTop10ByStationIdOrderByTimestampDesc(stationId);
    }
}