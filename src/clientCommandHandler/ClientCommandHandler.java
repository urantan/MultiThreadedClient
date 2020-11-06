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
    serverCommandHandler.ServerCommandHandler serverHandler;
    public ClientCommandHandler(multiThreadedClient.MultiThreadedClient ThreadedClient,userInterface.UserInterface userInterface) {
        this.ThreadedClient = ThreadedClient;
        this.userInterface = userInterface;
    }
    
    
    public void HandlerUserCommand(String input){
        
        switch (input){
            case "d":
                if(ThreadedClient.SendMsg((byte) 'd')){
                    ThreadedClient.StopServer();
                    userInterface.Display("The client has successfully disconnected");
                }
                else{
                    userInterface.Display("The client did not disconnect");
                }
                break;
            case "c":
               if(ThreadedClient.makeConnection()){
                   userInterface.Display("The  client has connected successfully");
               }
               else{
               userInterface.Display("The  client has not connected successfully");
               }
                break;
            case "t":
                 ThreadedClient.SendMsg((byte) 't');
                break;
            case "q":
                if(ThreadedClient.SendMsg((byte) 'q')){
                ThreadedClient.disconnect();
                userInterface.Display("Quiting program by User command.");
                System.exit(1);
                }
                else{
                userInterface.Display("Quiting program could not occur");
                }
                
                break;
        
        }
    
    }
}
