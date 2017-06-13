package me.nabeelkottol.spotsoon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
  ViewPager tabViewPager;
  ViewPager slideViewPager;
  PagerAdapter slidePagerAdapter;

  private static final int NUM_PAGE_SLIDES = 5;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Home");
    CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
    toolbar.setTitleTextColor(getResources().getColor(R.color.white));

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    //Adding the tabs using addTab() method
    tabLayout.addTab(tabLayout.newTab().setText("VIDEOS").setIcon(R.drawable.videos_selector));
    tabLayout.addTab(tabLayout.newTab().setText("IMAGES").setIcon(R.drawable.images_selector));
    tabLayout.addTab(
        tabLayout.newTab().setText("MILESTONE").setIcon(R.drawable.milestone_selector));

    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
    tabLayout.setTabTextColors(Color.parseColor("#707070"),
        getResources().getColor(R.color.colorPrimary));
    //Initializing tabViewPager
    tabViewPager = (ViewPager) findViewById(R.id.pager);

    //Creating our pager adapter
    Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

    //Adding adapter to pager
    tabViewPager.setAdapter(adapter);
    tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
      @Override public void onTabSelected(TabLayout.Tab tab) {
        tabViewPager.setCurrentItem(tab.getPosition());
      }

      @Override public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override public void onTabReselected(TabLayout.Tab tab) {

      }
    };
    //Adding onTabSelectedListener to swipe views
    tabLayout.addOnTabSelectedListener(tabSelectedListener);

    slideViewPager = (ViewPager) findViewById(R.id.ad_viewpager);
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
