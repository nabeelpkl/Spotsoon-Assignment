package me.nabeelkottol.spotsoon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import me.nabeelkottol.spotsoon.R;
import me.nabeelkottol.spotsoon.adapter.ItemsListAdapter;
import me.nabeelkottol.spotsoon.model.Item;

public class BlankFragment extends Fragment {

  RecyclerView recyclerView;
  ItemsListAdapter adapter;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_blank, container, false);
    recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

    adapter = new ItemsListAdapter(this.getContext(), getItems());

    LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(adapter);
    return view;
  }

  private List<Item> getItems() {
    List<Item> items = new ArrayList<Item>();
    items.add(new Item(R.drawable.music_cover_art, "Emptiness ft. justin tiblekar", "7 Hours ago",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
    items.add(new Item(R.drawable.music_cover_art_1, "I'm falling love with you", "12 Hours ago",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
    items.add(new Item(R.drawable.music_cover_art_2, "Baby ft. justin baber", "18 Hours ago",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
    items.add(new Item(R.drawable.music_cover_art_3, "Despacito ft. daddy yankee", "19 Hours ago",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
    items.add(new Item(R.drawable.music_cover_art_4, "White horse ft. taylor swift", "20 Hours ago",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));

    return items;
  }
}
