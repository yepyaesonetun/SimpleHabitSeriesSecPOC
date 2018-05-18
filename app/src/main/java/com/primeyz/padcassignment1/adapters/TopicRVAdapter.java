package com.primeyz.padcassignment1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.primeyz.padcassignment1.R;
import com.primeyz.padcassignment1.models.TopicModel;

import java.util.ArrayList;

/**
 * Created by yepyaesonetun on 5/16/18.
 **/

@SuppressWarnings("all")
public class TopicRVAdapter extends RecyclerView.Adapter<TopicRVAdapter.TopicViewHolder> {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<TopicModel> tpModel;

    public TopicRVAdapter(Context context, int layoutResourceId, ArrayList<TopicModel> tpModel) {
        this.mContext = context;
        this.layoutResourceId = layoutResourceId;
        this.tpModel = tpModel;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResourceId, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        TopicModel model = tpModel.get(position);
        holder.bindData(model);
    }

    @Override
    public int getItemCount() {
        return tpModel.size();
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgIcon;
        private ImageView imgBg;
        private TextView tvTitle;
        private TextView tvSubTitle;
        private CardView cvItem;

        public TopicViewHolder(View itemView) {
            super(itemView);

            imgIcon = itemView.findViewById(R.id.img_topic_icon);
            imgBg = itemView.findViewById(R.id.img_topic_bg);
            tvTitle = itemView.findViewById(R.id.tv_topic_title);
            tvSubTitle = itemView.findViewById(R.id.tv_topic_subtitle);
            cvItem = itemView.findViewById(R.id.cv_item_topic);
        }

        void bindData(TopicModel model) {

            Glide.with(mContext)
                    .load(model.getImage())
                    .into(imgIcon);
            Glide.with(mContext)
                    .load(model.getBgImage())
                    .into(imgBg);
            tvTitle.setText(model.getTitle());
            tvSubTitle.setText(model.getSubtitle());

            cvItem.setOnClickListener(v -> {
                Toast.makeText(mContext, "It'll lead you to Topic Detail", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
