package com.example.task2;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Hotel
{
	private LinkedList<Room> Rooms;
	private LinkedList<Customer> Customers;
	private int roomCounter;
	private LinkedList<LinkedList<Booking>> bookings;
	LinkedList<Booking> innerList;
	private Customer currentCustomer;
	private Booking currentBooking;
	
	public Hotel()
	{
		Rooms = new LinkedList<Room>();
		Customers = new LinkedList<Customer>();
		roomCounter = 0;
		bookings = new LinkedList<LinkedList<Booking>>();
		currentCustomer = null;
		
		
		for(int i = 0; i < 10; i++)  // Adding 10 rooms
		{
			Room R = new Room(++roomCounter, 20);
			Rooms.add(R);
		}
		 
		for (Room room : Rooms) 
		{
            innerList = new LinkedList<Booking>();

            LocalDate currentDate = LocalDate.now();
            LocalDate tomorrow = currentDate.plusDays(1);

            for (int i = 0; i < 30; i++) 
            {
                Booking B = new Booking(tomorrow.plusDays(i), room); // Create a new Booking for each day and room
                innerList.add(B);
            }

            bookings.add(innerList);
        }
	}
	
	public void addRoom(Scanner scanner)
	{
		double price = 0;
		System.out.print("Enter the price of room for 24 hours: ");
		
		price = scanner.nextDouble();
		
		if(price <= 0)
		{
			System.out.println("Invalid Price\nRoom couldn't be created");
			return;
		}
		
		Room R = new Room(++roomCounter, price);
		Rooms.add(R);
		
		// Updating room in bookings lisst
		innerList = new LinkedList<Booking>();
		
		 // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Start from tomorrow
        LocalDate tomorrow = currentDate.plusDays(1);
        
        for(int i = 0; i < 30; i++)
        {
        	Booking B = new Booking(tomorrow.plusDays(i), Rooms.getLast());
        	innerList.add(B);
        }
        
        bookings.add(innerList);
	}
	
	public void Login(Scanner scanner)
	{
		 int loginCNIC;
	    
	    System.out.print("Enter your CNIC to log in: ");
	    loginCNIC = scanner.nextInt();
	    
	    for (Customer customer : Customers) 
	    {
	        if (loginCNIC == customer.getCNIC()) 
	        {
	            currentCustomer = customer;
	            System.out.println("Login successful!");
	            currentCustomer.Display();
	            return;
	        }
	    }
	    
	    System.out.println("CNIC not found. Login failed!");
	}
	
	public void addCustomer(Scanner scanner)
	{
	    String name;
	    int CNIC;


	    System.out.print("Enter your unique CNIC: ");
	    CNIC = scanner.nextInt();

	    scanner.nextLine(); // Consume the newline character

	    for (Customer customer : Customers) 
	    {
	        if (CNIC == customer.getCNIC()) 
	        {
	            System.out.print("Duplicate CNIC\nRegistration failed!");
	            scanner.close();
	            return;
	        }
	    }

	    System.out.print("Enter your name: ");
	    name = scanner.nextLine();

	    Customer C = new Customer(name, CNIC);
	    Customers.add(C);

	    System.out.println("Registration Successful!");

	}

	
	public void BookRoom(Scanner scanner)
	{
		LocalDate proposedDate = LocalDate.now();

	    // Define a date format (assuming the user will enter dates in "YYYY-MM-DD" format)
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    scanner.nextLine();
	    // Read the user's input for the date
	    System.out.print("Enter a date (YYYY-MM-DD): ");
	    String userInput = scanner.nextLine();

	    try 
	    {
	        // Parse the user input into a LocalDate object
	        proposedDate = LocalDate.parse(userInput, formatter);

	    } 
	    catch (Exception e) 
	    {
	        System.err.println("Invalid date format. Booking failed!");
	        return; // Exit the method on invalid input
	    }        
	    
        System.out.println("Here are the available rooms on " + proposedDate);
        
        for (LinkedList<Booking> innerList : bookings) 
		{
            for (Booking booking : innerList) 
            {
            	if (proposedDate.equals(booking.getDate()))
                {
            		if(booking.isAvailable())
        			{
            			booking.Display();
        			}
                }
            }
        }
        
        System.out.println("****************************\n");
        System.out.print("Enter room number to book: ");
        int roomNo = scanner.nextInt();
        
        boolean found = false;
        for (LinkedList<Booking> innerList : bookings) 
		{
            for (Booking booking : innerList) 
            {
            	if (booking.getDate().equals(proposedDate) && booking.getRoomNumber() == roomNo)
            	{
            		 if(booking.isAvailable())
                     {
                     	booking.makeBooking(currentCustomer);
                     	found = true;
                     	break;
                     }
            		 else 
            		 {
						System.out.println("This room is already booked. Booking Failed!");
						break;
            		 }
            	}
            }
        }
        
        if(!found)
        {
        	System.out.println("No booking found. Please recheck details and try again");
        }
        
	}
	
	public void myBookings()
	{
		System.out.println("Active bookings\n\n");
		for (LinkedList<Booking> innerList : bookings) 
		{
            for (Booking booking : innerList) 
            {
            	if(!booking.isAvailable())
            	{
            		 if(currentCustomer.getCNIC() == booking.getCNIC())
                     {
                     	booking.Display();
                     	System.out.println("----------------------------\n");
                     }
            	}
            }
        }
	}
	
	public void DisplayBookings()
	{
		for (LinkedList<Booking> innerList : bookings) 
		{
            for (Booking booking : innerList) 
            {
            	if(booking.isAvailable())
            	{
            		booking.Display(); // Display the booking details for each day and room	
            	}
            }
        }
	}
	
	public void SearchGuest(Scanner scanner)
	{
		System.out.println("Enter CNIC to search: ");
		int CNIC = scanner.nextInt();
		
		for(Customer C: Customers)
		{
			if(C.getCNIC() == CNIC)
			{
				C.Display();
				currentCustomer = C;
				this.myBookings();
				currentCustomer = null;
				break;
			}
		}
	}
	
	public void LogOut()
	{
		this.currentCustomer = null;
	}
	
	public void checkIN(Scanner scanner)
	{
		this.myBookings();
		System.out.println("\n--------------------\n");
		
		LocalDate proposedDate = LocalDate.now();

	    // Define a date format (assuming the user will enter dates in "YYYY-MM-DD" format)
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    scanner.nextLine();
	    // Read the user's input for the date
	    System.out.print("Enter the date to check IN (YYYY-MM-DD): ");
	    String userInput = scanner.nextLine();

	    try 
	    {
	        // Parse the user input into a LocalDate object
	        proposedDate = LocalDate.parse(userInput, formatter);

	    } 
	    catch (Exception e) 
	    {
	        System.err.println("Invalid date format. Booking failed!");
	        return; // Exit the method on invalid input
	    }
	    
	    System.out.println("****************************\n");
        System.out.print("Enter room number to book: ");
        int roomNo = scanner.nextInt();
	    
	    for (LinkedList<Booking> innerList : bookings) 
		{
            for (Booking booking : innerList) 
            {
            	if (proposedDate.equals(booking.getDate()))
                {
            		if(!booking.isAvailable() && booking.getCNIC() == currentCustomer.getCNIC() && roomNo == booking.getRoomNumber())
        			{
            			booking.CheckIN();
            			currentBooking = booking;
            			break;
        			}
                }
            }
        }
	}
	
	public void addToBill(Scanner scanner)
	{
		System.out.println("Enter item: ");
		String item = scanner.next();
		System.out.println("Enter price: ");
		double price = scanner.nextDouble();
		
		currentBooking.addBillItem(item, price);
		System.out.println("Item added to bill\n");
	}
	
	public void Checkout()
	{
		currentBooking.Display();
		System.out.println("\n");
		currentCustomer.Display();
		System.out.println("\n");
		System.out.println("Here is your bill: ");
		currentBooking.Display();
		currentBooking = null;
	}
	
}
