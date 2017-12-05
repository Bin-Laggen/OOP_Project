
public class OrderDetails {

	private Product product;
	private int quantity;
	
	OrderDetails(Product inProduct, int inQuantity)
	{
		this.product = inProduct;
		this.quantity = inQuantity;
	}
	
	public void print()
	{
		System.out.println("Product: " + product.getName()
							+ "\nQuantity: " + quantity);
	}
}
