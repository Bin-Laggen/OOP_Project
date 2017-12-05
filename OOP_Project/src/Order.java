
public class Order extends ObjectList{
	
	Order()
	{
		super();
	}

	
	public boolean add(Product product, int quantity)
	{
		super.getList().add(new OrderDetails(product, quantity));
		super.setNoOfItems(super.getNoOfItems() + 1);
		System.out.println(product.toString() + " has been added");
		return true;
	}
	
	public void printOrder()
	{
		for(int i = 0; i < super.getTotal(); i++)
		{
			System.out.println((OrderDetails) super.getObject(i));
		}	
	}

}
