

public class ProductDB extends ObjectList {
		
	ProductDB()
	{
		super();
	}
	
	public Product getProduct(int index)
	{
		return (Product) super.getObject(index);
	}
	
	public Product searchByID(int id)
	{
		int i = 0;
		boolean found = false;
		while(!found && i < super.getNoOfItems())
		{
			if(((Product) super.getList().get(i)).getProductID() == id)
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
			return (Product) super.getList().get(i);
		}
		else
		{
			System.out.println("ERROR - Product Not Found");
			return null;
		}
	}
}
