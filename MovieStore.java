package MovieRentalApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MovieStore
{

	public ArrayList<String> genres = new ArrayList<>();

	public ArrayList<Movie> movies = new ArrayList<>();
	public static HashMap<String, Movie> movieIndex = new HashMap<>();
	public ArrayList<Customer> customers = new ArrayList<>();
	// public static HashMap<Integer, Customer> customerIndex = new HashMap<>();

	public MovieStore()
	{
		customers.add(new Customer("Jason", "Smith", "134 Orlando Ave"));
		customers.add(new Customer("Mike", "Johnson", "555 Park Ave"));
		customers.add(new Customer("Ryan", "Jackson", "784 Winter Park Rd"));
		customers.add(new Customer("Sean", "Steveson", "147 Aloma ST"));
		customers.add(new Customer("Jessica", "Davis", "124 Orange Ave"));
		customers.add(new Customer("Mary", "Butler", "425 Lake Dr"));
		customers.add(new Customer("John", "Smith", "785 Winter Park Rd"));
		customers.add(new Customer("Mario", "Mario", "155 Goldenrod ST"));
		customers.add(new Customer("Luigi", "Luigi", "155 Goldenrod ST"));

		// for(Customer customer : customers)
		// customerIndex.put(Customer.customerID, customer);

		movies.add(new Movie("1", "Fight Club", "Drama", 5));
		movies.add(new Movie("8", "Boondock Saints", "Action", 3));
		movies.add(new Movie("5", "Army of Darkness", "Sci fi", 2));
		movies.add(new Movie("3", "Last Action Hero", "Action", 5));
		movies.add(new Movie("6", "Fracture", "Drama", 6));
		movies.add(new Movie("2", "Evil Dead", "Horror", 2));
		movies.add(new Movie("10", "The Shinning", "Horror", 7));
		movies.add(new Movie("4", "Ace Ventura ", "Comedy", 10));
		movies.add(new Movie("9", "Year One", "Comedy", 5));
		movies.add(new Movie("7", "Meet Joe Black", "Romance", 4));

		for(Movie movie : movies)
			movieIndex.put(movie.movieID, movie);

		genres.add("Horror");
		genres.add("Sci Fi");
		genres.add("Action");
		genres.add("Comedy");
		genres.add("Romance");
		genres.add("Thriller");

	}

	public static void checkout(Movie movie, int rentalAmount, int customerID)
	{
		LocalDateTime date = LocalDateTime.now();
		movie.checkouts.add(new Checkout(customerID, rentalAmount, date));

		Customer.checkouts.add(new Checkout(customerID, rentalAmount, date));

	}

	public static void checkin(Movie movie, int rentalAmount, int customerID)
	{
		LocalDateTime date = LocalDateTime.now();
		movie.checkouts.add(new Checkout(customerID, rentalAmount, date));

		Customer.checkouts.add(new Checkout(customerID, rentalAmount, date));

	}

	public static Movie getMovie(String movieID)
	{
		return movieIndex.get(movieID);
	}

	// public static Customer getCustomer(int customerID)
	// {
	// return customerIndex.get(customerID);
	// }

}
