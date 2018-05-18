package com.primeyz.padcassignment1.adapters;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.primeyz.padcassignment1.R;
import com.primeyz.padcassignment1.interfaces.RecyclerAddClickListener;
import com.primeyz.padcassignment1.models.ItemModel;

import java.util.ArrayList;

/**
 * Created by yepyaesonetun on 5/16/18.
 **/

@SuppressWarnings("all")
public class ItemRVAdapter extends RecyclerView.Adapter<ItemRVAdapter.ItemViewHolder> {

    private Context mContext;
    private ArrayList<ItemModel> itemList;
    private int layoutResourceId;

    private RecyclerAddClickListener listener;

    public void setListener(RecyclerAddClickListener listener) {
        this.listener = listener;
    }

    public ItemRVAdapter(Context mContext, int layoutResourceId, ArrayList<ItemModel> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.layoutResourceId = layoutResourceId;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResourceId, parent, false);
        // This isn't good practice
        // TODO: need to reconsider
        if (itemList.size()==1){
            view.getLayoutParams().width = getScreenWidth();
            view.getLayoutParams().height = (int) (getScreenWidth()/1.5);
        }else {
            view.getLayoutParams().width = (int) (getScreenWidth() / 2.5);
        }
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel model = itemList.get(position);
        holder.bindItem(model);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private int getScreenWidth() {

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.x;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgBg, imgAddToPlayList;
        private TextView tvItemName;
        private TextView tvMinute;

        boolean isAlreadyAdded = false;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imgBg = itemView.findViewById(R.id.img_item_bg);
            imgAddToPlayList = itemView.findViewById(R.id.img_add);
            tvItemName = itemView.findViewById(R.id.tv_item_title);
            tvMinute = itemView.findViewById(R.id.tv_item_minute);
        }

        void bindItem(ItemModel model){

            // for Starter Card
            if (itemList.size() == 1){
                imgBg.getLayoutParams().height = (int) (getScreenWidth() /1.5);
            }else {
                // for other cards
                imgBg.getLayoutParams().height = (int) (getScreenWidth() / 2.7);
            }

            Glide.with(mContext)
                    .load(model.getImage())
                    .into(imgBg);
            tvItemName.setText(model.getName());
            tvMinute.setText(model.getMinute());

            imgAddToPlayList.setOnClickListener(v -> {

                if(isAlreadyAdded){
                   imgAddToPlayList.setImageResource(R.drawable.ic_add_white_24dp);

                }else{
                    if (listener!=null){
                        listener.addClicked(model);
                    }
                    imgAddToPlayList.setImageResource(R.drawable.ic_check_white_24dp);
                }

                isAlreadyAdded = !isAlreadyAdded;
            });
        }
    }
}
