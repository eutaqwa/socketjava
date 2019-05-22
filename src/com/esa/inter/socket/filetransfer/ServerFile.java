package com.esa.inter.socket.filetransfer;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerFile {
	public final static int socketPort = 6667;
	public final static String fileToReceived = "D:/ESA/SOCKET/transferedfile-socket.txt";
	public final static int fileSize = 40000;
	public static void main(String [] args)throws IOException{
		int bytesRead;
		int current = 0;
		InputStream is =null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ServerSocket serverSocket = null;
		Socket socket = null;
		try{
			serverSocket = new ServerSocket(socketPort);
			while(true){
				
				try{
					System.out.println("Waiting...");
					socket = serverSocket.accept();
					System.out.println("Accepted Connection : " + socket);;
					byte [] mybytearray = new byte [fileSize];
					is = socket.getInputStream();
					fos = new FileOutputStream(fileToReceived);
					bos = new BufferedOutputStream(fos);
					bytesRead = is.read(mybytearray, 0, mybytearray.length);
					current = bytesRead;
					do{
						bytesRead = is.read(mybytearray, current, (mybytearray.length-current));
						if(bytesRead >= 0) current += bytesRead;
					}while(bytesRead > -1);
					bos.write(mybytearray, 0, current);
					bos.flush();
					SocketFileToDatabase.loadFile();
					System.out.println("File " + fileToReceived + " to databases (" + current + " bytes read)");
					
				}finally{
					if(bos != null) bos.close();
					if(is != null) is.close();
					if(socket != null) socket.close();
					System.out.println("Socket has been disconnected");
				}
			}
		}finally{
			if(serverSocket != null) serverSocket.close();
		}
	}
}
