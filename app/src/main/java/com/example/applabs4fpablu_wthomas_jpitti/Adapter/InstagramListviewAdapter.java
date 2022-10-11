package com.example.applabs4fpablu_wthomas_jpitti.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.applabs4fpablu_wthomas_jpitti.R;

import java.util.List;

public class InstagramListviewAdapter extends ArrayAdapter<Chat> {
    private List<Chat> options;

    public InstagramListviewAdapter(Context context, List<Chat> data){
        super(context, R.layout.listview_layouttemplate, data);

        options = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        @SuppressLint({"ViewHolder", "InflateParams"}) View item = inflater.inflate(R.layout.listview_layouttemplate, null);

        TextView lblUsername = (TextView)item.findViewById(R.id.lblUsername); // Name of the user
        lblUsername.setText(options.get(position).getUsername());

        TextView lblMessages = (TextView)item.findViewById(R.id.lblMessages); //Last message
        lblMessages.setText(options.get(position).getMessage());

        ImageView imvProfile = (ImageView) item.findViewById(R.id.imvProfile); //Profile photo
        imvProfile.setImageResource(options.get(position).getProfilePicture());

        TextView lblTime = (TextView)item.findViewById(R.id.lbltime);// Minutes connected
        lblTime.setText(options.get(position).getTime());

        return(item);
    }
}
