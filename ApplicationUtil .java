package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.regex.*;
import java.lang.*;

import com.exception.InvalidDonorIdException;

public class ApplicationUtil {
	
	public static List<String> extractDetails(String[] list)
	{
		List<String> donorList=new ArrayList<String>();
		
		// Write code here
		try{
		    for(String s:list){
		        String []a=s.split(",");
		        if(validateDonorId(a[0])){
		            donorList.add(s);
		            
		        }
		            
		    }
		    
		}catch(Exception e){
		    e.printStackTrace();
		}
		
		return donorList;
	}	
	
	public static boolean validateDonorId(String donorId) throws InvalidDonorIdException
	{

		// Write code here
		String regex="[0-9]+";
		if(donorId.length()==9){
		    if(donorId.startsWith("DONOR")){
		        String t=donorId.substring(5,9);
		        System.out.println(t);
		        Pattern p=Pattern.compile(regex);
		        Matcher m=p.matcher(t);
		        return m.matches();
		        
		    }
		    else{
		        return false;
		    }
		}
		return false;
	}
	
	public static java.util.Date stringToDateConverter(String stringDate) throws Exception
	{
		// Write code here
		Date d=new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
		
		return d;
	}

	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) 
	{
		// Write code here
		java.sql.Date dt=new java.sql.Date(utDate.getTime());
		
		return dt;
	}
	
	public static java.util.Date sqlToUtilDateConverter(java.sql.Date sDate) 
	{
		// Write code here
		java.util.Date Date=new java.util.Date(sDate.getTime());
		
		return Date;
	}
}