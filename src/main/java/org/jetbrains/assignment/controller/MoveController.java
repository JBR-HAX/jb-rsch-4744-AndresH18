package org.jetbrains.assignment.controller;

import org.jetbrains.assignment.data.Location;
import org.jetbrains.assignment.data.Move;
import org.jetbrains.assignment.services.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("moves")
public class MoveController {
    private final MoveService service;

    @Autowired
    public MoveController(MoveService service) {
        this.service = service;
    }

    @PostMapping
    public List<Move> post(List<Location> locations) {
        return service.getLocations(locations);
    }
}
