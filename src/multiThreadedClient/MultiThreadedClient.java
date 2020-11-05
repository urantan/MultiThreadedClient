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
    boolean CheckConnected;

    public MultiThreadedClient() {
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
        CheckConnected = result;
        return result;
    }

    public void StopServer() {
        try {
            socket.close();
            this.in = null;
            this.out = null;
            CheckConnected = false;
        } catch (IOException e) {
            System.err.println("Cannot close stream or client socket; exiting");
            System.exit(1);
            // CheckConnected = true;
        }

    }

    public boolean SendMsg(byte value) {
        boolean returnValue = false;

        try {
            if (CheckConnected) {
                out.write(value);
                returnValue = true;
            } else {
                System.out.println("Client disconnected from server");
            }
        } catch (IOException e) {
            System.err.println("Could not send msg");
        }

        return returnValue;
    }

    public byte GetMsg() {
        byte value = (byte) -1;

        if (CheckConnected) {
            try {
                value = (byte) in.read();
            } catch (IOException i) {
                System.err.println("Client disconnected");
            } 
        }
         return value;
    }
    
     public void disconnect() {
    try {
      CheckConnected = false;
      socket.close();
      this.in = null;
      this.out = null;
      
    } catch (Exception e) {
      System.err.println("Cannot close stream/client socket; exiting.");
      System.exit(1);
    }
  }

}
