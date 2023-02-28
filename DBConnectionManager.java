package com.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.Properties;
import java.io.*;


public class DBConnectionManager {

	private static Connection con = null;
	private static Properties props=new Properties();
	
	
	public static Connection getConnection()throws ClassNotFoundException,SQLException {
	    try{
	        FileInputStream fis=null;
	        fis=new FileInputStream("database.properties");
	        props.load(fis);
	        Class.forName(props.getProperty("drivername"));
	        con=DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
	        
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	    
	    
	    // Write code here
	    
 		return con;	
	}
}