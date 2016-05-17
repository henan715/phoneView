package com.example.nan.myphonestate.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.nan.myphonestate.R;
import com.example.nan.myphonestate.ui.fragment.BatteryFragment;
import com.example.nan.myphonestate.ui.fragment.DisplayFragment;
import com.example.nan.myphonestate.ui.fragment.OsFragment;
import com.example.nan.myphonestate.ui.fragment.PhoneFragment;
import com.example.nan.myphonestate.ui.fragment.RamFragment;
import com.example.nan.myphonestate.ui.fragment.ScrollFragment;
import com.example.nan.myphonestate.ui.fragment.StorageFragment;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

public class MainActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        setTitle("");
        mViewPager=(MaterialViewPager)findViewById(R.id.materialViewPager);
        mDrawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        mToolbar=mViewPager.getToolbar();
        if (mToolbar!=null){
            setSupportActionBar(mToolbar);
            final ActionBar actionBar=getSupportActionBar();
            if (actionBar!=null){
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }

        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawer,0,0);
        mDrawer.setDrawerListener(mDrawerToggle);

        mViewPager.getViewPager().setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position%6){
                    case 0:
                        return new BatteryFragment().getInstance();
                    case 1:
                        return new RamFragment().getInstance();
                    case 2:
                        return new StorageFragment().getInstance();
                    case 3:
                        return new DisplayFragment().getInstance();
                    case 4:
                        return new PhoneFragment().getInstance();
                    case 5:
                        return new OsFragment().getInstance();
                    case 6:
                        //return RecyclerViewFragment.newInstance();
                    default:
                        //return RecyclerViewFragment.newInstance();
                        return ScrollFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 7;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "电池";
                    case 1:
                        return "RAM";
                    case 2:
                        return "存储";
                    case 3:
                        return "屏幕";
                    case 4:
                        return "手机";
                    case 5:
                        return "系统";
                    case 6:
                        return "SIM卡";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener(){
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page){
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                android.R.color.holo_orange_light,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                    case 4:
                        return HeaderDesign.fromColorResAndUrl(
                                android.R.color.holo_green_light,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 5:
                        return HeaderDesign.fromColorResAndUrl(
                                android.R.color.holo_blue_bright,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 6:
                        return HeaderDesign.fromColorResAndUrl(
                                android.R.color.holo_purple,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }
                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo=findViewById(R.id.logo_white);
        if (logo!=null){
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        return mDrawerToggle.onOptionsItemSelected(item);
    }
}
