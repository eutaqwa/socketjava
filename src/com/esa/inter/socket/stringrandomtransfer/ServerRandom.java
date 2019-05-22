package com.esa.inter.socket.stringrandomtransfer;

import java.io.*;
import java.net.*;


public class ServerRandom {
	private static ServerSocket serverSocket;
	private static int port =5123;
	
	public static void main(String[]args) throws IOException, ClassNotFoundException{
		 serverSocket = new ServerSocket(port);
		 System.out.println("Waiting Client...");
		 while(true){
			 Socket socket = serverSocket.accept();
			 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			 String message = (String) ois.readObject();;
			 System.out.println(message);
			 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			 oos.writeObject(message);
			 ois.close();
			 oos.close();
			 socket.close();
			 if (message.equalsIgnoreCase("DONE..."))
			 break;
		 }
		 System.out.println("Server Closed");
		 serverSocket.close();
	}
}
