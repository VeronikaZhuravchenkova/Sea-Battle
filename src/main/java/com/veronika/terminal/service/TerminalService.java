package com.veronika.terminal.service;

import com.veronika.terminal.model.CoordinateResult;

/**
 * Сервис взаимодействия с пользователем через терминал.
 */
public interface TerminalService {

    void sendMessage(String message);

    /**
     * Получить от пользователя имя первого игрока.
     *
     * @return имя первого игрока.
     */
    String getFirstPlayerName();

    /**
     * Получить от пользователя имя второго игрока.
     *
     * @return имя второго игрока.
     */
    String getSecondPlayerName();

    /**
     * Получить координаты выстрела.
     *
     * @return координаты выстрела.
     */
    String getShotCoordinates();

    /**
     * Отправить сообщение в терминал о начале расстановки кораблей первому игроку.
     *
     * @param firstPlayerName имя пераого игрока.
     */
    void sendMessageStartShipDeploymentForFirstPlayer(String firstPlayerName);

    /**
     * Отправить сообщение в терминал о начале расстановки кораблей первому игроку.
     *
     * @param secondPlayerName имя второго игрока.
     */
    void sendMessageStartShipDeploymentForSecondPlayer(String secondPlayerName);

    /**
     * Получить координаты для четырехпалубного корабля.
     *
     * @return результат со статусом обработки и координатами.
     */
    CoordinateResult getCoordinateForFourDeckShip();

    /**
     * Получить координаты для трёхпалубного корабля.
     *
     * @return результат со статусом обработки и координатами.
     */
    CoordinateResult getCoordinateForThreeDeckShip();

    /**
     * Получить координаты для двухпалубного корабля.
     *
     * @return результат со статусом обработки и координатами.
     */
    CoordinateResult getCoordinateForTwoDeckShip();

    /**
     * Получить координаты для однопалубного корабля.
     *
     * @return результат сос статусом обработки и координатами.
     */

    CoordinateResult getCoordinateForOneDeckShip();
}
