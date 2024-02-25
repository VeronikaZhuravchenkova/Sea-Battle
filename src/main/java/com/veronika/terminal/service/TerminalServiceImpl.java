package com.veronika.terminal.service;

import com.veronika.Coordinate;
import com.veronika.terminal.Terminal;
import com.veronika.terminal.model.CoordinateResult;
import com.veronika.utils.CoordinateUtil;

import java.util.List;


public class TerminalServiceImpl implements TerminalService {

    private final Terminal terminal;

    public TerminalServiceImpl(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public void sendMessage(String message) {terminal.sendMessage(message);}

    @Override
    public String getFirstPlayerName() {
        return terminal.getMessage();
    }

    @Override
    public String getSecondPlayerName() {
        return terminal.getMessage();
    }

    @Override
    public String getShotCoordinates() {return terminal.getMessage();}

    @Override
    public void sendMessageStartShipDeploymentForFirstPlayer(String firstPlayerName) {
        System.out.println("Начнем расставлять корабли на поле " + firstPlayerName + ". Другой игорок, не смотри.");
    }

    @Override
    public void sendMessageStartShipDeploymentForSecondPlayer(String secondPlayerName) {
        System.out.println((secondPlayerName + " ,расставляй корабли!"));

    }

    @Override
    public CoordinateResult getCoordinateForFourDeckShip() {
        try {
            List<Coordinate> coordinates = CoordinateUtil.parseFourCoordinate(terminal.getMessage());
            return CoordinateResult.createSuccess(coordinates);
        } catch (Exception e) {
            return CoordinateResult.createError();
        }
    }

    @Override
    public CoordinateResult getCoordinateForThreeDeckShip() {
        try {
            List<Coordinate> coordinates = CoordinateUtil.parseThreeCoordinates(terminal.getMessage());
            return CoordinateResult.createSuccess(coordinates);
        }catch (Exception e) {
            return CoordinateResult.createError();
        }
    }

    @Override
    public CoordinateResult getCoordinateForTwoDeckShip() {
        try {
            List<Coordinate> coordinates = CoordinateUtil.parseTwoCoordinates(terminal.getMessage());
            return CoordinateResult.createSuccess(coordinates);
        }catch (Exception e) {
            return CoordinateResult.createError();
        }
    }

    @Override
    public CoordinateResult getCoordinateForOneDeckShip() {
        try {
            List<Coordinate> coordinates = CoordinateUtil.parseOneCoordinate(terminal.getMessage());
            return CoordinateResult.createSuccess(coordinates);
        }catch (Exception e) {
            return CoordinateResult.createError();
        }
    }


}
