/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiThreadedClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class MultiThreadedClient {
    
    Socket socket;
    InputStream in;
    OutputStream out;
    public MultiThreadedClient(){
        in = null;
        out = null;
    }
    
    public boolean StartServer(String host, int PortNum) {
        boolean result = false;
        try {
            InetAddress ad = InetAddress.getByName(host);
            socket = new Socket(ad, PortNum);
            if (socket != null) {
                System.out.println("Connected");
            }
            in = socket.getInputStream();
            out = socket.getOutputStream();
            result = true;
        } catch (IOException e) {
            System.err.println("Cannot Connect to Server");
            result = false;
        }
        return result;
    }

    public void StopServer() {
        try {
            socket.close();
            this.in = null;
            this.out = null;
        } catch (IOException e) {
            System.err.println("Cannot close stream or client socket; exiting");
            System.exit(1);
        }

    }
    
    
    
}
