package MovieRentalApp;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MovieApplication
{

	static Scanner input;
	static MovieStore movieStore;

	public static void main(String[] args)
	{
		movieStore = new MovieStore();

		input = new Scanner(System.in);

		// ==================================================
		// MENU
		// ==================================================
		boolean run = true;
		while(run)
		{

			System.out.println();
			System.out.print("Enter command ('help' for help): ");

			String menu = input.nextLine();
			System.out.println();

			switch(menu)
			{
				case "help":
					System.out.println("add-movie - Add a movie");
					System.out.println("edit-movie - Edit a movie");
					System.out.println("delete-movie - Delete a movie");
					System.out.println("add-genre - Add a genre");
					System.out.println("edit genre - Edit a genre");
					System.out.println("delete-genre - Delete a genre");
					System.out.println("add-customer - Add a Customer");
					System.out.println("edit-customer - Edit a customer");
					System.out.println("delete-customer - Delet a customer");
					System.out.println("check-out - Checkout a movie");
					System.out.println("check-in - Check in a movie");
					System.out.println("report-overdue - Overdue movie report");
					System.out.println("report-customers - List all customers");
					System.out.println("report-Movies - List all movies");
					System.out.println("report-genres - List all genres");
					System.out.println("movie-search - Find movie");
					System.out.println("Help - Show help menu");
					System.out.println("Exit - Exit program");
					break;

				case "add-movie":
					addMovie(); // done
					break;

				case "edit-movie":
					editMovie(); // done
					break;

				case "delete-movie":
					deleteMovie(); // done
					break;

				case "add-genre":
					addGenre(); // done
					break;

				case "edit-genre":
					editGenre(); // done
					break;

				case "delete-genre":
					deleteGenre();// done
					break;

				case "add-customer":
					addCustomer(); // done
					break;

				case "edit-customer":
					editCustomer(); // done
					break;

				case "delete-customer":
					deleteCustomer(); // done
					break;

				case "check-out":
					checkout(); // done
					break;

				case "check-in":
					checkin(); // not done
					break;

				case "report-overdue": // not done
					break;

				case "report-customers":
					reportCustomers(); // done
					break;

				case "report-movies":
					reportMovies(); // done
					break;

				case "report-genres":
					reportGenres(); // done
					break;

				case "exit":
					run = false; // done
					break;

			}
		}

		input.close();
	}

	// ==================================================
	// CHECKOUT
	// ==================================================
	private static void checkout()
	{
		String movieID = null;
		int customerID = 0;
		do
		{
			System.out.print("Enter the movie id: ");
			movieID = input.nextLine();
			if(movieID.length() < 1)
			{
				System.out.println("You must enter a value.");
			}
		}
		while(movieID.length() < 1);

		System.out.print("the rentalAmount is: $5.00. Press Enter to proceed ");
		String next = input.nextLine();
		int rentalAmount = 5;

		Movie movie = movieStore.getMovie(movieID);
		if(movie == null)
		{
			System.out.println("Not found!");
			return;
		}
		do
		{
			System.out.print("Enter customer ID: ");
			customerID = input.nextInt();
			if(customerID < 1001)
			{
				System.out.println("You must enter a value.");
			}
		}
		while(customerID < 1000);
		MovieStore.checkout(movie, rentalAmount, customerID);

	}

	// ==================================================
	// CHECKIN
	// ==================================================
	private static void checkin()
	{
		String movieID = null;
		int customerID = 0;
		do
		{
			System.out.print("Enter the movie id: ");
			movieID = input.nextLine();
			if(movieID.length() < 1)
			{
				System.out.println("You must enter a value.");
			}
		}
		while(movieID.length() < 1);

		System.out.print("the rentalAmount is: $5.00. Press Enter to proceed ");

		int rentalAmount = 5;

		Movie movie = MovieStore.getMovie(movieID);
		if(movie == null)
		{
			System.out.println("Not found!");
			return;
		}
		do
		{
			System.out.print("Enter customer ID: ");
			customerID = input.nextInt();
			if(customerID < 1001)
			{
				System.out.println("You must enter a value.");
			}
		}
		while(customerID < 1000);
		MovieStore.checkin(movie, rentalAmount, customerID);

	}

	// ==================================================
	// ADD MOVIE
	// ==================================================
	public static void addMovie()
	{

		System.out.print("Enter new movie movieID: ");
		String movieID = input.nextLine();

		System.out.print("Enter new movie title: ");
		String newTitle = input.nextLine();

		System.out.print("Enter new movie Genre: ");
		String newGenre = input.nextLine();

		System.out.print("Enter number of copies: ");
		int copies = input.nextInt();

		Movie movie = new Movie(movieID, newTitle, newGenre, copies);
		movieStore.movies.add(movie);
		movieStore.movieIndex.put(movieID, movie);

		

	}

	// ==================================================
	// EDIT MOVIE
	// ==================================================

	private static void editMovie()
	{
		System.out.print("Enter the MovieID: ");
		String movieID = input.nextLine();

		Movie movie = MovieStore.getMovie(movieID);
		if(movie == null)
		{
			System.out.println("Not found!");
			return;
		}

		
		System.out.println("Current movie info: " + movie);

		
		System.out.print("New movie title (" + movie.title + "): ");
		String newTitle = input.nextLine();

		System.out.print("New genre (" + movie.genre + "): ");
		String newGenre = input.nextLine();
		System.out.print("New # of copies (" + movie.numberOfCopies + "): ");
		int copies = input.nextInt();

		
		if(!newTitle.equals(""))
			movie.title = newTitle;

		if(!newGenre.equals(""))
			movie.genre = newGenre;
		if(copies > 0)
			movie.numberOfCopies = copies;
	}

	// ==================================================
	// DELETE MOVIES
	// ==================================================
	public static void deleteMovie()
	{
		System.out.print("Enter the MovieID: ");
		String movieID = input.nextLine();

		Movie movie = MovieStore.getMovie(movieID);
		if(movie == null)
		{
			System.out.println("Not found!");
			return;
		}
		movieStore.movies.remove(movie);
	}

	// ==================================================
	// ADD GENRES
	// ==================================================
	public static void addGenre()
	{
		System.out.print("Enter new genre name: ");
		String genre = input.nextLine();
		movieStore.genres.add(genre);
	}

	// ==================================================
	// EDIT GENRES
	// ==================================================

	public static void editGenre()
	{
		System.out.println("Enter the genre to edit: ");
		String genre = input.nextLine();
		System.out.println("Enter a new genre: ");
		String newGenre = input.nextLine();

		for(int i = 0; i < movieStore.genres.size(); i++)
		{
			if(movieStore.genres.get(i).toString().equals(genre))
			{
				movieStore.genres.remove(genre);
				movieStore.genres.add(newGenre);
			}
		}

	}

	// ==================================================
	// DELETE GENRES
	// ==================================================

	public static void deleteGenre()
	{
		System.out.println("Enter the genre to be delete: ");
		String genre = input.nextLine();

		for(int i = 0; i < movieStore.genres.size(); i++)
		{
			if(movieStore.genres.get(i).toString().equals(genre))
			{
				movieStore.genres.remove(genre);

			}
		}
	}
	// ==================================================
	// ADD CUSTOMER
	// ==================================================

	public static void addCustomer()
	{

		System.out.print("Enter new first name ");
		String firstName = input.nextLine();

		System.out.print("Enter new last name: ");
		String lastName = input.nextLine();

		System.out.print("Enter new address: ");
		String address = input.nextLine();

		Customer customer = new Customer(firstName, lastName, address);
		movieStore.customers.add(customer);
	}

	// ==================================================
	// EDIT CUSTOMER
	// ==================================================

	public static void editCustomer()
	{

		System.out.print("Enter the customer ID: ");
		int customerID = input.nextInt();

		for(int i = 0; i < movieStore.customers.size(); i++)
		{
			if(movieStore.customers.get(i).customerID == customerID)
			{
				System.out.println(" Current customer info: "
						+ movieStore.customers.get(i));

				System.out.print("New first name ("
						+ movieStore.customers.get(i).firstName + "): ");
				String firstName = input.nextLine();
				String test = input.nextLine();
				System.out.print("New last name ("
						+ movieStore.customers.get(i).lastName + "): ");
				String lastName = input.nextLine();

				System.out.print("New address ("
						+ movieStore.customers.get(i).address + "): ");
				String address = input.nextLine();

				
				if(!firstName.equals(""))
					movieStore.customers.get(i).firstName = firstName;

				if(!lastName.equals(""))
					movieStore.customers.get(i).lastName = lastName;
				if(!address.equals(""))
					movieStore.customers.get(i).address = address;
			}
		}

		// print out current book information

	}

	// ==================================================
	// DELETE CUSTOMER
	// ==================================================
	public static void deleteCustomer()
	{

		System.out.print("Enter the customer ID: ");
		int customerID = input.nextInt();
		for(int i = 0; i < movieStore.customers.size(); i++)
		{
			if(movieStore.customers.get(i).customerID == customerID)
			{
				System.out.println(
						"Deleted customer: " + movieStore.customers.get(i));
				movieStore.customers.remove(i);

			}
		}
	}

	// ==================================================
	// REPORT MOVIES
	// ==================================================

	public static void reportMovies()
	{
		Collections.sort(movieStore.movies);
		for(Movie movies : movieStore.movies)
			System.out.println(movies);

	}

	// ==================================================
	// REPORT GENRES
	// ==================================================
	public static void reportGenres()
	{
		Collections.sort(movieStore.genres);
		for(String genre : movieStore.genres)
			System.out.println(genre);
	}

	// ==================================================
	// REPORT CUSTOMERS
	// ==================================================

	public static void reportCustomers()
	{

		Collections.sort(movieStore.customers);
		for(Customer customer : movieStore.customers)
			System.out.println(customer.toString());

	}

}
