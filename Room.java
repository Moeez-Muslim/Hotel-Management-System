package com.example.task2;
import java.time.LocalDate; // import the LocalDate class

public class Room
{
	private double pricePerDay;
	private int roomNo;
	private boolean reserved;
	
	public Room(int roomNo, double pricePerDay)
	{
		this.pricePerDay = pricePerDay;
		this.roomNo = roomNo;
		this.reserved = false;
	}
	
	public int getRoomNumber()
	{
		return this.roomNo;
	}
	
	public double getPrice()
	{
		return this.pricePerDay;
	}
	
	public void Display()
	{
		System.out.println("Room No. " + this.roomNo);
		System.out.println("Price per 24 hours: " + this.pricePerDay);
	}
	
	public boolean isReserved()
	{
		return this.reserved;
	}
	
}
