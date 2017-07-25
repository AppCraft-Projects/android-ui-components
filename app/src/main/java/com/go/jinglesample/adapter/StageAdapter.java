package com.go.jinglesample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.go.jinglesample.model.User;
import com.go.jinglesample.widget.StageUserItemView;

import java.util.List;

public class StageAdapter extends RecyclerView.Adapter<StageAdapter.ViewHolder> {

    private List<User> jingleUserList;

    public StageAdapter(List<User> jingleUserList) {
        this.jingleUserList = jingleUserList;
    }

    @Override
    public StageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StageUserItemView stageUserItemView = new StageUserItemView(parent.getContext());
        stageUserItemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ViewHolder viewHolder = new ViewHolder(stageUserItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StageAdapter.ViewHolder holder, int position) {
        holder.stageItemView.setJingleUser(jingleUserList.get(position));
        holder.stageItemView.setupView();
    }

    @Override
    public int getItemCount() {
        return jingleUserList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final StageUserItemView stageItemView;

        ViewHolder(final View itemView) {
            super(itemView);
            stageItemView = (StageUserItemView) itemView;
        }
    }
}
