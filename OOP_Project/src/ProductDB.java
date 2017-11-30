import java.util.ArrayList;

public class ProductDB {
	
	private ArrayList<Product> list;
	private int noOfItems;
	
	ProductDB()
	{
		list = new ArrayList<Product>();
	}
	
	public boolean isEmpty()
	{
		if(noOfItems == 0)
		{
			System.out.println("List is empty");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean add(Product object)
	{
		list.add(object);
		noOfItems++;
		System.out.println(object.toString() + " has been added");
		return true;
	}
	
	public boolean remove(int index)
	{
		if(!isEmpty())
		{
			System.out.println(list.get(index).toString() + " removed");
			list.remove(index);
			noOfItems--;
			return true;
		}
		else
		{
			System.out.println("List empty - object not removed");
			return false;
		}
	}
		
	public int getTotal()
	{
		return noOfItems;
	}
	
	public Product getObject(int index)
	{
		return list.get(index);
	}
	
	
	public boolean clear()
	{
		if(!isEmpty())
		{
			list.clear();
			this.noOfItems = 0;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Product searchByID(int id)
	{
		int i = 0;
		boolean found = false;
		while(!found && i < noOfItems)
		{
			if(list.get(i).getProductID() == id)
			{
				found = true;
			}
			else
			{
				i++;
			}
		}
		if(found)
		{
			return list.get(i);
		}
		else
		{
			System.out.println("ERROR - Product Not Found");
			return null;
		}
	}
	
	public void print()
	{
		for(int i = 0; i < noOfItems; i++)
		{
			System.out.println(list.get(i).toString());
		}
	}

}
