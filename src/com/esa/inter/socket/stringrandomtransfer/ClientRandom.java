package com.esa.inter.socket.stringrandomtransfer;

import java.io.*;
import java.util.*;
import java.net.*;

public class ClientRandom {
	public static void main(String[]args) throws IOException, ClassNotFoundException, UnknownHostException, InterruptedException{
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		int length = 11;
		String[]freeWords = {"USA, UK, Uni Soviet and China were united in Allied Forces","Lannisters always pay their debt","Allied has won World War II","Slytherin house is a house for an ambitious man"};
		Random random = new Random();
		for(int i = 0; i<length;i++){
			socket = new Socket(host.getHostName(), 5123);
			oos = new ObjectOutputStream(socket.getOutputStream());
			if (i ==10)
				oos.writeObject("---Random String Transfer has Done---");
			else
				oos.writeObject(freeWords[random.nextInt(freeWords.length)]);
			ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println("Random String is: " + message);
			ois.close();
			oos.close();
			Thread.sleep(5*1000);
		}
	}
}
