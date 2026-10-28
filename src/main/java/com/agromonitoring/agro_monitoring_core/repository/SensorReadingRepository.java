package com.agromonitoring.agro_monitoring_core.repository;

import com.agromonitoring.agro_monitoring_core.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {
    List<SensorReading> findTop10ByStationIdOrderByTimestampDesc(String stationId);
}