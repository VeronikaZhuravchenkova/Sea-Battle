package com.veronika;

import com.veronika.terminal.model.CoordinateResult;
import com.veronika.terminal.service.TerminalService;

import java.util.Random;

public class Game {

    private final TerminalService terminalService;

    public Game(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    public void play() {

        Field field1 = Field.createField();
        Field field2 = Field.createField();

        terminalService.sendMessage("Игрок 1, представтесь!");
        String firstPlayerName = terminalService.getFirstPlayerName();
        while (firstPlayerName.isBlank()) {
            terminalService.sendMessage("Имя игрока не введено, введите имя игрока");
            firstPlayerName = terminalService.getFirstPlayerName();
        }
        Player player1 = new Player(firstPlayerName, field1, field2);

        terminalService.sendMessage("Игрок 2, представтесь!");
        String secondPlayerName = terminalService.getSecondPlayerName();
        Player player2 = new Player(secondPlayerName, field2, field1);

        terminalService.sendMessageStartShipDeploymentForFirstPlayer(player1.getName());
        field1.showField();

        terminalService.sendMessage("Введите координаты четырёхпалубного корабля (формат: x,y;x,y;x,y;x,y)");
        createFourDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты первого трёхпалубного корабля (формат:x,y;x,y;x,y)");
        createThreeDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты второго трёхпалубного корабля (формат:x,y;x,y;x,y)");
        createThreeDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты первого двухпалубного корабля (формат:x,y;x,y)");
        createTwoDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты второго двухпалубного корабля (формат:x,y;x,y)");
        createTwoDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты третьего двухпалубного корабля (формат:x,y;x,y)");
        createTwoDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты первого однопалубного корабля (формат:x,y)");
        createOneDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты второго однопалубного корабля (формат:x,y)");
        createOneDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты третьего однопалубного корабля (формат:x,y)");
        createOneDeckerShipAndAddToField(field1);

        terminalService.sendMessage("Введите координаты четвертого однопалубного корабля (формат:x,y)");
        createOneDeckerShipAndAddToField(field1);


        terminalService.sendMessageStartShipDeploymentForSecondPlayer(player2.getName());
        field2.showField();

        terminalService.sendMessage("Введите координаты четырёхпалубного корабля (формат: x,y;x,y;x,y;x,y)");
        createFourDeckerShipAndAddToField(field2);


        terminalService.sendMessage("Введите координаты первого трёхпалубного корабля (формат:x,y;x,y;x,y)");
        createThreeDeckerShipAndAddToField(field2);


        terminalService.sendMessage("Введите координаты второго трёхпалубного корабля (формат:x,y;x,y;x,y)");
        createThreeDeckerShipAndAddToField(field2);


        terminalService.sendMessage("Введите координаты первого двухпалубного корабля (формат:x,y;x,y)");
        createTwoDeckerShipAndAddToField(field2);


        terminalService.sendMessage("Введите координаты второго двухпалубного корабля (формат:x,y;x,y)");
        createTwoDeckerShipAndAddToField(field2);


        terminalService.sendMessage("Введите координаты третьего двухпалубного корабля (формат:x,y;x,y)");
        createTwoDeckerShipAndAddToField(field2);


        terminalService.sendMessage("Введите координаты первого однопалубного корабля (формат:x,y)");
        createOneDeckerShipAndAddToField(field2);

        terminalService.sendMessage("Введите координаты второго однопалубного корабля (формат:x,y)");
        createOneDeckerShipAndAddToField(field2);


        terminalService.sendMessage("Введите координаты третьего однопалубного корабля (формат:x,y)");
        createOneDeckerShipAndAddToField(field2);


        terminalService.sendMessage("Введите координаты четвертого однопалубного корабля (формат:x,y)");
        createOneDeckerShipAndAddToField(field2);


        Random random = new Random();

        Player[] players = new Player[]{player1, player2};
        int startingPlayerIdx = random.nextInt(players.length);
        Player currentPlayer = players[startingPlayerIdx];

        Player anotherPlayer;
        if (startingPlayerIdx == 0) {
            anotherPlayer = players[1];
        } else {
            anotherPlayer = players[0];
        }

        terminalService.sendMessage("Ходит первым: " + currentPlayer);

        while (player1.hasLivingShips() && player2.hasLivingShips()) {
            boolean shotResult = currentPlayer.makeShot(terminalService.getShotCoordinates(), currentPlayer.getOpponentsField());
            if (!shotResult) {
                Player tempPlayer = currentPlayer;
                currentPlayer = anotherPlayer;
                anotherPlayer = tempPlayer;

                terminalService.sendMessage("Переход хода игроку " + currentPlayer);
            }
        }
        terminalService.sendMessage("Победитель " + currentPlayer);
        field1.showField();
        terminalService.sendMessage(" ");
        field2.showField();

    }

    /**
     * Создать четырёхпалубный корабль и добавить на поле.
     *
     * @param field поле на которое добаляется корабль.
     */
    private void createFourDeckerShipAndAddToField(Field field) {
        CoordinateResult fourCoordinateResult = terminalService.getCoordinateForFourDeckShip();
        while (!fourCoordinateResult.isSuccess()) {
            terminalService.sendMessage("Координаты введены не верно, введите координаты еще раз.");
            fourCoordinateResult = terminalService.getCoordinateForFourDeckShip();
        }
        Ship ship = Ship.createShip(fourCoordinateResult.getCoordinates());
        boolean addShip = field.addShip(ship);
        if(!addShip) {
            createFourDeckerShipAndAddToField(field);
        }
        field.showField();
    }

    /**
     * Создать трехпалубный корабль и добавить на поле.
     *
     * @param field поле на которое добаляется корабль.
     */
    private void createThreeDeckerShipAndAddToField(Field field) {
        CoordinateResult threeCoordinateResult = terminalService.getCoordinateForThreeDeckShip();
        while ((!threeCoordinateResult.isSuccess())) {
            terminalService.sendMessage("Координаты введены не верно, введите координаты еще раз.");
            threeCoordinateResult = terminalService.getCoordinateForThreeDeckShip();
        }
        Ship threeDeckerShip = Ship.createShip(threeCoordinateResult.getCoordinates());
        boolean addShip = field.addShip(threeDeckerShip);
        if(!addShip) {
            createThreeDeckerShipAndAddToField(field);
        }
        field.showField();
    }

    /**
     * Создать двухпалубный корабль и добавить на поле.
     *
     * @param field поле на которое добавляется корабль.
     */
    private void createTwoDeckerShipAndAddToField(Field field) {
        CoordinateResult twoCoordinateResult = terminalService.getCoordinateForTwoDeckShip();
        while (!twoCoordinateResult.isSuccess()) {
            terminalService.sendMessage("Координаты введены не верно, введите координаты еще раз.");
            twoCoordinateResult = terminalService.getCoordinateForTwoDeckShip();
        }
        Ship ship = Ship.createShip(twoCoordinateResult.getCoordinates());
        boolean addShip = field.addShip(ship);
        if(!addShip) {
            createTwoDeckerShipAndAddToField(field);
        }
        field.showField();
    }

    /**
     * Создать однопалубный корабль и добавить на поле.
     *
     * @param field поле на которое добавляется корабль.
     */
    private void createOneDeckerShipAndAddToField(Field field) {
        CoordinateResult oneCoordinateResult = terminalService.getCoordinateForOneDeckShip();
        while (!oneCoordinateResult.isSuccess()) {
            terminalService.sendMessage("Координаты введены не верно, введите координаты еще раз.");
            oneCoordinateResult = terminalService.getCoordinateForOneDeckShip();
        }
        Ship ship = Ship.createShip(oneCoordinateResult.getCoordinates());
        boolean addShip = field.addShip(ship);
        if(!addShip) {
            createOneDeckerShipAndAddToField(field);
        }
        field.showField();
    }
}

