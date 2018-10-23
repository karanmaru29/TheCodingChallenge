package com.presto.thecodingchallenge.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.presto.thecodingchallenge.R;
import com.presto.thecodingchallenge.holder.CustomViewHolder;
import com.presto.thecodingchallenge.model.Photo;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import java.util.List;

public class FlickerDataAdapter extends RecyclerView.Adapter<CustomViewHolder> {

  private List<Photo> photoList;
  private Context context;
  private LayoutInflater layoutInflater;

  public FlickerDataAdapter(Context context, List<Photo> photoList) {
    this.photoList = photoList;
    this.context = context;
    layoutInflater = LayoutInflater.from(context);
  }

  @NonNull @Override
  public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
    return new CustomViewHolder(view);
  }

  @Override public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {

    if (!photoList.get(position).getTitle().isEmpty()) {
      holder.tvTitle.setText(photoList.get(position).getTitle());
    } else {
      holder.tvTitle.setText(context.getResources().getString(R.string.title_not_available));
    }
    {
      Picasso.with(context)
          .load(photoList.get(position).getUrl())
          .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
          .placeholder(R.drawable.ic_launcher_background)
          .config(Bitmap.Config.RGB_565)
          .error(R.drawable.ic_launcher_background)
          .into(new Target() {
            @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
              int width = bitmap.getWidth();
              int height = bitmap.getHeight();
              holder.ivCover.setImageBitmap(bitmap);
              holder.tvDim.setText(
                  context.getResources().getString(R.string.dimension) + height + "x" + width);
              holder.tvSize.setText(
                  context.getResources().getString(R.string.size) + String.valueOf(
                      bitmap.getByteCount() / 1000) + context.getResources()
                      .getString(R.string.kb));
            }

            @Override public void onBitmapFailed(Drawable errorDrawable) {
              holder.ivCover.setBackgroundResource(R.drawable.ic_launcher_background);
            }

            @Override public void onPrepareLoad(Drawable placeHolderDrawable) {
              holder.ivCover.setBackgroundResource(R.drawable.ic_launcher_background);
            }
          });
    }
  }

  @Override public int getItemCount() {
    return photoList.size();
  }
}
