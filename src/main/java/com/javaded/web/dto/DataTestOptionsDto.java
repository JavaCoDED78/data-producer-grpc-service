package com.javaded.web.dto;

import com.javaded.model.Data;

public record DataTestOptionsDto(
        int delayInSeconds,
        Data.MeasurementType[] measurementTypes
) {
}
