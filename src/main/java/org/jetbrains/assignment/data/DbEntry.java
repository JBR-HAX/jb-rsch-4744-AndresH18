package org.jetbrains.assignment.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class DbEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String moves;
    private String locations;

    public DbEntry(List<Move> moves, List<Location> locations) {
        var mBuilder = new StringBuilder();
        moves.forEach(m -> mBuilder.append("{\"direction\":\"").append(m.getDirection().toString()).append("\",\"steps\":").append(m.getValue()).append(","));
        this.moves = "[" + mBuilder.toString() + "]";

        var lBuilder = new StringBuilder();
        locations.forEach(l -> lBuilder.append("{\"x\":").append(l.getX()).append(",\"y\":").append(l.getY()).append("}"));

        this.locations = "[" + lBuilder.toString() + "]";

    }

    public DbEntry() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }
}

