package com.paulduong.appcdio.View.FlashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.paulduong.appcdio.MainActivity;
import com.paulduong.appcdio.R;

public class FlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (Exception e){

                }finally {
                    Intent Home = new Intent(FlashActivity.this, MainActivity.class);
                    startActivity(Home);
                }
            }
        });

        thread.start();
    }
}
