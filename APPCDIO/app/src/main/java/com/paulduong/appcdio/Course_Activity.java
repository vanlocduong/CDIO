package com.paulduong.appcdio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.paulduong.appcdio.Adapter.IconTabAdapter;
import com.paulduong.appcdio.View.TabFragment.Stream_fragment;
import com.paulduong.appcdio.View.TabFragment.Student_fragment;
import com.paulduong.appcdio.View.TabFragment.About_fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PaulDuong on 6/28/2017.
 */

public class Course_Activity extends AppCompatActivity  {
    ViewPager viewPager;
    TabLayout  tabLayout;

    IconTabAdapter iconTabAdapter;
    Toolbar toolbar;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_layout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        toolbar =(Toolbar)findViewById(R.id.toolbar_course);


        setSupportActionBar(toolbar);

        prepareDataResource();
        iconTabAdapter = new IconTabAdapter(getSupportFragmentManager(), fragmentList);

        // Bind the Adapter to the ViewPager
        viewPager.setAdapter(iconTabAdapter);

        // Link ViewPager and TabLayout
        tabLayout.setupWithViewPager(viewPager);

        setTabIcons(); // Set the icons to the Tabs

    }
    private void prepareDataResource() {

        fragmentList.add(new Stream_fragment());
        fragmentList.add(new Student_fragment());
        fragmentList.add(new About_fragment());
    }

    // Set the Icons of the Tabs
    private void setTabIcons() {

        tabLayout.getTabAt(0).setIcon(R.drawable.facebook);
        tabLayout.getTabAt(0).setText("Stream");
        tabLayout.getTabAt(1).setIcon(R.drawable.twitter);
        tabLayout.getTabAt(1).setText("Student");
        tabLayout.getTabAt(2).setIcon(R.drawable.googleplus);
        tabLayout.getTabAt(2).setText("About");
    }

// set menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater1= getMenuInflater();
        menuInflater1.inflate(R.menu.men_popup,menu);



//        MenuItem itApply = menu.findItem(R.id.itApply);
//        View giaoDien = MenuItemCompat.getActionView(itApply);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case  R.id.itApply:
                Toast.makeText(this,"you are click in Apply ",Toast.LENGTH_SHORT).show();
                return true;

        }

        return super.onOptionsItemSelected(item);

    }


}
