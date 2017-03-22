package sf.codingcomp.model;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;
import java.util.Date;

public class Movie extends Entertainment {

    @SerializedName("Runtime")
    private String runtime;
    @SerializedName("Director")
    private String director;
    @SerializedName("Writer")
    private String writer;
    @SerializedName("StockDVD")
    private String stockDvd;
    @SerializedName("StockBR")
    private String stockBr;
    @SerializedName("Format")
    private String format;

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getStockDvd() {
        return stockDvd;
    }

    public void setStockDvd(String stockDvd) {
        this.stockDvd = stockDvd;
    }

    public String getStockBr() {
        return stockBr;
    }

    public void setStockBr(String stockBr) {
        this.stockBr = stockBr;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Movie [runtime=" + runtime + ", director=" + director + ", writer=" + writer + ", stockDvd=" + stockDvd + ", stockBr=" + stockBr
                + ", format=" + format + ", getTitle()=" + getTitle() + ", getYear()=" + getYear() + ", getRated()=" + getRated()
                + ", getReleased()=" + getReleased() + ", getActors()=" + getActors() + ", getPlot()=" + getPlot() + ", getLanguage()="
                + getLanguage() + ", getCountry()=" + getCountry() + ", getAwards()=" + getAwards() + ", getPoster()=" + getPoster()
                + ", getUserRating()=" + getUserRating() + ", getType()=" + getType() + ", getGenre()=" + getGenre() + "]";
    }

//    public static Comparator<Movie> StuNameComparator = new Comparator<Movie>() {
//        public int compare(Movie s1, Movie s2) {
//            Date StudentName1 = s1.getReleased();
//            Date StudentName2 = s2.getReleased();
//
//            //ascending order
//            return StudentName1.compareTo(StudentName2);
//
//            //descending order
//            //return StudentName2.compareTo(StudentName1);
//        }
//
//
//    }
}