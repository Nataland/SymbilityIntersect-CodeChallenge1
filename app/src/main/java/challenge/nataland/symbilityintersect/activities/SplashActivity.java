package challenge.nataland.symbilityintersect.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import challenge.nataland.symbilityintersect.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void onClickTitle(View v) {
        Intent intent = new Intent(this, CryptoActivity.class);
        startActivity(intent);
    }
}
