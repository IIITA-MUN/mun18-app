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
                openWebPage("http://www.un.org/en/ga/first/");
            }
        });

        Button unscsite = (Button)rootview.findViewById(R.id.unsc_site);
        unscsite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openWebPage("http://www.un.org/en/sc/");
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
