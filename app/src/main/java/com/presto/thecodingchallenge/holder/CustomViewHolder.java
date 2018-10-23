package com.presto.thecodingchallenge.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.presto.thecodingchallenge.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

  public final View mView;
  public TextView tvTitle, tvSize, tvDim;
  public ImageView ivCover;

  public CustomViewHolder(View itemView) {
    super(itemView);
    mView = itemView;

    tvTitle = mView.findViewById(R.id.tv_title);
    tvSize = mView.findViewById(R.id.tv_size);
    tvDim = mView.findViewById(R.id.tv_dim);
    ivCover = mView.findViewById(R.id.iv_cover);
  }



}
