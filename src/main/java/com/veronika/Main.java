package com.veronika;

import com.veronika.terminal.TerminalImpl;
import com.veronika.terminal.service.TerminalService;
import com.veronika.terminal.service.TerminalServiceImpl;

public class Main {
    public static void main(String[] args) {
        TerminalService terminalService = new TerminalServiceImpl(new TerminalImpl());
        Game game = new Game(terminalService);
        game.play();
    }
}
