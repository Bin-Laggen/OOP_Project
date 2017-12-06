import java.util.ArrayList;

public class Customer {

	private String name, address;
	private ArrayList<Order> orderList;
	
	Customer(String inName, String inAddress)
	{
		this.name = inName;
		this.address = inAddress;
		orderList = new ArrayList<Order>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	
	public boolean addOrder(Order order)
	{
		if(!order.isEmpty())
		{
			Order newOrder = new Order();
			for(int i = 0; i < order.getTotal(); i++)
			{
				newOrder.add(((OrderDetails) order.getObject(i)).getProduct(), ((OrderDetails) order.getObject(i)).getQuantity());
			}
			orderList.add(newOrder);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean removeOrder(Order order)
	{
		if(orderList.contains(order))
		{
			orderList.remove(order);
			return true;
		}
		else
		{
			System.out.println("Order not found");
			return false;
		}
	}
	
	public void printOrder(int index)
	{
		if(!orderList.isEmpty())
		{
			orderList.get(index).printOrder();
		}
	}
	
	public void printAllOrders()
	{
		if(!orderList.isEmpty())
		{
			for(int i = 0; i < orderList.size(); i++)
			{
				System.out.println("Order " + (i + 1));
				orderList.get(i).printOrder();
			}
		}
		else
		{
			System.out.println("No Orders");
		}
	}
}
