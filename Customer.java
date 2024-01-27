package com.example.task2;

public class Customer
{
	private String name;
	private int CNIC;
	
	public Customer(String name, int CNIC)
	{
		this.name = name;
		this.CNIC = CNIC;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCNIC()
	{
		return CNIC;
	}
	
	public void Display()
	{
		System.out.println("Name: " + this.name);
		System.out.println("CNIC: " + this.CNIC);
	}
}
