package com.astra.discoversv;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.viewpager.widget.ViewPager;


import com.astra.discoversv.Adapters.ViewPagerAdapter;

import com.astra.discoversv.Fragments.DemoFragment;
import com.astra.discoversv.Fragments.MainFragment;
import com.astra.discoversv.Fragments.MapFragment;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.backdrop) ImageView backdrop;
    @BindView(R.id.appbar) AppBarLayout appBarLayout;
    @BindView(R.id.tabs_home) TabLayout tabLayout;
    @BindView(R.id.viewpager) ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        initCollapsingToolbar();
        initTabLayout();

    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (player != null){
//            player.release();
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO: Get current video time and restart from there when resumed
//        initPlayer();
    }


    private void initTabLayout(){
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(MainFragment.newInstance(), "Main");
        //ToDo: Use map to show location of restaurants, site seeing and hotels
        mViewPagerAdapter.addFragment(MapFragment.newInstance(), "Map");
        mViewPagerAdapter.addFragment(DemoFragment.newInstance(), "Tours & Taxis");
        mViewPager.setAdapter(mViewPagerAdapter);

        tabLayout.setupWithViewPager(mViewPager);
    }

    private void initCollapsingToolbar(){

        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        appBarLayout.setExpanded(true);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("");
//                    collapsingToolbar.setTitle(" ");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });

        try {
            Glide.with(this).load(R.drawable.plane_islands).into(backdrop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
