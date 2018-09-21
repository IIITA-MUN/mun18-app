package com.shivansh.iiitamun18;

import android.app.Dialog;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MatrixFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select the Committee : ")
                .setItems(R.array.string_array_matrix, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int position) {
                        switch (position) {
                            case 0:
                                openWebPage("https://mun.iiita.ac.in/home/assets/COUNTRY%20MATRIX%20FOR%20UNHRC.pdf");
                                break;
                            case 1:
                                openWebPage( "https://mun.iiita.ac.in/home/assets/COUNTRY%20MATRIX%20FOR%20G20-converted%20(1).pdf");
                                break;
                        }
                    }
                });
        return builder.create();
    }
    public void openWebPage(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getActivity().getPackageManager())!= null)
            startActivity(intent);
    }
}