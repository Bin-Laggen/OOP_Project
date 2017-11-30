
public class Phone extends Product{

	private String make, model;
	private int storage;
	
	Phone(String inName, String inDescription, int inPrice, String inMake, String inModel, int inStorage)
	{
		super(inName, inDescription, inPrice);
		this.make = inMake;
		this.model = inModel;
		this.storage = inStorage;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	public String toString()
	{
		String output =	"\n\tMake: " + this.make
				+ "\n\tModel: " + this.model
				+ "\n\tStorage Capacity: " + this.storage + "GB";
		return output;
	}
	
	public void print()
	{
		super.print();
		System.out.println(toString());
	}
	
}
