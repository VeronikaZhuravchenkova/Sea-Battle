package com.veronika.terminal.model;

import com.veronika.Coordinate;
import com.veronika.exceptions.ParamException;

import java.util.List;

public class CoordinateResult {

    private final boolean success;

    private final List<Coordinate> coordinates;

    private CoordinateResult(boolean success, List<Coordinate> coordinates) {
        this.success = success;
        this.coordinates = coordinates;
    }

    public static CoordinateResult createSuccess(List<Coordinate> coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            throw new ParamException("Координаты не могут быть пустыми");
        }
        return new CoordinateResult(true, coordinates);
    }

    public static CoordinateResult createError() {
        return new CoordinateResult(false, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }


}
