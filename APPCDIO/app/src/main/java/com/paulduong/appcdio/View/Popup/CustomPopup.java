package com.paulduong.appcdio.View.Popup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;


import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;




import com.paulduong.appcdio.MainActivity;
import com.paulduong.appcdio.R;

import static com.paulduong.appcdio.R.id.toolbar;

/**
 * Created by PaulDuong on 6/28/2017.
 */

public class CustomPopup extends AppCompatActivity {
    Toolbar toolbar1;
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_popup);
        // set button home
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);


    }

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
