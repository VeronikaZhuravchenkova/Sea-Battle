package com.veronika.utils;

import com.veronika.Coordinate;
import com.veronika.exceptions.ParseCoordinateException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CoordinateUtil {

    private CoordinateUtil() {

    }

    public static List<Coordinate> parseFourCoordinate(String line) throws Exception {
        Pattern pattern = Pattern.compile("\\d+,\\d+(;\\d+,\\d+)*");
        Matcher matcher = pattern.matcher(line);
        String[] coordinatesFourDeckShip = line.split(";");
        if (!matcher.matches() || coordinatesFourDeckShip.length != 4) {
            throw new ParseCoordinateException();
        }
        String[] coordinatesFirstDeck4 = coordinatesFourDeckShip[0].split(",");
        String[] coordinatesSecondDeck4 = coordinatesFourDeckShip[1].split(",");
        String[] coordinatesThirdDeck4 = coordinatesFourDeckShip[2].split(",");
        String[] coordinatesFourthDeck4 = coordinatesFourDeckShip[3].split(",");

        int x1 = Integer.parseInt(coordinatesFirstDeck4[0]);
        int y1 = Integer.parseInt(coordinatesFirstDeck4[1]);
        int x2 = Integer.parseInt(coordinatesSecondDeck4[0]);
        int y2 = Integer.parseInt(coordinatesSecondDeck4[1]);
        int x3 = Integer.parseInt(coordinatesThirdDeck4[0]);
        int y3 = Integer.parseInt(coordinatesThirdDeck4[1]);
        int x4 = Integer.parseInt(coordinatesFourthDeck4[0]);
        int y4 = Integer.parseInt(coordinatesFourthDeck4[1]);

        return List.of(
                new Coordinate(x1, y1),
                new Coordinate(x2, y2),
                new Coordinate(x3, y3),
                new Coordinate(x4, y4));
    }

    public static List<Coordinate> parseThreeCoordinates(String line) throws ParseCoordinateException {
        Pattern pattern = Pattern.compile("\\d+,\\d+(;\\d+,\\d+)*");
        Matcher matcher = pattern.matcher(line);
        String[] coordinatesThreeDeckShip = line.split(";");
        if (!matcher.matches() || coordinatesThreeDeckShip.length != 3) {
            throw new ParseCoordinateException();
        }
        String[] coordinatesFirstDeck3 = coordinatesThreeDeckShip[0].split(",");
        String[] coordinatesSecondDeck3 = coordinatesThreeDeckShip[1].split(",");
        String[] coordinatesThirdDeck3 = coordinatesThreeDeckShip[2].split(",");

        int x1 = Integer.parseInt(coordinatesFirstDeck3[0]);
        int y1 = Integer.parseInt(coordinatesFirstDeck3[1]);
        int x2 = Integer.parseInt(coordinatesSecondDeck3[0]);
        int y2 = Integer.parseInt(coordinatesSecondDeck3[1]);
        int x3 = Integer.parseInt(coordinatesThirdDeck3[0]);
        int y3 = Integer.parseInt(coordinatesThirdDeck3[1]);

        return List.of(
                new Coordinate(x1, y1),
                new Coordinate(x2, y2),
                new Coordinate(x3, y3));
    }

    public static List<Coordinate> parseTwoCoordinates(String line) throws ParseCoordinateException {
        Pattern pattern = Pattern.compile("\\d+,\\d+(;\\d+,\\d+)*");
        Matcher matcher = pattern.matcher(line);
        String[] coordinatesTwoDeckShip = line.split(";");
        if (!matcher.matches() || coordinatesTwoDeckShip.length != 2) {
            throw new ParseCoordinateException();
        }
        String[] coordinatesFirstDeck2 = coordinatesTwoDeckShip[0].split(",");
        String[] coordinatesSecondDeck2 = coordinatesTwoDeckShip[1].split(",");

        int x1 = Integer.parseInt(coordinatesFirstDeck2[0]);
        int y1 = Integer.parseInt(coordinatesFirstDeck2[1]);
        int x2 = Integer.parseInt(coordinatesSecondDeck2[0]);
        int y2 = Integer.parseInt(coordinatesSecondDeck2[1]);

        return List.of(
                new Coordinate(x1, y1),
                new Coordinate(x2, y2));
    }

    public static List<Coordinate> parseOneCoordinate(String line) throws ParseCoordinateException {
        Pattern pattern = Pattern.compile("\\d+,\\d+");
        Matcher matcher = pattern.matcher(line);
        String[] coordinatesOneDeckShip = line.split(",");
        if (!matcher.matches() || coordinatesOneDeckShip.length != 2) {
            throw new ParseCoordinateException();
        }
        int x1 = Integer.parseInt(coordinatesOneDeckShip[0]);
        int y1 = Integer.parseInt(coordinatesOneDeckShip[1]);

        return List.of(new Coordinate(x1, y1));

    }
}
