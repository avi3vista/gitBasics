package com.experiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZapLabsInterview {

	public static void main(String[] args) {
		String inputZipCode = "95035";

		House[] houseArray = (House[]) Realtor.getHousesForSale().stream().filter(h-> h.getZipCode().equalsIgnoreCase("95035")).toArray();
		
		for(int i=0; i<houseArray.length;i++) {
			System.out.println(houseArray[i].getZipCode());
		}

	}

}

 interface Realtor {
    static List<House> getHousesForSale() {
    	House house1 = new HouseImpl("95035");
		House house2 = new HouseImpl("95036");
		House house3 = new HouseImpl("95037");
		House house4 = new HouseImpl("95038");
		House house5 = new HouseImpl("95035");
		House house6 = new HouseImpl("95035");
		House house7 = new HouseImpl("95036");
		
		List houseList = new ArrayList<>();
		houseList.add(house1);
		houseList.add(house2);
		houseList.add(house3);
		houseList.add(house4);
		houseList.add(house5);
		houseList.add(house6);
		houseList.add(house7);
		
		return houseList;
    }
}
 
 interface House {
    public String getZipCode();
}
 
 /*class RealtorImpl implements Realtor {

	@Override
	public List<House> getHousesForSale() {
		// TODO Auto-generated method stub
		
		House house1 = new HouseImpl("95035");
		House house2 = new HouseImpl("95036");
		House house3 = new HouseImpl("95037");
		House house4 = new HouseImpl("95038");
		House house5 = new HouseImpl("95035");
		House house6 = new HouseImpl("95035");
		House house7 = new HouseImpl("95036");
		
		List houseList = new ArrayList<>();
		houseList.add(house1);
		houseList.add(house2);
		houseList.add(house3);
		houseList.add(house4);
		houseList.add(house5);
		houseList.add(house6);
		houseList.add(house7);
		
		return houseList;
	}
	 
 }*/
 
 class HouseImpl implements House{
	 String zipcode;
	 HouseImpl(String zipcode) {
		 this.zipcode = zipcode;
	 }

	@Override
	public String getZipCode() {
		// TODO Auto-generated method stub
		return this.zipcode;
	}
	 
 }
