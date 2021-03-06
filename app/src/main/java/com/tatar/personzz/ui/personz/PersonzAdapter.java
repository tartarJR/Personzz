package com.tatar.personzz.ui.personz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tatar.personzz.R;
import com.tatar.personzz.data.network.modal.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by mobile on 8.02.2018.
 */

public class PersonzAdapter extends RecyclerView.Adapter<PersonzAdapter.ViewHolder> {

    private List<Result> personList;

    private final Picasso picasso;
    private final Context context;

    @Inject
    public PersonzAdapter(PersonzActivity personzActivity, Picasso picasso) {
        personList = new ArrayList<>();

        this.picasso = picasso;
        this.context = personzActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // context can be reached like this as well
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_item, parent, false);
        View view = LayoutInflater.from(context).inflate(R.layout.person_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = personList.get(position);

        picasso.with(holder.profilePicImageView.getContext())
                .load(result.getPicture().getLarge())
                .into(holder.profilePicImageView);
        holder.fullNameTv.setText(String.format("%s %s", WordUtils.capitalize(result.getName().getFirst()), WordUtils.capitalize(result.getName().getLast())));
        holder.genderTextView.setText(WordUtils.capitalize(result.getGender()));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void setPersonList(List<Result> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView profilePicImageView;
        public TextView fullNameTv;
        public TextView genderTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            profilePicImageView = itemView.findViewById(R.id.profile_pic_img_view);
            fullNameTv = itemView.findViewById(R.id.full_name_tv);
            genderTextView = itemView.findViewById(R.id.gender_tv);
        }
    }

    public static class WordUtils {

        private static String capitalize(String text) {
            return text.substring(0, 1).toUpperCase() + text.substring(1);
        }
    }
}
