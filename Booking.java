package com.example.task2;

import java.time.LocalDate;
import java.util.LinkedList;

public class Booking
{
	private LocalDate Date;
	private Room room;
	private Customer customer;
	private LinkedList<Bill> billList;
	private boolean checkedIN;
	private double totalBill;
	
	
	Booking(LocalDate date, Room room)
	{
		billList = new LinkedList<Bill>();
		this.Date = date;
		this.room = room;
		this.customer = null;
		checkedIN = false;
		this.totalBill = 0;
		
		//System.out.println("Room No. " + room.getRoomNumber() + "\nDate: " + date + "\n---------------------\n");
	}
	
	public void CheckIN()
	{
		this.checkedIN = true;
	}
	
	public void addBillItem(String item, double price)
	{
		Bill temp = new Bill(item, price);
		this.billList.add(temp);
		this.totalBill += price;
	}
	
	public LocalDate getDate()
	{
		return this.Date;
	}
	
	public int getRoomNumber()
	{
		return this.room.getRoomNumber();
	}
	
	public void Display()
	{
		this.room.Display();
		System.out.println(Date);
		
		System.out.println("-----------------------\n");

	}
	
	public boolean isAvailable()
	{
		if(customer == null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public int getCNIC()
	{
		return this.customer.getCNIC();
	}
	
	public void makeBooking(Customer C)
	{
		this.customer = C;
		
		System.out.println("Room Booked Successfully!");
		System.out.println("Details:");
		System.out.println(Date);
		customer.Display();
		room.Display();
	}
	
	public void DisplayBill()
	{
		System.out.println("Room fare: " + room.getPrice());
		for(Bill bill : billList)
		{
			bill.Display();
		}
		System.out.println("Total: " + room.getPrice() + totalBill);
		System.out.println("You are now checked out!\n");
		
	}
	
}
