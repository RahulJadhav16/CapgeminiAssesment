package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Donor;
import com.util.ApplicationUtil;
import com.dao.DonorDAO;

public class DonationService {

public static List <Donor> buildDonorList(List<String> donorRecords)throws Exception {
		
		List <Donor> objectList = new ArrayList<Donor>();
		
		// Write code here
		for(String a:donorRecords){
		    
		    String []temp=a.split(",");
		    String stat=DonationService.findDonorStatus(Integer.parseInt(temp[5]),Double.parseDouble(temp[6]));
		    
		    Donor d=new Donor(temp[0],temp[1],temp[2],Long.parseLong(temp[3]),temp[4],Integer.parseInt(temp[5]),Double.parseDouble(temp[6]),ApplicationUtil.stringToDateConverter(temp[7]),stat);
		    objectList.add(d);
		}
		
		return objectList;
	}
	
	public boolean addDonorList(String details[])throws Exception
	{
		// Write code here
		boolean res=false;
		List<String> r=new ArrayList<>();
		r=ApplicationUtil.extractDetails(details);
		List<Donor> qw=new ArrayList<>();
		qw=buildDonorList(r);
		if(qw.isEmpty()){
		    return res;
		}else{
		    if(DonorDAO.insertDonorList(qw)>0){
		        return true;
		    }
		    return false;
		}
	
	}	 
	
	public static String findDonorStatus(int age,double weight)
	{
		// Write code here
		if(age>=18 && age<=65 && weight>=45){
		    return "Eligible";
		    
		}else{
		    return "Not Eligible";
		}
		
		
	}
	
	public String retrieveDonorCount(String bloodGroup)
	{
		// Write code here
		List<Donor> q=DonorDAO.retrieveDonorList(bloodGroup);
		
		
		return String.valueOf(q.size());
	}
}