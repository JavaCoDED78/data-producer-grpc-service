package com.javaded.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javaded.model.Data;

import java.time.LocalDateTime;

public record DataDto(
        Long sensorId,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime timestamp,

        double measurement,
        Data.MeasurementType measurementType
) {

}
