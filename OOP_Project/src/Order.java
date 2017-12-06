
public class Order extends ObjectList{
	
	Order()
	{
		super();
	}

	
	public boolean add(Product product, int quantity)
	{
		if(quantity > 0)
		{
			super.getList().add(new OrderDetails(product, quantity));
			System.out.println(product.toString() + " has been added\n");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void printOrder()
	{
		for(int i = 0; i < super.getTotal(); i++)
		{
			System.out.println((OrderDetails) super.getObject(i));
		}	
	}

}
