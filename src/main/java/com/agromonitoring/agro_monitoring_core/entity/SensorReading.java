package com.agromonitoring.agro_monitoring_core.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "sensor_readings", indexes = {
    @Index(name = "idx_sensor_station", columnList = "stationId, timestamp")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String stationId;

    @Column(nullable = false)
    private Double temperature;

    @Column(nullable = false)
    private Double humidity;

    @Column(nullable = false)
    private Double soilMoisture;

    @Column(nullable = false)
    private Instant timestamp;
}