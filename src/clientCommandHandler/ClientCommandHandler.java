/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientCommandHandler;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class ClientCommandHandler {

    multiThreadedClient.MultiThreadedClient ThreadedClient;
    userInterface.UserInterface userInterface;
    public ClientCommandHandler(multiThreadedClient.MultiThreadedClient ThreadedClient,userInterface.UserInterface userInterface) {
        this.ThreadedClient = ThreadedClient;
        this.userInterface = userInterface;
    }
    
    
    public void HandlerUserCommand(String input){
        
        switch (input){
            case "d":
                
                break;
            case "c":
               if(ThreadedClient.StartServer("localhost", 5555)){
                   userInterface.Display("The  client has connected successfully");
               }
               else{
               userInterface.Display("The  client has not connected successfully");
               }
                break;
            case "t":
                
                break;
        
        
        }
    
    }
}
