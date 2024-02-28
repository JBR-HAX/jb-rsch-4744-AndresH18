package org.jetbrains.assignment.controller;

import org.jetbrains.assignment.data.Location;
import org.jetbrains.assignment.data.Move;
import org.jetbrains.assignment.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationsController {

    private final LocationService service;

    @Autowired
    public LocationsController(LocationService service) {
        this.service = service;
    }


    @PostMapping
    public List<Location> post(List<Move> moves) {
        return service.getLocations(moves);
    }
}
