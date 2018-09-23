package com.shivansh.iiitamun18;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;

import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Button letter = findViewById(R.id.letter);
        letter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openFBPage("https://drive.google.com/file/d/1UbTbbOvuf2KBKgRQ9IDzrFCvocu4lWSM/view?usp=drivesdk");
            }
        });
        Button schedule = findViewById(R.id.schedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openFBPage("https://drive.google.com/open?id=1k9VLtpTK5rwlYIXFEXSDjlTV8Ba27ox-");
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight

                        mDrawerLayout.closeDrawers();
                        if(menuItem.getItemId()==R.id.about_us)
                        {
                            Intent intent = new Intent(MainActivity.this,AboutUsActivity.class);
                            startActivity(intent);
                            return true;
                        }
                        if(menuItem.getItemId()==R.id.committees)
                        {
                            Intent intent = new Intent(MainActivity.this,Committees.class);
                            startActivity(intent);
                            return true;
                        }
                        if(menuItem.getItemId()==R.id.about_mun)
                        {
                            Intent intent = new Intent(MainActivity.this,AboutMUNActivity.class);
                            startActivity(intent);
                            return true;
                        }
                        if(menuItem.getItemId()==R.id.apply)
                        {
                            DialogFragment newFragment = new ApplyNowFragment();
                            newFragment.show(getSupportFragmentManager(), "apply");
                        }
                        if(menuItem.getItemId()==R.id.country_matrix)
                        {
                            DialogFragment newFragment = new MatrixFragment();
                            newFragment.show(getSupportFragmentManager(), "matrix");
                        }
                        if(menuItem.getItemId()==R.id.resources)
                        {
                            Intent intent = new Intent(MainActivity.this,ResourcesActivity.class);
                            startActivity(intent);
                            return true;
                        }
                        if(menuItem.getItemId()==R.id.our_team)
                        {
                            Intent intent = new Intent(MainActivity.this,SecActivity.class);
                            startActivity(intent);
                            return true;
                        }
                        if(menuItem.getItemId()==R.id.credits)
                        {
                            Intent intent = new Intent(MainActivity.this,CreditsActivity.class);
                            startActivity(intent);
                            return true;
                        }
                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.locate:
                openIIITInMap();
                return true;
            case R.id.like:
                openFBPage("https://www.facebook.com/iiitamun/");
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public void openIIITInMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<25.4304161>,<81.770679>" +
                "?q=<25.4304161>,<81.770679>(Indian Institute of Information Technology, Allahabad)"));

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

    }
    public void openFBPage(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(this.getPackageManager())!= null)
            startActivity(intent);
    }

}