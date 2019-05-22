package com.esa.inter.socket.stringtransfer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerString {
	private static ServerSocket serverSocket;
	private static Socket clientSocket;
	private static ObjectInputStream objectInputStream;
	
	public static void main(String[]args)throws IOException{
		System.out.println("Socket is Ready");
		try{
			serverSocket = new ServerSocket(6666);
			System.out.println("Waiting for Client...");
			clientSocket = serverSocket.accept();
			System.out.println("Client Connected");
			objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
			String message = (String) objectInputStream.readObject();
			System.out.println("There is some data");
			System.out.println("Data is : " + "\r\n" + message);
			
			File file =new File("D:/ESA/SOCKET/Socketfilestring1.txt");
			FileOutputStream outputStream = new FileOutputStream(file);
			OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
			Writer writer = new BufferedWriter(streamWriter);
			writer.write(message);
			writer.close();
			objectInputStream.close();
			clientSocket.close();
			System.out.println("Socket Client has Closed");
			serverSocket.close();
			System.out.println("Socket Server has Closed");
		}catch(IOException | ClassNotFoundException e){
			System.out.println("Error"+e.getMessage());
		}
	}
}
