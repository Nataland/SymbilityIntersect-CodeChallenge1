package challenge.nataland.symbilityintersect.services;

import java.util.List;

import challenge.nataland.symbilityintersect.models.Crypto;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by natalie on 2018-10-06.
 */

public interface GetDataService {
    @GET("/api/data/coinlist")
    Call<List<Crypto>> getCryptoLarge();
}
