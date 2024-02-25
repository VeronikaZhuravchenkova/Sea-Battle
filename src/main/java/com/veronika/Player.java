package com.veronika;

import com.veronika.exceptions.ParamException;

import java.util.List;
import java.util.Scanner;

public class Player {

    private final String name;

    private final Field field;

    private final Field opponentsField;
    Scanner scanner = new Scanner(System.in);

    public Player(String name, Field field, Field opponentsField) {
        if (name.isBlank()) {
            throw new ParamException("Имя игрока не может быть пустым");
        }
        this.name = name;
        this.field = field;
        this.opponentsField = opponentsField;
    }


    public boolean hasLivingShips() {
        List<Ship> ships = field.getShips();
        for (Ship ship : ships) {
            for (Ship.Deck deck : ship.getDecks()) {
                if (deck.isAlive()) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }


    public boolean makeShot(String line, Field opponentsField) {
        String[] shotCoordinates = line.split(",");
        int x = Integer.parseInt(shotCoordinates[0]);
        int y = Integer.parseInt(shotCoordinates[1]);
        List<Ship> ships = opponentsField.getShips();
        for (Ship ship : ships) {
            boolean injured = ship.checkCoordinate(x, y);
            if (injured) {
                if (!ship.isAlive()) {
                    System.out.println("Утонул!");

                } else {
                    System.out.println("Попал!");
                }
                opponentsField.updateField();
                return true;
            }
        }
        System.out.println("Промах!");
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public Field getOpponentsField() {
        return opponentsField;
    }
}


