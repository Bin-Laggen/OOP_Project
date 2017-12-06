
public class Product {

	private String name, description;
	private int price;
	private int productID;
	private static int IDCreator = 1;
	
	Product(String inName, String inDescription, int inPrice)
	{
		this.name = inName;
		this.description = inDescription;
		this.price = inPrice;
		this.productID = IDCreator++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public String toString()
	{
		String output = "\nProduct Details"
				+ "\n---------------"
				+ "\n\tProductID: " + this.productID
				+ "\n\tName: " + this.name
				+ "\n\tDescription: " + this.description
				+ "\n\tPrice: €" + this.price;
		return output;
	}
	
	public void print()
	{
		System.out.println(toString());
	}
}
