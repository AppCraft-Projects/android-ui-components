package com.go.jinglesample.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.go.jinglesample.utils.AndroidUtils;
import com.go.jinglesample.widget.CircleImageItemView;

import java.util.List;

public class CircleImageTextAdapter extends RecyclerView.Adapter<CircleImageTextAdapter.ViewHolder> {

    private List<ImageTextItem> imageTextItemList;

    public CircleImageTextAdapter(final List<ImageTextItem> imageTextItemList) {
        this.imageTextItemList = imageTextItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final CircleImageItemView circleImageItemView = new CircleImageItemView(parent.getContext());
        final DisplayMetrics displayMetrics = parent.getResources().getDisplayMetrics();
        final ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(AndroidUtils.dpToPx(120, displayMetrics), ViewGroup.LayoutParams.WRAP_CONTENT);
        int imageSize = AndroidUtils.dpToPx(80, displayMetrics);
        circleImageItemView.setImageSize(imageSize, imageSize);
        circleImageItemView.setOrientation(LinearLayout.VERTICAL);
        circleImageItemView.setLayoutParams(lp);
        return new ViewHolder(circleImageItemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ImageTextItem item = imageTextItemList.get(position);
        holder.circleImageItemView.setMode(CircleImageItemView.MODE_BOTTOM_TEXT);
        holder.circleImageItemView.setImageBitmap(item.image_url);
        holder.circleImageItemView.setText(item.text);
        holder.circleImageItemView.setupView();
    }

    @Override
    public int getItemCount() {
        return imageTextItemList.size();
    }

    public static class ImageTextItem {
        public String text;
        public String image_url;

        public ImageTextItem(String text, String image_url) {
            this.text = text;
            this.image_url = image_url;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final CircleImageItemView circleImageItemView;

        public ViewHolder(final CircleImageItemView itemView) {
            super(itemView);
            this.circleImageItemView = itemView;
        }
    }
}
