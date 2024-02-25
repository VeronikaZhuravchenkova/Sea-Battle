package com.veronika.terminal.service;

import com.veronika.terminal.model.CoordinateResult;

public class TerminalServiceStub implements TerminalService {

    private String lastSendingMessage;
    private String firstPlayerName;
    private CoordinateResult coordinateForFourDeckShip;
    private CoordinateResult coordinateForThreeDeckShip;
    private CoordinateResult coordinateForTwoDeckShip;
    private CoordinateResult coordinateForOneDeckShip;

    @Override
    public void sendMessage(String message) {
        lastSendingMessage = message;
    }

    @Override
    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    @Override
    public String getSecondPlayerName() {
        return "Veronika";
    }

    @Override
    public String getShotCoordinates() {
        return null;
    }

    @Override
    public void sendMessageStartShipDeploymentForFirstPlayer(String firstPlayerName) {

    }

    @Override
    public void sendMessageStartShipDeploymentForSecondPlayer(String secondPlayerName) {

    }

    @Override
    public CoordinateResult getCoordinateForFourDeckShip() {
        return coordinateForFourDeckShip;
    }

    @Override
    public CoordinateResult getCoordinateForThreeDeckShip() {
       return coordinateForThreeDeckShip;
    }

    @Override
    public CoordinateResult getCoordinateForTwoDeckShip() {
        return coordinateForTwoDeckShip;
    }

    @Override
    public CoordinateResult getCoordinateForOneDeckShip() {
        return coordinateForOneDeckShip;
    }

    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    public void setCoordinateForFourDeckShip(CoordinateResult coordinateForFourDeckShip) {
        this.coordinateForFourDeckShip = coordinateForFourDeckShip;
    }
    public void setCoordinateForThreeDeckShip(CoordinateResult coordinateForThreeDeckShip) {
        this.coordinateForThreeDeckShip = coordinateForThreeDeckShip;
    }

    public void setCoordinateForTwoDeckShip(CoordinateResult coordinateForTwoDeckShip) {
        this.coordinateForTwoDeckShip = coordinateForTwoDeckShip;
    }

    public void setCoordinateForOneDeckShip(CoordinateResult coordinateForOneDeckShip) {
        this.coordinateForOneDeckShip = coordinateForOneDeckShip;
    }

    public String getLastSendingMessage() {
        return lastSendingMessage;
    }
}
