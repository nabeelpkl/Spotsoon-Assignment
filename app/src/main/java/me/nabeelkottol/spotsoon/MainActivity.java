package me.nabeelkottol.spotsoon;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import me.nabeelkottol.spotsoon.adapter.Pager;
import me.nabeelkottol.spotsoon.fragment.ScreenSlidePageFragment;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
  ViewPager tabViewPager;
  ViewPager slideViewPager;
  PagerAdapter slidePagerAdapter;
  Pager adapter;
  TabLayout tabLayout;
  CircleIndicator indicator;

  private static final int NUM_PAGE_SLIDES = 5;
  private static final int NUM_TABS = 3;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle(R.string.main_activity_title_text);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setIcon(R.drawable.ic_home);
    toolbar.setTitleTextColor(getResources().getColor(R.color.white));

    indicator = (CircleIndicator) findViewById(R.id.indicator);
    tabViewPager = (ViewPager) findViewById(R.id.pager);
    tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    slideViewPager = (ViewPager) findViewById(R.id.ad_viewpager);

    //Creating our pager adapter
    adapter = new Pager(getSupportFragmentManager(), this, NUM_TABS);
    //Adding the tabs using addTab() method
    for (int i = 0; i < NUM_TABS; i++)
      tabLayout.addTab(tabLayout.newTab().setCustomView(adapter.getTabView(i)));

    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
    tabLayout.setTabTextColors(getResources().getColor(R.color.grey),
        getResources().getColor(R.color.colorPrimary));

    //Adding adapter to pager
    tabViewPager.setAdapter(adapter);
    tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    //small work around to fix text color bug
    adapter.SetOnSelectView(tabLayout, 0);
    TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
      @Override public void onTabSelected(TabLayout.Tab tab) {
        int c = tab.getPosition();
        tabViewPager.setCurrentItem(tab.getPosition());
        adapter.SetOnSelectView(tabLayout, c);
      }

      @Override public void onTabUnselected(TabLayout.Tab tab) {
        int c = tab.getPosition();
        adapter.SetUnSelectView(tabLayout, c);
      }

      @Override public void onTabReselected(TabLayout.Tab tab) {

      }
    };
    //Adding onTabSelectedListener to swipe views
    tabLayout.addOnTabSelectedListener(tabSelectedListener);

    slidePagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
    slideViewPager.setAdapter(slidePagerAdapter);
    indicator.setViewPager(slideViewPager);
  }

  private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override public Fragment getItem(int position) {
      return new ScreenSlidePageFragment();
    }

    @Override public int getCount() {
      return NUM_PAGE_SLIDES;
    }
  }
}
