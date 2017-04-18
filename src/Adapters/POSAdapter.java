/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dubze
 */
public class POSAdapter {
    
    public static String getTotal() throws IOException{
        String clientSentence;
        //String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6788);
        int n = 0;
        while(true)
        {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            //DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            System.out.println("Received: " + clientSentence);
            n+=1;
            System.out.println("Muahahaha!!!!!!!!" +n);
            connectionSocket.close();
            return clientSentence;
            //capitalizedSentence = clientSentence.toUpperCase() + '\n';
            //outToClient.writeBytes(capitalizedSentence);
        }
        
    }
    
}
