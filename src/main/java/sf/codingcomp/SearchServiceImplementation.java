package sf.codingcomp;

import java.util.ArrayList;
import java.util.List;

import sf.codingcomp.model.Entertainment;
import sf.codingcomp.model.Game;
import sf.codingcomp.model.Movie;
import sf.codingcomp.model.Platform;
import sf.codingcomp.reader.Reader;

public class SearchServiceImplementation implements SearchService {

	@Override
	public List<Movie> searchMovie(String searchValue) {
		Reader reader = new Reader();
		List<Movie> movies = reader.readMovies();
		List<Movie> results = new ArrayList<>();
		for (Movie movie: movies) {
			if(movie.getTitle().toLowerCase().contains(searchValue.toLowerCase())){
				results.add(movie);
			}
		}
		return results;
	}

	@Override
	public List<Game> searchGame(String searchValue) {
		Reader reader = new Reader();
		List<Game> games = reader.readGames();
		List<Game> results = new ArrayList<>();
		for (Game movie: games) {
			if(movie.getTitle().toLowerCase().contains(searchValue.toLowerCase())){
				results.add(movie);
			}
		}
		return results;
	}

	@Override
	public List<Entertainment> searchGameAndMovies(String searchValue) {
		Reader reader = new Reader();
		List<Entertainment> moviesAndGames = reader.readGamesAndMovies();
		List<Entertainment> results = new ArrayList<>();
		for (Entertainment item: moviesAndGames) {
			if(item.getTitle().toLowerCase().contains(searchValue.toLowerCase())){
				results.add(item);
				System.out.println(item);
			}
		}
//
//		List<Game> games = reader.readGames();
//		List<Game> gameResults = new ArrayList<>();
//		for (Game movie: games) {
//			if(movie.getTitle().toLowerCase().contains(searchValue.toLowerCase())){
//				gameResults.add(movie);
//			}
//		}
//
//		List<Entertainment> entertainments = new ArrayList<>();
//		entertainments.add(movieResults);
//		System.out.print(results);
		return results;
	}

	@Override
	public List<Movie> sortMoviesByDate(String searchValue, Double userRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> sortGamesByDate(String searchValue, Double userRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entertainment> sortGamesAndMoviesByDate(String searchValue,
			Double userRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> moviesByGenreAndRating(String Genre, String Rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> gamesByGenreAndRating(String Genre, String Rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entertainment> entertainmentByGenreAndRating(String Genre,
			String Rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entertainment> void checkout(T title, Platform<T> platform) {
		// TODO Auto-generated method stub

	}

}
