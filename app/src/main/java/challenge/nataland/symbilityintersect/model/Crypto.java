package challenge.nataland.symbilityintersect.model;

/**
 * Created by natalie on 2018-10-07.
 */

public class Crypto {
    private String currencyName;
    private Double currencyPrice;
    private boolean isFavourite;

    public Crypto(String currencyName, Double currencyPrice, boolean isFavourite) {
        this.currencyName = currencyName;
        this.currencyPrice = currencyPrice;
        this.isFavourite = isFavourite;
    }

    public String getName() {
        return currencyName;
    }

    public Double getPrice() {
        return currencyPrice;
    }

    public boolean getFavourite() {
        return isFavourite;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setCurrencyPrice(Double currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
