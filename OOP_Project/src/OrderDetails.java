
public class OrderDetails {

	private Product product;
	private int quantity;
	
	OrderDetails(Product inProduct, int inQuantity)
	{
		this.product = inProduct;
		this.quantity = inQuantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString()
	{
		String output = product.toString()
		+ "\n\n\tQuantity: " + quantity + "\n";
		return output;
	}
	
	public void print()
	{
		System.out.println(toString());
	}
}
