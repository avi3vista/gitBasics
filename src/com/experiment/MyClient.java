package com.experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MyClient {

	
	public static void main(String[] args)throws IOException {

        if (args.length != 3) {
            System.err.println("Please provide server ip address, port number and condition");
            System.exit(1);
        }

        InetAddress inetAddress = InetAddress.getByName(args[0]);
        int portNumber = Integer.parseInt(args[1]);
        String condition = args[2];


        try (
                ServerSocket serverSocket = new ServerSocket( portNumber, 0, inetAddress);
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {

            String inputLine ;
            while ((inputLine = in.readLine()) != null) {
                searchLog(inputLine,condition);
//                System.out.println("line");
            }
        } catch (IOException e) {
            System.out.println("Exception while trying to listen on IP/port " + args[0] + "/"+ portNumber );
            System.out.println(e.getMessage());
        }
    }


    static void searchLog( String line, String conditionLine){


        conditionLine = conditionLine.replaceAll("\\s","");
        String conditions[] = conditionLine.trim().split(",");


        String currentInputLine =line;
            currentInputLine = currentInputLine.replaceAll("\\s","");
            String currentLineString[]= currentInputLine.trim().split(",");
            Boolean matched = true;
            for(String conditionString : conditions) {

                if(!(Arrays.asList(currentLineString).contains(conditionString)))
                {
                    matched=false;
                    break;
                }
            }
            if(matched) {
                System.out.println(currentInputLine);
            }
    }
	
}
