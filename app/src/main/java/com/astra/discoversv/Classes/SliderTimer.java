package com.astra.discoversv.Classes;

import android.app.Activity;

import androidx.viewpager.widget.ViewPager;

import java.util.TimerTask;

public class SliderTimer extends TimerTask {
    private ViewPager viewPager;
    private int size;
    private Activity activity;

    public SliderTimer(ViewPager viewPager, int size, Activity activity) {
        this.viewPager = viewPager;
        this.size = size;
        this.activity = activity;
    }

    @Override
    public void run() {
        activity.runOnUiThread(() -> {
            if (viewPager.getCurrentItem() < size - 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            } else {
                viewPager.setCurrentItem(0, true);
            }
        });
    }
}
