package sf.codingcomp.model;

import sf.codingcomp.SearchServiceImplementation;
import sf.codingcomp.exception.TitleNotAvailableException;

import java.util.List;

public enum GamePlatform implements Platform<Game> {
    LNX {
    },
    MAC {
    },
    PC {
    },
    PSP {
    },
    PS2 {
    },
    PS4 {
    },
    X {
    },
    X360 {
    },
    X1 {
    },
    WII {
    },
    WIIU {
    };

    @Override
    public boolean inStock(Game game) {
        String platform = this.name();
        boolean inStock = false;
        switch (platform) {
            case "PS4":
                inStock = Integer.parseInt(game.getStockPs4()) > 0 ? true : false;
                break;
            case "PS3":
                inStock = Integer.parseInt(game.getStockPs3()) > 0 ? true : false;
                break;
            case "LNX":
                inStock = Integer.parseInt(game.getStockLnx()) > 0 ? true : false;
                break;
            case "MAC":
                inStock = Integer.parseInt(game.getStockMac()) > 0 ? true : false;
                break;
            case "PC":
                inStock = Integer.parseInt(game.getStockPc()) > 0 ? true : false;
                break;
            case "Wii":
                inStock = Integer.parseInt(game.getStockWii()) > 0 ? true : false;
                break;
            case "WiiU":
                inStock = Integer.parseInt(game.getStockWiiU()) > 0 ? true : false;
                break;
            case "X":
                inStock = Integer.parseInt(game.getStockX()) > 0 ? true : false;
                break;
            case "X1":
                inStock = Integer.parseInt(game.getStockX1()) > 0 ? true : false;
                break;
            case "X360":
                inStock = Integer.parseInt(game.getStockX360()) > 0 ? true : false;
                break;
        }
        return inStock;
    }

    @Override
    public void checkout(Game game) throws TitleNotAvailableException {
        SearchServiceImplementation searchService = new SearchServiceImplementation();

        if (inStock(game)) {
            Integer newNumber = Integer.parseInt(game.getStockPs4()) - 1;

            String platform = this.name();
            Integer currentQty ;
            switch (platform) {
                case "PS4":
                    currentQty = new Integer(Integer.parseInt(game.getStockPs4()) -1);
                    game.setStockPs4(currentQty.toString());
                    break;
                case "PS3":
                    currentQty = new Integer(Integer.parseInt(game.getStockPs3()) -1);
                    game.setStockPs3(currentQty.toString());
                    break;
                case "LNX":
                    currentQty = new Integer(Integer.parseInt(game.getStockLnx()) -1);
                    game.setStockLnx(currentQty.toString());
                    break;
                case "Mac":
                    currentQty = new Integer(Integer.parseInt(game.getStockMac()) -1);
                    game.setStockMac(currentQty.toString());
                    break;
                case "PC":
                    currentQty = new Integer(Integer.parseInt(game.getStockPc())  -1);
                    game.setStockPc(currentQty.toString());
                    break;
                case "Wii":
                    currentQty = new Integer(Integer.parseInt(game.getStockWii()) -1);
                    game.setStockWii(currentQty.toString());
                    break;
                case "WiiU":
                    currentQty = new Integer(Integer.parseInt(game.getStockWiiU()) -1);
                    game.setStockWiiU(currentQty.toString());
                    break;
                case "X":
                    currentQty = new Integer(Integer.parseInt(game.getStockX()) -1);
                    game.setStockX(currentQty.toString());
                    break;
                case "X1":
                    currentQty = new Integer(Integer.parseInt(game.getStockX1()) -1) ;
                    game.setStockX1(currentQty.toString());
                    break;
                case "X360":
                    currentQty = new Integer(Integer.parseInt(game.getStockX360()) -1);
                    game.setStockX360(currentQty.toString());
                    break;
            }
        }else {
            throw new TitleNotAvailableException();
        }

    }
}