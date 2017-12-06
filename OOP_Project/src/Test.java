import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		
				//--------------------------//
				//------TEST BASIC OPS------//
				//--------------------------//
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Phone p = new Phone("Apple iPhone 6", "iPhone 6 Description", 400, "Apple", "iPhone 6", 64); // all parameters not shown 
		Phone p1 = new Phone("Samsung", "Galaxy S8 Description", 800, "Samsung", "Galaxy S8", 128); 
		
		TV t = new TV("LG OLED 4K", "LG TV Description", 2000, "LG", true, "LED", 55);
		TV t1 = new TV("Samsung HDR UHD", "Samsung TV Description", 1500, "Samsung", true, "Plasma", 60);
		
		System.out.println("Database Adds");
		ProductDB database = new ProductDB();
		database.add(p);
		database.add(p1);
		database.add(t);
		database.add(t1);
		
		System.out.println("Mary");
		Customer Mary = new Customer("Mary", "Cork");
		customers.add(Mary);
		Order o = new Order();
		o.add(p,12); // ordered 12 iphone 6 products
		o.add(p1,1); //ordered 1 Galaxy 8
		Mary.addOrder(o);
		
		System.out.println("Tom");
		Customer Tom = new Customer("Tom", "Dublin");
		customers.add(Tom);
		o.clear();
		o.add(t, 2);
		o.add(t1, 5);
		o.add(p, 0);
		Tom.addOrder(o);
		
		System.out.println("\nOrder Prints");
		System.out.println("Mary's Order");
		Mary.printOrder(0);
		System.out.println("Mary's All Orders");
		Mary.printAllOrders();
		System.out.println("Tom's Order");
		Tom.printOrder(0);
		System.out.println("Tom's All Orders");
		Tom.printAllOrders();
		
				//----------------------//
				//------TEST  MENU------//
				//----------------------//
		
		byte choice = 0;
		boolean run = true;
	
		do
		{
			System.out.println("\n1. Create a new phone"
					+ "\n2. Search for a product by ProductID"
					+ "\n3. Display all products in database"
					+ "\n4. Order products"
					+ "\n5. Display customer's orders"
					+ "\n6. Quit");
			choice = (byte) readIntegerInput(1, 6);
			
			switch(choice)
			{
			case 1:
				createPhone(database);
				break;
			case 2:
				System.out.println("Enter ProductID: ");
				Product tmp = database.searchByID(readIntegerInput(1, Integer.MAX_VALUE));
				if(tmp != null)
				{
					System.out.println(tmp.toString());
				}
				else
				{
					System.out.println("Not Found");
				}
				break;
			case 3:
				database.print();
				break;
			case 4:
				createOrder(customers, database);
				break;
			case 5:
				viewOrders(customers);
				break;
			case 6:
				run = false;
				System.out.println("Exiting...");
				break;
			}
			
		}
		while(choice > 0 && choice < 7 && run);
			
		System.out.println("Goodbye");
		
		kb.close();

	}
	
				//-------------------------//
				//------CREATE PHONE-------//
				//-------------------------//
	
	public static Phone createPhone(ProductDB DB)
	{
		System.out.println("Enter phone details below");
		System.out.println("Name: ");
		String name = readString();
		System.out.println("Description: ");
		String desc = readString();
		System.out.println("Price: ");
		int price = readIntegerInput(0, Integer.MAX_VALUE);
		System.out.println("Make: ");
		String make = readString();
		System.out.println("Model: ");
		String model = readString();
		System.out.println("Storage capacity: ");
		int storage = readIntegerInput(0, Integer.MAX_VALUE);
		Phone tmp = new Phone(name, desc, price, make, model, storage);
		DB.add(tmp);
		return tmp;
		
	}
	
				//-------------------------//
				//------CREATE ORDER-------//
				//-------------------------//
	
	public static void createOrder(ArrayList<Customer> custList, ProductDB DB)
	{
		Order ord = new Order();
		System.out.println("Enter customer name: ");
		String custName = readString();
		Customer cust = null;
		Product tmp = null;
		
		//FIND CUSTOMER BY NAME
		
		int quantity;
		int i = 0;
		boolean found = false;
		while(!found && i < custList.size())
		{
			if(custList.get(i).getName().equalsIgnoreCase(custName))
			{
				cust = custList.get(i);
				found = true;
			}
			else
			{
				i++;
			}
		}
		
		//IF CUSTOMER IS ON THE LIST
		
		if(found)
		{
			boolean inLoop = true;
			char choiceChar = 'y';
			do
			{
				if(choiceChar == 'y' || choiceChar == 'Y')
				{
					byte choiceNo1 = 0;
					System.out.println("Would you like to:"
							+ "\n1. Create a new item"
							+ "\n2. Select items from database");

					choiceNo1 = (byte) readIntegerInput(1, 2);
				
					switch(choiceNo1)
					{
					
					//ADD ITEM TO DB
					
					case 1:
						byte choiceNo2 = 0;
						System.out.println("\n1. Create a phone"
								+ "\n2. Create a tv");
						choiceNo2 = (byte) readIntegerInput(1, 2);

						switch(choiceNo2)
						{
						case 1:
							tmp = createPhone(DB);
							System.out.println("Enter Quantity: ");
							quantity = readIntegerInput(0, Integer.MAX_VALUE);
							ord.add(tmp, quantity);
							break;
						case 2:
							tmp = createTV(DB);
							System.out.println("Enter Quantity: ");
							quantity = readIntegerInput(0, Integer.MAX_VALUE);
							ord.add(tmp, quantity);
							break;
						}
						break;
						
					//SELECT FROM LIST
						
					case 2:
						
						
						System.out.println("Enter ProductID (-1 to display all products): ");
						int id = readIntegerInput(-1, Integer.MAX_VALUE);
						if(id == -1)
						{
							DB.print();
							System.out.println("Enter ProductID (-1 to display all products): ");
							id = readIntegerInput(1, Integer.MAX_VALUE);
						}
						tmp = DB.searchByID(id);
						if(tmp != null)
						{
							System.out.println("Enter Quantity: ");
							quantity = readIntegerInput(0, Integer.MAX_VALUE);
							ord.add(tmp, quantity);
						}
						break;
					}

					System.out.print("Would you like to add another product? (y/n): "
							+ "\n ==> ");
					choiceChar = kb.next().charAt(0);
				}
				else
				{
					inLoop = false;
				}

			}
			while(inLoop);
			if(cust.addOrder(ord))
			{
				System.out.println("Order added successfully...");
			}
			else
			{
				System.out.println("Empty Order - Not Added");
			}
		}
		else
		{
			System.out.println("Customer not found."
					+ "\n1. Retry"
					+ "\n2. Add New Customer"
					+ "\n3. Return to Menu");
			byte choiceNo3 = (byte) readIntegerInput(1, 3);
			
			switch(choiceNo3)
			{
			case 1:
				createOrder(custList, DB);
				break;
			case 2:
				createCustomer(custList);
				createOrder(custList, DB);
				break;
			case 3:
				break;
			}
		}
	}
	
				//----------------------//
				//------CREATE TV-------//
				//----------------------//
	
	public static TV createTV(ProductDB DB)
	{
		System.out.println("Enter TV details below");
		System.out.println("Name: ");
		String name = readString();
		System.out.println("Description: ");
		String desc = readString();
		System.out.println("Price: ");
		int price = readIntegerInput(0, Integer.MAX_VALUE);
		System.out.println("Make: ");
		String make = readString();
		System.out.println("3D capable (True/False): ");
		boolean capable3D = kb.nextBoolean();
		kb.nextLine();
		System.out.println("TV Type: ");
		String type = readString();
		System.out.println("Size: ");
		int size = readIntegerInput(0, Integer.MAX_VALUE);
		TV tmp = new TV(name, desc, price, make, capable3D, type, size);
		DB.add(tmp);
		return tmp;
	}
	
				//------------------------//
				//------VIEW ORDERS-------//
				//------------------------//
	
	public static void viewOrders(ArrayList<Customer> custList)
	{
		System.out.println("Enter customer name: ");
		String custName = readString();
		Customer cust = null;
		
		//FIND CUSTOMER BY NAME
		
		int i = 0;
		boolean found = false;
		while(!found && i < custList.size())
		{
			if(custList.get(i).getName().equalsIgnoreCase
					(custName))
			{
				cust = custList.get(i);
				found = true;
			}
			else
			{
				i++;
			}
		}
		
		if(found)
		{
			cust.printAllOrders();
		}
		else
		{
			System.out.println("Customer not found."
					+ "\n1. Retry"
					+ "\n2. Add New Customer"
					+ "\n3. Return to Menu");
			byte choiceNo3 = (byte) readIntegerInput(1, 3);
			
			switch(choiceNo3)
			{
			case 1:
				viewOrders(custList);
				break;
			case 2:
				createCustomer(custList);
				viewOrders(custList);
				break;
			case 3:
				break;
			}
		}
	}

				//----------------------------//
				//------CREATE CUSTOMER-------//
				//----------------------------//
	
	public static boolean createCustomer(ArrayList<Customer> custList)
	{
		System.out.println("Enter Customer Details");
		System.out.println("Name: ");
		String name = readString();
		System.out.println("Address: ");
		String address = readString();
		Customer cust = new Customer(name, address);
		custList.add(cust);
		System.out.println("Customer " + name + " added");
		return true;
	}
	
				//---------------------//
				//------READ INT-------//
				//---------------------//
	
	private static int readIntegerInput(int minValue, int maxValue) 
	{
		int choice = 0;
		boolean ok = false;
		do
		{
			try
			{
				System.out.print(" ==> ");
				choice = kb.nextInt();
				kb.nextLine();
				if ((choice >= minValue) && (choice <= maxValue))
				{
					ok = true;
				}
				else 
				{
					System.out.println("ERROR - number between " + minValue + " and " + maxValue + ".");
				}
			}
			catch(Exception e)
			{
				System.out.println("ERROR-enter a whole number.");
				kb.nextLine();
			}
		}
		while(!ok);
		return choice;
	}
	
				//------------------------//
				//------READ STRING-------//
				//------------------------//
	
	public static String readString()
	{
		String input = null;
		boolean ok = false;
		do
		{
			try
			{
				System.out.print(" ==> ");
				input = kb.nextLine();
				if(input.length() > 0)
				{
					ok = true;
				}
				else
				{
					System.out.println("String must be at least 1 char long");
				}
			}
			catch(Exception e)
			{
				System.out.println("ERROR - at least 1 char long");
				kb.nextLine();
			}
		}
		while(!ok);
		
		return input;
	}

}
