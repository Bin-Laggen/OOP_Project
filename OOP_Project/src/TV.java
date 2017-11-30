
public class TV extends Product {

	private String make, tvType;
	private boolean capable3D;
	private int size;
	
	TV(String inName, String inDescription, int inPrice, String inMake, boolean in3D, String inType, int inSize)
	{
		super(inName, inDescription, inPrice);
		this.make = inMake;
		this.tvType = inType;
		this.capable3D = in3D;
		this.size = inSize;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public boolean isCapable3D() {
		return capable3D;
	}

	public void setCapable3D(boolean capable3d) {
		capable3D = capable3d;
	}

	public String getType()
	{
		return tvType;
	}
	
	public void setType(String type) {
		this.tvType = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString()
	{
		String output = "\n\tMake: " + this.make
				+ "\n\tType: " + this.tvType
				+ "\n\tSize: " + this.size + "\""
				+ "\n\t3D Capable: " + this.capable3D;
		return output;
	}
	
	public void print()
	{
		super.print();
		System.out.println(toString());
	}
}
