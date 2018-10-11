package challenge.nataland.symbilityintersect.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import challenge.nataland.symbilityintersect.R;
import challenge.nataland.symbilityintersect.adapter.CustomAdapter;
import challenge.nataland.symbilityintersect.model.Crypto;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by natalie on 2018-10-06.
 */

public class CryptoActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    ProgressDialog progressDialog;
    private static String nameData = null;
    private static JSONObject nameJSONObject = null;
    ArrayList<Crypto> currencies = new ArrayList<>();
    private int numDisplay = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);

        recyclerView = findViewById(R.id.customRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        getSupportActionBar().setTitle(R.string.title);

        progressDialog = new ProgressDialog(CryptoActivity.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();
        new FetchDataTask().execute(getString(R.string.name_endpoint));
    }

    private class FetchDataTask extends AsyncTask<String, Void, ArrayList<Crypto>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<Crypto> doInBackground(String... strings) {

            String nameUrl = strings[0];
            OkHttpClient client = new OkHttpClient();

            Request nameRequest = new Request.Builder()
                    .url(nameUrl)
                    .build();

            okhttp3.Response nameResponse;
            try {
                nameResponse = client.newCall(nameRequest).execute();
                nameData = nameResponse.body().string();
            } catch (IOException e) {
                Log.e("RESPONSE", "Error while fetching name", e);
            }

            try {
                JSONObject jsonObj = new JSONObject(nameData);
                nameJSONObject = jsonObj.getJSONObject("Data");
            } catch (JSONException e) {
                Log.e("RESPONSE", "JSON Error while obtaining name data", e);
            }

            okhttp3.Response priceResponse;
            String priceData;

            Iterator<String> iter = nameJSONObject.keys();
            while (iter.hasNext()) {
                String key = iter.next();
                try {
                    if (numDisplay != 0) {
                        JSONObject currency = nameJSONObject.getJSONObject(key);
                        String name = currency.getString("Name");
                        priceResponse = client.newCall(createPriceRequest(name)).execute();
                        priceData = priceResponse.body().string();
                        Double price = new JSONObject(priceData).getDouble("CAD");
                        currencies.add(new Crypto(name, price, false));
                        numDisplay--;
                    }
                } catch (Exception e) {
                    Log.d("exception", e.toString());
                }
            }

            return currencies;
        }

        @Override
        protected void onPostExecute(ArrayList<Crypto> currencies) {
            adapter = new CustomAdapter(currencies);
            recyclerView.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }

    private Request createPriceRequest(String currency) {
        String url = getString(R.string.price_endpoint, currency);
        return new Request.Builder().url(url).build();
    }
}
