package me.nabeelkottol.spotsoon;

import android.net.Uri;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BlankFragment extends Fragment {

  private OnFragmentInteractionListener mListener;
  RecyclerView recyclerView;
  ItemsListAdapter adapter;

  public BlankFragment() {
    // Required empty public constructor
  }

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

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

 /* @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }
  }*/

  @Override public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }
}
