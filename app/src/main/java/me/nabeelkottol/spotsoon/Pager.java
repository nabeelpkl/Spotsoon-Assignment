package me.nabeelkottol.spotsoon;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nabeelkottol on 12/06/17.
 */

public class Pager extends FragmentStatePagerAdapter {

  //integer to count number of tabs
  int tabCount;
  Context mContext;

  public Pager(FragmentManager fm, Context context, int tabCount) {
    super(fm);
    //Initializing tab count
    this.tabCount = tabCount;
    mContext = context;
  }

  @Override public Fragment getItem(int position) {
    switch (position) {
      case 0:
        BlankFragment tab1 = new BlankFragment();
        return tab1;
      case 1:
        BlankFragment tab2 = new BlankFragment();
        return tab2;
      case 2:
        BlankFragment tab3 = new BlankFragment();
        return tab3;
      default:
        return null;
    }
  }

  @Override public int getCount() {
    return tabCount;
  }

  private String tabTitles[] = new String[] { "VIDEOS", "IMAGES", "MILESTONE" };
  private int[] imageResId =
      { R.drawable.videos_selector, R.drawable.images_selector, R.drawable.milestone_selector };

  public View getTabView(int position) {
    // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
    View v = LayoutInflater.from(mContext).inflate(R.layout.video_tab_layout, null);
    TextView tv = (TextView) v.findViewById(R.id.tab_title);
    tv.setText(tabTitles[position]);
    //tv.setTextColor(mContext.getResources().getColor(R.color.tab_text_selector));
    ImageView img = (ImageView) v.findViewById(R.id.tab_icon);
    img.setImageResource(imageResId[position]);
    return v;
  }

  public void SetOnSelectView(TabLayout tabLayout, int position) {
    TabLayout.Tab tab = tabLayout.getTabAt(position);
    View selected = tab.getCustomView();
    TextView iv_text = (TextView) selected.findViewById(R.id.tab_title);
    iv_text.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
  }

  public void SetUnSelectView(TabLayout tabLayout, int position) {
    TabLayout.Tab tab = tabLayout.getTabAt(position);
    View selected = tab.getCustomView();
    TextView iv_text = (TextView) selected.findViewById(R.id.tab_title);
    iv_text.setTextColor(mContext.getResources().getColor(R.color.grey));
  }
}
