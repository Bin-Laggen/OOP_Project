import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Phone p = new Phone("Apple iPhone 6", "iPhone 6 Description", 400, "Apple", "iPhone 6", 64); // all parameters not shown 
		Phone p1 = new Phone("Samsung", "Galaxy S8 Description", 800, "Samsung", "Galaxy S8", 128); 
		
		TV t = new TV("LG OLED 4K", "LG TV Description", 2000, "LG", true, "LED", 55);
		TV t1 = new TV("Samsung HDR UHD", "Samsung TV Description", 1500, "Samsung", true, "Plasma", 60);
		
		System.out.println("Database Adds");
		ProductDB database = new ProductDB();
		database.add(p1);
		database.add(p);
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
		
		System.out.println("Order Prints");
		System.out.println("Mary's Order");
		Mary.printOrder(0);
		Mary.printAllOrders();
		System.out.println("Tom's Order");
		Tom.printOrder(0);
		Tom.printAllOrders();
		
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
		System.out.println(tmp.toString() + " has been added successfully");
		return tmp;
		
	}
	
	public static void createOrder(ArrayList<Customer> custList, ProductDB DB)
	{
		Order ord = new Order();
		System.out.println("Enter customer name: ");
		String custName = readString();
		Customer cust = null;
		
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
					case 1:
						byte choiceNo2 = 0;
						do
						{
							System.out.println("\n1. Create a phone"
									+ "\n2. Create a tv"
									+ "\n==> ");
							choiceNo2 = (byte) readIntegerInput(1, 2);

							switch(choiceNo2)
							{
							case 1:
								ord.add(createPhone(DB));
								break;
							case 2:
								ord.add(createTV(DB));
								break;
							}
						}
						while(choiceNo2 > 0 && choiceNo2 < 3);
						break;
					case 2:
						System.out.println("Enter ProductID: ");
						Product tmp = DB.searchByID(readIntegerInput(1, Integer.MAX_VALUE));
						ord.add(tmp);
						break;
					}

					System.out.println("Would you like to add another product? (y/n): ");
					choiceChar = kb.next().charAt(0);
				}
				else
				{
					inLoop = false;
				}

			}
			while(inLoop);
			cust.addOrder(ord);
			System.out.println("Order added successfully...");
		}
		else
		{
			System.out.println("Customer not found. Retry? (y/n) ");
			char retry = kb.next().charAt(0);
			if(retry == 'y' || retry == 'Y')
			{
				createOrder(custList, DB);
			}
		}
	}
	
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
		System.out.println("3D capable: ");
		boolean capable3D = kb.nextBoolean();
		System.out.println("TV Type: ");
		String type = readString();
		System.out.println("Size: ");
		int size = readIntegerInput(0, Integer.MAX_VALUE);
		TV tmp = new TV(name, desc, price, make, capable3D, type, size);
		DB.add(tmp);
		System.out.println(tmp.toString() + " has been added successfully");
		return tmp;
	}
	
	public static void viewOrders(ArrayList<Customer> custList)
	{
		System.out.println("Enter customer name: ");
		String custName = readString();
		Customer cust = null;
		
		int i = 0;
		boolean found = false;
		while(!found && i < custList.size())
		{
			if(custList.get(i).getName().equals(custName))
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
			System.out.println("Customer not found. Retry? (y/n) ");
			char retry = kb.next().charAt(0);
			if(retry == 'y' || retry == 'Y')
			{
				viewOrders(custList);
			}
		}
	}
	
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
				if(input.length() >= 1)
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
