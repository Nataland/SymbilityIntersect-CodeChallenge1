package challenge.nataland.symbilityintersect.services;

/**
 * Created by natalie on 2018-10-07.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by natalie on 2018-09-10.
 */

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.cryptocompare.com/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

