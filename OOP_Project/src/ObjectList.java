import java.util.ArrayList;

public class ObjectList {
	

	private ArrayList<Object> list;

	public ObjectList()
	{
		list = new ArrayList<Object>();
	}

	public ArrayList<Object> getList() {
		return list;
	}

	public void setList(ArrayList<Object> list) {
		this.list = list;
	}

	public boolean isEmpty()
	{
		if(list.size() == 0)
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
		System.out.println(object.toString() + " has been added\n");
		return true;
	}
	
	public boolean remove(int index)
	{
		if(!isEmpty())
		{
			System.out.println(list.get(index).toString() + " removed");
			list.remove(index);
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
		return list.size();
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
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void print()
	{
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).toString());
		}
	}
}
