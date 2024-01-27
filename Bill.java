package com.example.task2;

public class Bill
{
	private String item;
	private double price;
	
	public Bill(String item, double price)
	{
		this.item = item;
		this.price = price;
	}
	
	public String getItem()
	{
		return this.item;
	}
	
	public double getPrice() 
	{
		return this.price;
	}
	
	public void Display()
	{
		System.out.println("Item: " + item);
		System.out.println("Price: " + price);
		System.out.println("--------------------");
		
	}
}
