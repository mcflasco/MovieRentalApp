package MovieRentalApp;

import java.util.ArrayList;

public class Customer implements Comparable<Customer>
{
	static int nextID = 1000;
	public String firstName;
	public String lastName;
	public String address;
	public static ArrayList<Checkout> checkouts = new ArrayList<>();

	public int customerID;

	public Customer(String firstName, String lastName, String address)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.customerID = nextID++;
	}

	@Override
	public String toString()
	{
		return "ID: " + customerID + ", Name: " + firstName + " " + lastName
				+ ", Address: " + address;
	}

	public int compareTo(Customer secondCustomer)
	{
		return lastName.compareTo(secondCustomer.lastName);
	}

}
