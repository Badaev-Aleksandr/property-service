package com.badaev.realestate.property.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PropertyResponse(
        UUID id,
        String title,
        String description,
        BigDecimal price,
        String city,
        String address,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
