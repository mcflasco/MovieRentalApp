package MovieRentalApp;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("hiding")
public class Movie implements Comparable<Movie>
{
	public String title;
	public String genre;
	public int numberOfCopies;
	public String movieID;
	public ArrayList<Checkout> checkouts = new ArrayList<>();

	public Movie(String movieID, String title, String genre, int numberOfCopies)
	{
		this.movieID = movieID;
		this.title = title;
		this.genre = genre;
		this.numberOfCopies = numberOfCopies;

	}

	public String toString()
	{

		String result = "movie ID: " + movieID + ", title: " + title
				+ ", Genre: " + genre + ", NumberOfCopies: " + numberOfCopies
				+ " ";

		int count = checkouts.size();
		int index = 0;

		for(Checkout checkout : checkouts)
		{
			result += checkout;

			if(index != count - 1)
				result += ", ";

			index++;
		}
		return result;
	}

	@Override
	public int compareTo(Movie secondMovie)
	{
		return title.compareTo(secondMovie.title);
	}
}
