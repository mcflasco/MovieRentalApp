package MovieRentalApp;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Checkin
{
	
	public int customerID;
	public LocalDateTime checkoutDate;
	
	public Checkin(int customerID, LocalDateTime checkoutDate) {
		this.customerID = customerID;
		this.checkoutDate = checkoutDate;
	}
	
	public String toString() {
		return "(Customer ID: " + customerID + " Checkout Date: " + checkoutDate + ")";
	}

}