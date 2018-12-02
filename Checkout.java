package MovieRentalApp;

import java.time.LocalDateTime;
import java.text.NumberFormat;

public class Checkout
{

	NumberFormat format = NumberFormat.getCurrencyInstance();
	public int customerID;
	public LocalDateTime checkoutDate;
	public int rentalAmount = 5;

	public Checkout(int customerID, int rentalAmount,
			LocalDateTime checkoutDate)
	{
		this.customerID = customerID;
		this.rentalAmount = rentalAmount;
		this.checkoutDate = checkoutDate;
	}

	public String toString()
	{
		return "(Customer ID: " + customerID + ", RentalAmount: "
				+ format.format(rentalAmount) + ", Checkout Date: "
				+ checkoutDate + ")";
	}

	public int overDue()
	{
		if(checkoutDate.compareTo(checkoutDate) > 5)
			return rentalAmount = rentalAmount + 1;

		return rentalAmount;

	}

	public int totalRevenue()
	{
		int total = 0;
		return total += rentalAmount;
	}

}
