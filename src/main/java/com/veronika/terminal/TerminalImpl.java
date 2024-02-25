package com.veronika.terminal;

import java.util.Scanner;

public class TerminalImpl implements Terminal {

    private final Scanner scanner;

    public TerminalImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getMessage() {
        return scanner.nextLine();
    }
}
