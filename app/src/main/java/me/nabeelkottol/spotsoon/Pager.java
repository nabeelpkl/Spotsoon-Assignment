package me.nabeelkottol.spotsoon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nabeelkottol on 12/06/17.
 */

public class Pager extends FragmentStatePagerAdapter {

  //integer to count number of tabs
  int tabCount;

  public Pager(FragmentManager fm, int tabCount) {
    super(fm);
    //Initializing tab count
    this.tabCount = tabCount;
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
}
