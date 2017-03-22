package sf.codingcomp.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import sf.codingcomp.model.Entertainment;
import sf.codingcomp.model.Game;
import sf.codingcomp.model.Movie;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Reader {

    public List<Game> readGames() {
        URL url = this.getClass().getResource( "/games.json" );
        try {
            return new Gson().fromJson( new FileReader( url.getFile() ), new TypeToken<List<Game>>() {
            }.getType() );
        } catch ( JsonIOException | JsonSyntaxException | FileNotFoundException e ) {
            throw new RuntimeException( e );
        }
    }

    public List<Movie> readMovies() {
        URL url = this.getClass().getResource( "/movies.json" );
        try {
            return new Gson().fromJson( new FileReader( url.getFile() ), new TypeToken<List<Movie>>() {
            }.getType() );
        } catch ( JsonIOException | JsonSyntaxException | FileNotFoundException e ) {
            throw new RuntimeException( e );
        }
    }

    public List<Entertainment> readGamesAndMovies() {
        URL urlGame = this.getClass().getResource( "/games.json" );
        URL urlMovie = this.getClass().getResource( "/movies.json" );
        try {
            List<Entertainment> games= new Gson().fromJson( new FileReader( urlGame.getFile() ), new TypeToken<List<Entertainment>>() {
            }.getType() );
            List<Entertainment> movies= new Gson().fromJson( new FileReader( urlMovie.getFile() ), new TypeToken<List<Entertainment>>() {
            }.getType() );
            List<Entertainment> both = new ArrayList<>();
            both.addAll(movies);
            both.addAll(games);
System.out.println(both);
            return both;

        } catch ( JsonIOException | JsonSyntaxException | FileNotFoundException e ) {
            throw new RuntimeException( e );
        }
    }

}
