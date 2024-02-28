package org.jetbrains.assignment.services;

import org.jetbrains.assignment.data.DbEntry;
import org.jetbrains.assignment.data.EntryRepository;
import org.jetbrains.assignment.data.Location;
import org.jetbrains.assignment.data.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    private final EntryRepository repo;

    @Autowired
    public LocationService(EntryRepository repo) {
        this.repo = repo;
    }

    public List<Location> getLocations(List<Move> moves) {
        var locations = new ArrayList<Location>();
        int x = 0, y = 0;

        for (Move move : moves) {
            switch (move.getDirection()) {
                case NORTH:
                    y += move.getValue();
                    break;
                case SOUTH:
                    y -= move.getValue();
                    break;
                case EAST:
                    x += move.getValue();
                    break;
                case WEST:
                    x -= move.getValue();
                    break;
            }

            locations.add(new Location(x, y));
        }

        repo.save(new DbEntry(moves, locations));

        return locations;
    }
}
