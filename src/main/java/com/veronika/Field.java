package com.veronika;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private final String[][] field;

    private final List<Ship> ships = new ArrayList<>(10);

    private Field(String[][] field) {
        this.field = field;
    }

    public static Field createField() {
        String[][] field = new String[11][11];
        field[0][0] = "    ";
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i == 0) {
                    field[0][j] = j + "   ";
                } else if (j == 0) {
                    field[i][0] = i + "   ";
                } else {
                    field[i][j] = "[ ] ";
                }
            }
        }
        return new Field(field);
    }


    public void showField() {
        for (String[] strings : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println(" ");
        }

    }

    public boolean addShip(Ship ship) {
//        List<Hale> halesCompered = ships.stream().flatMap(s -> s.getDecks().stream()).map(Ship.Deck::getHale).toList();
//        List<Hale> halesComparable = ship.getDecks().stream().map(Ship.Deck::getHale).toList();
//        for (Hale comparableHale : halesComparable) {
//            if (halesCompered.contains(comparableHale)) {
//                System.out.println("У каждого корабля должен быть ореол в одну клетку");
//                break;
//            }
//        }
            if (checkFreePlace(ship)) {
                System.out.println("Корабль с такими координатами уже существует");
                return false;
            } else if (checkShipHale(ship)) {
                System.out.println("У каждого корабля должен быть свой ореол");
               return false;
            } else {
                for (Ship.Deck deck : ship.getDecks()) {
                    field[deck.getCoordinate().getX()][deck.getCoordinate().getY()] = " #  ";
                }
                ships.add(ship);
                return true;
            }
    }



    public void updateField() {
        for (Ship ship : ships) {
            for (Ship.Deck deck : ship.getDecks()) {
                if (!deck.isAlive()) {
                    field[deck.getCoordinate().getX()][deck.getCoordinate().getY()] = " *  ";
                }
            }
        }
    }

    public String[][] getField() {
        return field;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public boolean checkShipHale(Ship ship) {
        for (Ship fieldShip : ships) {
            for (Ship.Deck fieldDeck : fieldShip.getDecks()) {
                Hale hale = fieldDeck.getHale();
                    if (hale.hasCommonCoordinates(ship.getDecks())) {
                        return true;
                    }
                }
        }
        return false;
    }

    public boolean checkFreePlace(Ship ship) {
        for(Ship.Deck deck : ship.getDecks()) {
            if(field[deck.getCoordinate().getX()][deck.getCoordinate().getY()].equals(" #  ")) {
                return true;
            }
        }
        return false;
    }


}


