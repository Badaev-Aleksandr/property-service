package com.badaev.realestate.property.service;

import com.badaev.realestate.property.dto.CreatePropertyRequest;
import com.badaev.realestate.property.dto.PropertyResponse;
import com.badaev.realestate.property.entity.Property;
import com.badaev.realestate.property.repositories.PropertyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Transactional
    public PropertyResponse createProperty(CreatePropertyRequest request) {
        Property property = new Property(
                request.title(),
                request.description(),
                request.price(),
                request.city(),
                request.address()
        );

        Property savedProperty = propertyRepository.save(property);

        return new PropertyResponse(
                savedProperty.getId(),
                savedProperty.getTitle(),
                savedProperty.getDescription(),
                savedProperty.getPrice(),
                savedProperty.getCity(),
                savedProperty.getAddress(),
                savedProperty.getCreatedAt(),
                savedProperty.getUpdatedAt()
        );
    }
}
