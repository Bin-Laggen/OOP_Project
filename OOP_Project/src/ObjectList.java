import java.util.ArrayList;

public class ObjectList {
	

	private ArrayList<Object> list;
	private int noOfItems;

	public ObjectList()
	{
		list = new ArrayList<Object>();
		noOfItems = 0;
	}

	public ArrayList<Object> getList() {
		return list;
	}

	public void setList(ArrayList<Object> list) {
		this.list = list;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
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
	
	public Object getObject(int index)
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
	
	public void print()
	{
		for(int i = 0; i < noOfItems; i++)
		{
			System.out.println(list.get(i).toString());
		}
	}
}
