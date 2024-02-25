package com.veronika;

import java.util.LinkedList;
import java.util.List;

public class Ship {

    private final List<Deck> decks;


    private Ship(List<Deck> decks) {
        this.decks = decks;
    }


//    public static Ship createShip(int x, int y) {
//        List<Deck> decks = new LinkedList<>();
//        decks.add(new Deck(x, y));
//        return new Ship(decks);
//    }

    public static Ship createShip(List<Coordinate> coordinates) {
        List<Deck> decks = new LinkedList<>();
        for (Coordinate coordinate : coordinates) {
            decks.add(new Deck(coordinate));
        }
        return new Ship(decks);
    }

//    public Ship addDeck(int x, int y) {
//
//        decks.add(new Deck(x, y));
//        return this;
//    }

    public boolean checkCoordinate(int x, int y) {
        for (Deck deck : decks) {
            if (deck.getCoordinate().getX() == x && deck.getCoordinate().getY() == y) {
                deck.setAlive(false);
                return true;
            }
        }
        return false;
    }


    public static class Deck {
        private final Coordinate coordinate;
        private boolean isAlive;

        private final Hale hale;



        public Deck(Coordinate coordinate) {
            this.coordinate = coordinate;
            isAlive = true;
            this.hale = new Hale(coordinate.getX(), coordinate.getY());
        }

        public Coordinate getCoordinate() {
            return coordinate;
        }

        public boolean isAlive() {
            return isAlive;
        }

        public void setAlive(boolean alive) {
            isAlive = alive;
        }

        public Hale getHale() {
            return hale;
        }

    }


    public boolean isAlive() {
        for (Ship.Deck deck : decks) {
            if (deck.isAlive) {
                return true;
            }
        }
        return false;
    }

    public List<Deck> getDecks() {
        return decks;
    }



}


