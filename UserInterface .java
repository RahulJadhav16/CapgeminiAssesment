package com.client;

import java.util.Scanner;
import com.service.DonationService;

public class UserInterface {
	public static void main(String[] args)throws Exception {
		
		DonationService dsobj = new DonationService();
		Scanner sc=new Scanner(System.in);

		// The below code gets the details of donors
		// Give input in the format as specified in the problem statement
		System.out.println("Enter the number of donors");
		int num=sc.nextInt();
		String details[]=new String[num];
		System.out.println("Enter the donor details");
		sc.nextLine();
		for(int i=0;i<num;i++)
		{
			details[i]=sc.nextLine();
		}
		
		//The below code passes the donor details to the addDonorList method in the DonationService class
		boolean recordsInserted = false;
		recordsInserted = dsobj.addDonorList(details);
		if (recordsInserted)
		{
			System.out.println("Valid donor records are updated to the database");
			System.out.println("Enter the blood group");
	     	String bloodGroup=sc.next();
	     	String ans=dsobj.retrieveDonorCount(bloodGroup);
	    	System.out.println(ans);
		}
		else
			System.out.println("Failed to insert records");
	
	}	 	  	      		      	   	     	     	 	
}