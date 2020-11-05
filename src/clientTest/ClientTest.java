/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientTest;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class ClientTest {
    
     public static void main(String[] args) {
     
         userInterface.UserInterface userInterface = new userInterface.UserInterface();
         multiThreadedClient.MultiThreadedClient client = new multiThreadedClient.MultiThreadedClient();
         clientCommandHandler.ClientCommandHandler clientHandler = new  clientCommandHandler.ClientCommandHandler(client,userInterface);
         userInterface.SetClientHandler(clientHandler);
          
         
         userInterface.Display("d:\tDisconnect\n"
                + "t:\tTime\n"
                + "c:\tConnect\n");
             Thread myUIthread = new Thread(userInterface);
           myUIthread.start();
         //  clientHandler.HandlerUserCommand(input);
     }
}
