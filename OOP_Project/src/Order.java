
public class Order extends ProductDB{
	
	Order()
	{
		super();
	}
	
	public boolean add(Product product, int quantity)
	{
		for(int i = 0; i < quantity; i++)
		{
			super.add(product);
		}
		return true;
	}
	
	public void printOrder()
	{
		for(int i = 0; i < super.getTotal(); i++)
		{
			System.out.println(super.getObject(i));
		}
	}

}
