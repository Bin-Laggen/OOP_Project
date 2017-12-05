
public class OrderDetails {

	private Product product;
	private int quantity;
	
	OrderDetails(Product inProduct, int inQuantity)
	{
		this.product = inProduct;
		this.quantity = inQuantity;
	}
	
	public String toString()
	{
		String output = "\tProduct: " + product.getName()
		+ "\n\tQuantity: " + quantity;
		return output;
	}
	
	public void print()
	{
		System.out.println(toString());
	}
}
