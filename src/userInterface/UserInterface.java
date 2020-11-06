/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.io.*;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class UserInterface implements Runnable {

    BufferedReader console = null;
    clientCommandHandler.ClientCommandHandler commandHandler;
    public UserInterface() {
        console = new BufferedReader(new InputStreamReader(System.in));
        if (console == null) {
            System.err.println("No Standard Input device, exiting program.");
            System.exit(1);
        }
        //commandHandler = new clientCommandHandler.ClientCommandHandler();
    }

    public void SetClientHandler(clientCommandHandler.ClientCommandHandler commandHandler){
        this.commandHandler = commandHandler;
    }
    @Override
    public void run() {

        while(true){
        String input = "no input";

        try {
            input = console.readLine();
            //   return input;
        } catch (IOException e) {
            System.err.print("No standard Input, exitting the program");
            System.exit(0); 
        }
        
        
        // return input;
        commandHandler.HandlerUserCommand(input);
        }
    }

    public void Display(String input) {

        System.out.println(input);
    }

 
}
