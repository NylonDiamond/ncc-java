package sf.codingcomp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
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
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
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
        for (Game movie : games) {
            if (movie.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
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
        for (Entertainment item : moviesAndGames) {
            if (item.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
                results.add(item);
//                System.out.println(item);
            }
        }
        return results;
    }

    @Override
    public List<Movie> sortMoviesByDate(String searchValue, Double userRating) {
        Reader reader = new Reader();
        List<Movie> movies = reader.readMovies();
        List<Movie> results = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(searchValue.toLowerCase()) && Double.parseDouble(movie.getUserRating()) >= userRating) {
                results.add(movie);
            }
        }
        System.out.println(results.size());
        for (int i = 0; i < results.size() - 1; i++) {
            Double first = Double.parseDouble(results.get(i).getReleased().substring(7, 11));
            Double second = Double.parseDouble(results.get(i + 1).getReleased().substring(7, 11));
            if (first < second) {
                //thanks Moses
                Movie temp = results.get(i);
                results.set(i, results.get(i + 1));
                results.set(i + 1, temp);
            }
        }
//        System.out.println(results.get(0).getReleased().substring(7, 11));
//        System.out.println(results.get(1).getReleased().substring(7, 11));
        return results;
    }

    @Override
    public List<Game> sortGamesByDate(String searchValue, Double userRating) {
        Reader reader = new Reader();
        List<Game> games = reader.readGames();

        List<Game> results = new ArrayList<>();

        for (Game game : games) {
            if (game.getTitle().toLowerCase().contains(searchValue.toLowerCase()) && Double.parseDouble(game.getUserRating()) >= userRating) {
                results.add(game);
            }
        }
        System.out.println(results.size());
        for (int i = 0; i < results.size() - 1; i++) {
            Double first = Double.parseDouble(results.get(i).getReleased().substring(7, 11));
            Double second = Double.parseDouble(results.get(i + 1).getReleased().substring(7, 11));
            if (first < second) {
                Game temp = results.get(i);
                results.set(i, results.get(i + 1));
                results.set(i + 1, temp);
            }
        }
        return results;
    }

    @Override
    public List<Entertainment> sortGamesAndMoviesByDate(String searchValue,
                                                        Double userRating) {
        Reader reader = new Reader();
        List<Entertainment> moviesAndGames = reader.readGamesAndMovies();

        List<Entertainment> results = new ArrayList<>();

        for (Entertainment item : moviesAndGames) {
            if (item.getTitle().toLowerCase().contains(searchValue.toLowerCase()) && Double.parseDouble(item.getUserRating()) >= userRating) {
//                System.out.println(item);
                results.add(item);
            }
        }

        for (int x = 0; x < results.size(); x++) {
            for (int i = 0; i < results.size() - 1 - x; i++) {
                Double first = Double.parseDouble(results.get(i).getReleased().substring(7, 11));
                Double second = Double.parseDouble(results.get(i + 1).getReleased().substring(7, 11));
                if (first < second) {
                    Entertainment temp = results.get(i);
                    results.set(i, results.get(i + 1));
                    results.set(i + 1, temp);
                }
            }
        }
        return results;
    }

    @Override
    public List<Movie> moviesByGenreAndRating(String Genre, String Rating) {
        Reader reader = new Reader();
        List<Movie> movies = reader.readMovies();
        List<Movie> results = new ArrayList<>();

        for (Movie movie : movies) {
            String[] genres = movie.getGenre().split(",");
            if (movie.getGenre().toLowerCase().contains(Genre.toLowerCase()) && movie.getRated().toLowerCase().contains(Rating.toLowerCase())) {
                results.add(movie);
            }
        }
        return results;
    }

    @Override
    public List<Game> gamesByGenreAndRating(String Genre, String Rating) {
        Reader reader = new Reader();
        List<Game> games = reader.readGames();
        List<Game> results = new ArrayList<>();

        for (Game game : games) {
            if ( Arrays.asList(game.getGenre().split(",")).contains(Genre) &&  game.getRated().equalsIgnoreCase(Rating)) {
                results.add(game);
            }
        }
        return results;
    }

    @Override
    public List<Entertainment> entertainmentByGenreAndRating(String Genre,
                                                             String Rating) {
        Reader reader = new Reader();
        List<Entertainment> results = new ArrayList<>();

        if (Rating.equalsIgnoreCase("pg-13")) {
            List<Movie> movies = reader.readMovies();
            for (Entertainment item : movies) {
                if (item.getGenre().toLowerCase().contains(Genre.toLowerCase())) {
                    results.add(item);
                }
            }
        } else {
            List<Entertainment> both = reader.readGamesAndMovies();

            for (Entertainment item : both) {
                if (Rating.equalsIgnoreCase("R") || Rating.equalsIgnoreCase("M")) {
                    if ((item.getRated().toLowerCase().contains("r") || item.getRated().toLowerCase().contains("m")) && item.getGenre().toLowerCase().contains(Genre.toLowerCase())) {
                        results.add(item);
                    }
                } else if (Rating.equalsIgnoreCase("T") || Rating.equalsIgnoreCase("PG")) {
                    if ((item.getRated().toLowerCase().contains("t") || item.getRated().toLowerCase().contains("pg")) && item.getGenre().toLowerCase().contains(Genre.toLowerCase())) {
                        results.add(item);
                    }
                } else {
                    if (item.getGenre().toLowerCase().contains(Genre.toLowerCase())) {
                        results.add(item);
                    }
                }
            }
        }
//        System.out.println(results.size()+ "-----------");
        return results;
    }

    @Override
    public <T extends Entertainment> void checkout(T title, Platform<T> platform) {
        platform.checkout(title);
    }

}
