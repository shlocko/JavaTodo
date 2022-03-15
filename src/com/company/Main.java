package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean running = true;
        List list = new List();
        
        InputHandler handler = new InputHandler(list);
        
        
        while(running) {
            System.out.println("Enter a command: ");
            String input = scnr.nextLine();
            running = handler.handle(input);
        }
        
    }
}
