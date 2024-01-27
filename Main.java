  package com.example.task2;
  

  import java.util.Scanner;
  
  public class Main 
  {
  
	  public static void main(String[] args) 
	  {
		  Hotel H = new Hotel(); 
		  Scanner scanner = new Scanner(System.in);
		  
		  while(true)
		  {
			  System.out.println("1. Add Rooms");
			  System.out.println("2. Get Available Rooms");
			  System.out.println("3. Search Guest");
			  System.out.println("4. Add Guest");
			  System.out.println("5. Log into guest account");
			  System.out.println("6. Exit");
			  System.out.print("Enter choice: ");
			  int choice1 = scanner.nextInt();
			  
			  if(choice1 == 1)
			  {
				  H.addRoom(scanner);
			  }
			  else if (choice1 == 2) 
			  {
				  H.DisplayBookings();
			  }
			  else if (choice1 == 3) 
			  {
				  H.SearchGuest(scanner);
			  }
			  else if (choice1 == 4) 
			  {
				  H.addCustomer(scanner);
			  }
			  else if (choice1 == 5) 
			  {
				  H.Login(scanner);
				  
				  while(true)
				  {
					  System.out.println("1. Book Room");
					  System.out.println("2. Check IN");
					  System.out.println("3. Check Out");
					  System.out.println("4. Avail Room Services");
					  System.out.println("5. Go Back");
					  System.out.print("Enter choice: ");
					  int choice2 = scanner.nextInt();
					  
					  if(choice2 == 1)
					  {
						  H.BookRoom(scanner);
					  }
					  else if(choice2 == 2)
					  {
						  H.checkIN(scanner);
					  }
					  else if(choice2 == 3)
					  {
						  H.Checkout();
					  }
					  else if(choice2 == 4)
					  {
						  H.addToBill(scanner);
					  }
					  else if(choice2 == 5)
					  {
						  H.Login(scanner);
						  break;
					  }
					  else
					  {
						  System.out.println("Invalid Choice\n");
					  }
				  }
				  
			  }
			  else if (choice1 == 6) 
			  {
				  break;
			  }
			  else 
			  {
				  System.out.println("Invalid Choice\n");
			  }
			  
		  }
	  }
  
  }
 