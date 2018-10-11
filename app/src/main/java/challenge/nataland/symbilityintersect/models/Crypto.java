package challenge.nataland.symbilityintersect.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by natalie on 2018-10-07.
 */

public class Crypto implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "CoinName")
    @NonNull
    private String coinName;

    @ColumnInfo(name = "currency_price")
    private Double price;

    @ColumnInfo(name = "currency_volume")
    private Double volume;

    @ColumnInfo(name = "favourite")
    private Boolean isFavourite;

    public Crypto(@NonNull String coinName, Double price, Double volume, Boolean isFavourite) {
        this.coinName = coinName;
        this.price = price;
        this.volume = volume;
        this.isFavourite = isFavourite;
    }

    @NonNull
    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(@NonNull String coinName) {
        this.coinName = coinName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }
}
