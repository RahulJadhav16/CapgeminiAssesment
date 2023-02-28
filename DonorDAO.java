package com.dao;

import java.util.*;;

import com.model.Donor;
import java.sql.*;
import com.util.ApplicationUtil;
import java.lang.*;

public class DonorDAO {
	
	public static int insertDonorList(List<Donor> donorList){
		
		// Write code here
		try (
		    PreparedStatement ps=DBConnectionManager.getConnection().prepareStatement("INSERT INTO DONORDETAILS VALUES(?,?,?,?,?,?,?,?,?)");){
		       
		    int count=0;
		    
		    for(int i=0;i<donorList.size();i++){
		        ps.setString(1,donorList.get(i).getDonorId());
		        ps.setString(2,donorList.get(i).getDonorName());
		        ps.setString(3,donorList.get(i).getBloodGroup());
		        ps.setLong(4,donorList.get(i).getPhoneNumber());
		        ps.setString(5,donorList.get(i).getAddress());
		        ps.setInt(6,donorList.get(i).getDonorAge());
		        ps.setDouble(7,donorList.get(i).getDonorWeight());
		        ps.setDate(8,ApplicationUtil.utilToSqlDateConverter(donorList.get(i).getDonationDate()));
		        ps.setString(9,donorList.get(i).getDonationStatus());
		        
		        count=ps.executeUpdate();
		    }
		    if(count>0){
		        return 1;
		    }
		    else{
		        return -1;
		    }
		    
		} catch(SQLException e) {
		    e.printStackTrace();
		}catch(ClassNotFoundException e){
		    return -1;
		}
		
		
		return -1;
	}
	 	  	  			  	  	     	 	
    public static List<Donor> retrieveDonorList(String bloodGroup) 
    {
	    // Write code here
	    try{
	        PreparedStatement retrive=DBConnectionManager.getConnection().prepareStatement("SELECT * FROM DONORDETAILS WHERE BLOOD_GROUP=?");
	        retrive.setString(1,bloodGroup);
	        ResultSet rs;
	        rs=retrive.executeQuery();
	        List<Donor> out=new ArrayList<>();
	        while(rs.next()){
	            Donor d=new Donor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getDate(8),rs.getString(9));
	            out.add(d);
	        }
	        return out;
	    }catch(SQLException e){
	        e.printStackTrace();
	    }catch(ClassNotFoundException e){
	        return null;
	    }
	    return null;
    }
}