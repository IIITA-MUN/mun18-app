package com.shivansh.iiitamun18;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.shivansh.iiitamun18.AboutUsFragment;
import com.shivansh.iiitamun18.R;
/**
 * Created by Dell on 04-06-2018.
 */

public class AboutUsAdapter extends FragmentPagerAdapter {
    public static final int TOTAL_ITEMS = 4;

    public AboutUsAdapter(FragmentManager fm) {
        super(fm);
    }
  @Override
    public Fragment getItem(int position){

      Fragment fragment = new AboutUsFragment();
      Bundle args = new Bundle();
      args.putInt("Section Number", position);
      fragment.setArguments(args);

      return fragment;

  }
    @Override
    public int getCount() {
        return TOTAL_ITEMS;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "1. IIIT Allahabad";
            case 1:
                return "2. Effervescence";
            case 2:
                return "3. IIITA MUN";
            case 3:
                return "4. Sarasva";
        }

        return null;
    }
}
