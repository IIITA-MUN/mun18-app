package com.shivansh.iiitamun18;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class CommitteesFragment extends Fragment {

    public CommitteesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View rootview =  inflater.inflate(R.layout.fragment_committees, container, false);

        Button disecsite = (Button) rootview.findViewById(R.id.disec_site);
        disecsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebPage("https://mun.iiita.ac.in/home/unhrc.html");
            }
        });

        Button bg1 = (Button)rootview.findViewById(R.id.disec_bg);
        bg1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openWebPage("https://drive.google.com/open?id=1nizfsf-F3mwNt-lvMkqO3oM3OPBELe9A");
            }
        });

        Button unscsite = (Button)rootview.findViewById(R.id.unsc_site);
        unscsite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openWebPage("https://mun.iiita.ac.in/home/g20.html");
            }
        });
        
        Button bg2 = (Button)rootview.findViewById(R.id.unsc_bg);
        bg2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openWebPage("https://drive.google.com/open?id=1Iq_CoyCopusqLYK4SpPW1QU2vIxzn_BO");
            }
        });

        return rootview;
    }
    public void openWebPage(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getActivity().getPackageManager())!= null)
            startActivity(intent);
    }
}
