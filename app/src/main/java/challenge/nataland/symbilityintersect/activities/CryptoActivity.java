package challenge.nataland.symbilityintersect.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import challenge.nataland.symbilityintersect.R;
import challenge.nataland.symbilityintersect.adapters.CustomAdapter;
import challenge.nataland.symbilityintersect.models.Crypto;
import challenge.nataland.symbilityintersect.services.GetDataService;
import challenge.nataland.symbilityintersect.services.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by natalie on 2018-10-06.
 */

public class CryptoActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);

        progressDialog = new ProgressDialog(CryptoActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        // Create handle for the RetrofitInstance interface
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<Crypto>> call = service.getCryptoLarge();
        call.enqueue(new Callback<List<Crypto>>() {

            @Override
            public void onResponse(Call<List<Crypto>> call, Response<List<Crypto>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Crypto>> call, Throwable t) {
                progressDialog.dismiss();
                generateDataListEmpty();
                Toast.makeText(CryptoActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    // pass cryptolist to the recycler view adapter
    private void generateDataList(List<Crypto> cryptoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this, cryptoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CryptoActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    // For testing purposes, remove this later
    private void generateDataListEmpty() {
        recyclerView = findViewById(R.id.customRecyclerView);
//        adapter = new CustomAdapter(this, Arrays.asList(new Crypto(123L, "happy coin"), new Crypto(456L, "sad coin")));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CryptoActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
