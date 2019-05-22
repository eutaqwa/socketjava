package com.esa.inter.socket.filetransfer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientFile {
	public final static int socketPort = 6667;
	public final static String server = "127.0.0.1";
	public final static String fileToSend = "D:/ESA/Task from Pak Saptono/Sockettest.txt";
	public static void main (String [] args)throws IOException{
		FileInputStream fis = null;
		BufferedInputStream bis =null;
		OutputStream os = null;
		Socket socket = null;
		try{
			socket = new Socket(server, socketPort);
			System.out.println("Connecting...");
			File myFile = new File(fileToSend);
			byte[]mybytearray = new byte [(int)myFile.length()];
			fis = new FileInputStream(myFile);
			bis = new BufferedInputStream(fis);
			bis.read(mybytearray, 0, mybytearray.length);
			os = socket.getOutputStream();
			System.out.println("Sending " + fileToSend + "(" + mybytearray.length + "bytes)");
			os.write(mybytearray, 0, mybytearray.length);
			os.flush();
			System.out.println("Done.");
			System.out.println("Socket has Closed");
			socket.close();
		}finally{
			if(fis != null)fis.close();
			if(bis != null)bis.close();
			if(socket != null)socket.close();
		}
	}
}
