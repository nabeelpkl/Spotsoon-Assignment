package me.nabeelkottol.spotsoon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import me.nabeelkottol.spotsoon.R;
import me.nabeelkottol.spotsoon.model.Item;

/**
 * Created by nabeelkottol on 02/06/17.
 */

public class ItemsListAdapter extends RecyclerView.Adapter<ItemsListAdapter.ItemViewHolder> {
  List<Item> items;
  Context mContext;

  public ItemsListAdapter(Context context, List<Item> items) {
    mContext = context;
    this.items = items;
  }

  @Override public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
    ItemViewHolder viewHolder;

    View productDetailsView = mInflater.inflate(R.layout.recycler_view_item, parent, false);
    viewHolder = new ItemViewHolder(productDetailsView);
    return viewHolder;
  }

  @Override public void onBindViewHolder(ItemViewHolder holder, int position) {

    Item item = items.get(position);

    holder.descriptionTV.setText(item.getDescription());
    holder.timeTV.setText(item.getTime());
    holder.titleTV.setText(item.getTitle());
    holder.coverArt.setImageResource(item.getDrawable());
  }

  @Override public int getItemCount() {
    return items.size();
  }

  public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView descriptionTV, timeTV, titleTV;
    ImageView coverArt;

    public ItemViewHolder(View itemView) {
      super(itemView);
      descriptionTV = (TextView) itemView.findViewById(R.id.description);
      timeTV = (TextView) itemView.findViewById(R.id.time);
      titleTV = (TextView) itemView.findViewById(R.id.title);
      coverArt = (ImageView) itemView.findViewById(R.id.cover_art);
    }
  }
}
