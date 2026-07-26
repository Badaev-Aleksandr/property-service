package com.badaev.realestate.property.controller;

import com.badaev.realestate.property.dto.CreatePropertyRequest;
import com.badaev.realestate.property.dto.PropertyResponse;
import com.badaev.realestate.property.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping("/create")
    public ResponseEntity<PropertyResponse> createProperty(@RequestBody CreatePropertyRequest request) {
        PropertyResponse response = propertyService.createProperty(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
