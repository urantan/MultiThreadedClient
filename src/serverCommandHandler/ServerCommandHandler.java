/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverCommandHandler;

import java.util.ArrayList;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class ServerCommandHandler  {
    
  //  userInterface.UserInterface UserInterface;
    multiThreadedClient.MultiThreadedClient MultiThreadedClient;
    public ServerCommandHandler(multiThreadedClient.MultiThreadedClient MultiThreadedClient){
      
        this.MultiThreadedClient = MultiThreadedClient;
    }
    
   
    public void execute(){
        String ToPrint = " ";
        if (MultiThreadedClient.SendMsg((byte) 't')) {
                        MultiThreadedClient.SendMsgToUi("Waiting to recieve time");

                        var arrayList = new ArrayList<String>();

                        boolean check = true;
                        while (check) {

                            byte recievedValue = MultiThreadedClient.GetMsg();
                            var value = (char) recievedValue;
                            String charValue = String.valueOf(value);
                            arrayList.add(charValue);
                            if (arrayList.size() == 7) {
                                check = false;
                            }
                        }
                        if (arrayList.size() == 7) {

                            for (int i = 0; i < arrayList.size(); i++) {
                                ToPrint += arrayList.get(i);
                            }
                        }
                       MultiThreadedClient.SendMsgToUi(ToPrint);
                    } else {
                        MultiThreadedClient.SendMsgToUi("Msg not sent successfully");
                    }
    
    }
}
