package com.shivansh.iiitamun18;

import android.os.Bundle;
import android.widget.GridView;

/**
 * Created by DELL on 03-08-2018.
 */

public class Gallery extends MainActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new GalleryAdapter(this));
    }
}
