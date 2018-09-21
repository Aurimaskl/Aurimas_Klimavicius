package com.example.VismaTask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
        private static final String TAG = "CustomAdapter";
        private List<Photo> photos = new ArrayList<Photo>();

        // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
        private final Context mContext;
        final private RecyclerViewAdapterOnClickHandler mClickHandler;

        public interface RecyclerViewAdapterOnClickHandler {
            //onClick interface
            void onClick(int position);

        }

    public RecyclerAdapter(@NonNull Context context, RecyclerViewAdapterOnClickHandler clickHandler) {
            //constructor
            mContext = context;
            mClickHandler = clickHandler;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view.
            // one xml files is taken for repeating it later
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_item, viewGroup, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
            //data assigning to views
            if(photos.get(position).photoURL != null){
                Picasso.with(mContext)
                        .load(photos.get(position).photoURL)
                        .into(viewHolder.getImageView());}
        }

        // END_INCLUDE(recyclerViewOnBindViewHolder)

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            if (photos.isEmpty()) return 0;
            return photos.size();
        }

        void setDataToAdapter(List<Photo> mPhoto) {
            photos = mPhoto;
            notifyDataSetChanged();
        }


        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private final ImageView photoImageView;
            //views are held here, not to create hundreds of them, it hols created templated and puls data to it
            //ViewHolder goes to onBindViewHolder
            public ViewHolder(View v) {
                super(v);
                photoImageView = (ImageView) v.findViewById(R.id.imageView);
                v.setOnClickListener(this);
            }
            @Override
            public void onClick(View v) {
                //position of click
                int position = getAdapterPosition();
                mClickHandler.onClick(position);
            }
            //getter for getting seperate ImageView
            public ImageView getImageView() {
                return photoImageView;
            }

        }
}
