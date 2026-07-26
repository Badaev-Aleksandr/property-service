package com.badaev.realestate.property.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity
@Table(name = "properties")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Setter
    @Column(nullable = false, length = 200)
    private String title;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String description;

    @Setter
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Setter
    @Column(nullable = false, length = 100)
    private String city;

    @Setter
    @Column(nullable = false, length = 200)
    private String address;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @PrePersist
    void beforeInsert() {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    void afterInsert() {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
