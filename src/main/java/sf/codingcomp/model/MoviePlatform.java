package sf.codingcomp.model;

import sf.codingcomp.SearchService;
import sf.codingcomp.SearchServiceImplementation;
import sf.codingcomp.exception.TitleNotAvailableException;
import sf.codingcomp.reader.Reader;

import java.util.List;

public enum MoviePlatform implements Platform<Movie> {
    DVD {
    },
    BLU_RAY {
    };

    @Override
    public boolean inStock(Movie movie) {
        String platform = this.name();
        boolean inStock = false;
        switch (platform) {
            case "dvd":
                inStock = Integer.parseInt(movie.getStockDvd()) > 0 ? true : false;
                break;
            case "BR":
                inStock = Integer.parseInt(movie.getStockBr()) > 0 ? true : false;
                break;
        }
        return inStock;
    }

    @Override
    public void checkout(Movie movie) {
        String platform = this.name();
        Integer currentQty ;
        if(inStock(movie)){
            Integer qty;
            switch (platform) {
                case "dvd":
                    currentQty = new Integer(Integer.parseInt(movie.getStockDvd()));
                    movie.setStockDvd(currentQty.toString());
                    break;
                case "BR":
                    currentQty = new Integer(Integer.parseInt(movie.getStockBr()));
                    movie.setStockBr(currentQty.toString());
                    break;
                    default: throw new TitleNotAvailableException();
            }
        }

    }

}
