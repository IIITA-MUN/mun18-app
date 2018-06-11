package com.shivansh.iiitamun18;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dell on 09-06-2018.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private List<Teammembers> TeamList;
    private Context context;

    public TeamAdapter(List<Teammembers> TeamList, Context context) {
        this.context = context;
        this.TeamList = TeamList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mPost;
        private ImageView mCall;
        private ImageView mEmail;
        private ImageView mFaceBook;
        private ImageView mProfile;

        public ViewHolder(View v) {
            super(v);
            mName = (TextView) itemView.findViewById(R.id.name_general);
            mPost = (TextView) itemView.findViewById(R.id.post_general);
            mCall = (ImageView) itemView.findViewById(R.id.call_gen);
            mEmail = (ImageView) itemView.findViewById(R.id.mail_gen);
            mFaceBook = (ImageView) itemView.findViewById(R.id.fb_gen);

            mProfile = (ImageView) itemView.findViewById(R.id.image_gen);

        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = null;
        switch (viewType) {
            case (1):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_generals, parent, false);
                break;
            case (0):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_usg, parent, false);
                break;
        }
        return new ViewHolder(view);

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mProfile.setImageResource(TeamList.get(position).getimage());
        holder.mName.setText(TeamList.get(position).getname());
        holder.mPost.setText(TeamList.get(position).getdes());

        position = holder.getAdapterPosition();
        final int finalPosition = position;

        holder.mCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  makecall(TeamList.get(finalPosition).getno());
            }
        });

        holder.mEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sendmail(TeamList.get(finalPosition).getmail());
            }
        });
        holder.mFaceBook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openWebPage(TeamList.get(finalPosition).getfb());
            }
        });

    }

    public void makecall(String phone){
        String callNumber = phone;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" +callNumber));
        context.startActivity(intent);
        }
        public void sendmail(String email){
            String emailId = email;
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto",emailId, null));
            context.startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        }
    public void openWebPage(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(context.getPackageManager())!= null)
            context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return TeamList.size();
    }
    @Override
    public int getItemViewType(int position) {
        if( TeamList.get(position).isgeneral == 1)
             return 1;
        else
            return 0;
    }
}