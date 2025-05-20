package com.example.appfootballmanager.navigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appfootballmanager.fragment.HomeFragment;

public class ViewpagerAdater extends FragmentPagerAdapter {
    public ViewpagerAdater(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new HomeFragment();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 3;
    }
}
