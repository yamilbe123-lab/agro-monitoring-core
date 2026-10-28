package com.agromonitoring.agro_monitoring_core.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TelemetryRequest {

    @NotBlank(message = "El identificador de estación es obligatorio")
    private String stationId;

    @NotNull(message = "La temperatura no puede ser nula")
    private Double temperature;

    @NotNull(message = "La humedad no puede ser nula")
    private Double humidity;

    @NotNull(message = "La humedad del suelo no puede ser nula")
    private Double soilMoisture;
}
