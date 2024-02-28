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
public class MoveService {
    private final EntryRepository repo;

    @Autowired
    public MoveService(EntryRepository repo) {
        this.repo = repo;
    }


    public List<Move> getLocations(List<Location> locations) {
        var moves = new ArrayList<Move>();

        var iter = locations.iterator();
        var location = iter.next();
        int x = location.getX(), y = location.getY();

        while ((location = iter.next()) != null) {
            if (location.getX() != x) {
                if (location.getX() > x) {
                    moves.add(new Move(Move.Direction.EAST, location.getX() - x));
                } else {
                    moves.add(new Move(Move.Direction.WEST, x - location.getX()));
                }

                x = location.getX();
            } else {
                // y

                if (location.getY() > y) {
                    moves.add(new Move(Move.Direction.NORTH, location.getY() - y));
                } else {
                    moves.add(new Move(Move.Direction.SOUTH, y - location.getY()));
                }
                y = location.getY();
            }
        }

        repo.save(new DbEntry(moves, locations));

        return moves;

    }
}
