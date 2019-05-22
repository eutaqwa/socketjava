package com.esa.inter.socket.stringtransfer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientString {
	private static SocketAddress address;
	private static Socket clientSocket;
	private static ObjectOutputStream outputStream;
	public static void main(String [] args){
		System.out.println("This is Client Socket");
		String ip = "127.0.0.1";
		int port = 6666;
		address = new InetSocketAddress(ip, port);
		clientSocket = new Socket();
		try{
			clientSocket.connect(address);
			System.out.println("You Have Been Connected to Socket");
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			String message = "Hello There my name is Tyler Durden" + "\r\n"
							+"Thank you for allowing me to have a conversation with you" + "\r\n"
							+"How you Doing?";
			outputStream.writeObject(message);
			outputStream.close();
			clientSocket.close();
		}catch (IOException e){
			System.out.println("Error" + e.getMessage());
		}
		
	}
	
	
}
