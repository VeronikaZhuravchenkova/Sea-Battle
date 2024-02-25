package com.veronika;

import java.util.ArrayList;
import java.util.List;

public class Hale {

    private final List<Coordinate> coordinates = new ArrayList<>();

    public Hale(int x, int y) {
        coordinates.add(new Coordinate(x - 1, y + 1));
        coordinates.add(new Coordinate(x, y + 1));
        coordinates.add(new Coordinate(x + 1, y + 1));
        coordinates.add(new Coordinate(x - 1, y));
        coordinates.add(new Coordinate(x + 1, y));
        coordinates.add(new Coordinate(x - 1, y - 1));
        coordinates.add(new Coordinate(x, y - 1));
        coordinates.add(new Coordinate(x + 1, y - 1));
    }

    public boolean hasCommonCoordinates(List<Ship.Deck> decks) {
        for (Coordinate coordinate: this.getCoordinates()) {
            for(Ship.Deck deck : decks)
            if(coordinate.getX() == deck.getCoordinate().getX() && coordinate.getY() == deck.getCoordinate().getY()) {
                return true;
            }
        }
        return false;
    }


    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

}
