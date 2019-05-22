package com.esa.inter.socket.filetransfer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.esa.inter.services.Connect;


public class SocketFileToDatabase {
	public static void main(String[]args){
		loadFile();
	}
	public static void loadFile(){
		ResultSet rs = null;
		Connection conn = new Connect().getConnected();
		String file = ClientFile.fileToSend;
		try{
			String query = "LOAD DATA INFILE '"+file+"'"+" INTO TABLE employee FIELDS TERMINATED BY ',' LINES TERMINATED BY '\r\n'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		}catch(SQLException e){
			Logger.getLogger(SocketFileToDatabase.class.getName()).log(Level.SEVERE, null, e);
		}
		finally{
			if(rs!=null)try{
				rs.close();
			}catch(Exception e){
				Logger.getLogger(SocketFileToDatabase.class.getName()).log(Level.SEVERE, null, e);
			}
			if(conn!=null)try{
				conn.close();
			}catch(Exception e){
				Logger.getLogger(SocketFileToDatabase.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
	
}
