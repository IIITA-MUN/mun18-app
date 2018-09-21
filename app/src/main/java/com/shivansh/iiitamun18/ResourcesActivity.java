package com.shivansh.iiitamun18;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ResourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //ActionBar actionbar = getSupportActionBar();

//        if (actionbar != null) {
//            Log.e("log","NULL");
//            actionbar.setDisplayHomeAsUpEnabled(true);
//        }
      ImageView backpress = (ImageView)findViewById(R.id.back_button);


        backpress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                finish();
            }
        });

        ImageView worldbank = (ImageView)findViewById(R.id.world_bank);

        worldbank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebPage("https://data.worldbank.org/");
            }
        });
        ImageView reuters = (ImageView)findViewById(R.id.reuters);

        reuters.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebPage("https://in.reuters.com/");
            }
        });
        ImageView aljazeera = (ImageView)findViewById(R.id.aljazeera);

        aljazeera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebPage("https://www.aljazeera.com/");
            }
        });
        ImageView britannica = (ImageView)findViewById(R.id.britannica);

        britannica.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebPage("https://www.britannica.com");
            }
        });
    }
    public void openWebPage(String url){

        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(this.getPackageManager())!= null)
            startActivity(intent);
    }

}
