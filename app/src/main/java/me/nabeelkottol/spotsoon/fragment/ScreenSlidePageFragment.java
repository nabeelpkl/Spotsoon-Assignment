package me.nabeelkottol.spotsoon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import me.nabeelkottol.spotsoon.R;

import static me.nabeelkottol.spotsoon.helper.ImageHelper.decodeSampledBitmapFromResource;

/**
 * Created by nabeelkottol on 12/06/17.
 */

public class ScreenSlidePageFragment extends Fragment {
  ImageView backgroundView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    ViewGroup rootView =
        (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
    backgroundView = (ImageView) rootView.findViewById(R.id.background_image);
    backgroundView.setImageBitmap(
        decodeSampledBitmapFromResource(getResources(), R.drawable.akcent_cover_art, 250, 150));
    return rootView;
  }
}
