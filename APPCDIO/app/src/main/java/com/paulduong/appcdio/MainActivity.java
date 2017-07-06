package com.paulduong.appcdio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.paulduong.appcdio.View.Login.ChuyenDoiImage;
import com.paulduong.appcdio.View.Login.LoginActivity;
import com.paulduong.appcdio.View.Popup.CustomPopup;

import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ImageView img_photo;
    private TextView txt_name;
    private TextView txt_email;
    private TextView txt_id;
    private TextView txt_First_Name;

    private  TextView naname;
    private  TextView naemail;

    ImageView profilePictureView;
    CircleImageView profilePic;


    private ProfileTracker profileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        naname = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtnamena);
         naemail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtemailna);
        profilePictureView = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.imagprofic1);

//        profilePic=(CircleImageView)navigationView.getHeaderView(0).findViewById(R.id.imagprofic);


        img_photo = (ImageView) findViewById(R.id.photoImageView);
        txt_name = (TextView) findViewById(R.id.nameTextView);
        txt_email = (TextView) findViewById(R.id.emailTextView);
        txt_id = (TextView) findViewById(R.id.idTextView);
        txt_First_Name = (TextView) findViewById(R.id.first_NameTextView);

//        profileTracker = new ProfileTracker() {
//            @Override
//            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
//                if (currentProfile != null) {
//                    HienThi_Thongtin(currentProfile);
//                }
//            }
//        };
//
//        if (AccessToken.getCurrentAccessToken() == null) {
//            go_Dang_Nhap();
//        } else {
//            requestEmail(AccessToken.getCurrentAccessToken());
//
//            Profile profile = Profile.getCurrentProfile();
//            if (profile != null) {
//                HienThi_Thongtin(profile);
//            } else {
//                Profile.fetchProfileForCurrentAccessToken();
//            }
//        }
    final LayThongTinDangNhap layThongTinDangNhap= new LayThongTinDangNhap();
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                if (currentProfile != null) {
                    layThongTinDangNhap.HienThi_Thongtin(currentProfile);
                }
            }
        };

        if (AccessToken.getCurrentAccessToken() == null) {
                go_Dang_Nhap();
        } else {

            layThongTinDangNhap.requestEmail(AccessToken.getCurrentAccessToken());

            Profile profile = Profile.getCurrentProfile();
            if (profile != null) {
                layThongTinDangNhap.HienThi_Thongtin(Profile.getCurrentProfile());
            } else {
                Profile.fetchProfileForCurrentAccessToken();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                Toast.makeText(MainActivity.this,"you are click in setting ",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itAddKhoaHoc:
                Toast.makeText(MainActivity.this,"you are click in AddKhoaHoc ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CustomPopup.class);
                startActivity(intent);
                return true;
            case R.id.itJoinKhoaHoc:
                Toast.makeText(MainActivity.this,"you are click in JoinKhoaHoc ",Toast.LENGTH_SHORT).show();
                return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(MainActivity.this,"you are click in AddKhoaHoc ",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, CustomPopup.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(MainActivity.this,"you are click in AddKhoaHoc ",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Course_Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // lay thong tin
    public  class LayThongTinDangNhap{
        // add
        private void requestEmail(AccessToken currentAccessToken) {
            // tạo một yêu cầu lấy hồ sơ cá nhân của người dùng
            GraphRequest request = GraphRequest.newMeRequest(currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    if (response.getError() != null) {
                        Toast.makeText(getApplicationContext(), response.getError().getErrorMessage(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    try {
                        // truyền email cho phuong thuc setEmail khởi tạo ở dưới
                        String email = object.getString("email");
                        setEmail(email);
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id, first_name, last_name, email, gender, birthday, location");
            request.setParameters(parameters);
            request.executeAsync();
        }

        private void setEmail(String email) {
            txt_email.setText(email);
            naemail.setText(email);


        }




        // start hien thi thong tin
        private  void HienThi_Thongtin(Profile profile){
            String id = profile.getId();
            String name =profile.getName();
            String firstName = profile.getFirstName();

            String url_Anh=profile.getProfilePictureUri(100,100).toString();



            txt_id.setText(id);
            txt_name.setText(name);
            txt_First_Name.setText(firstName);

            naname.setText(name);

            // dùng thư  viện Glide để load ảnh về
            Glide.with(getApplicationContext())
                    .load(url_Anh)
                    .into(img_photo);
            Glide.with(getApplicationContext())
                    .load(url_Anh)
                    .asBitmap()
                    .transform(new ChuyenDoiImage(getApplicationContext()))
                    .into(profilePictureView);

        }

        // end hien thi thong tin

    }
    // start logout, gan su kien click trong file xml
    public void logout(View view) {
        LoginManager.getInstance().logOut();
        go_Dang_Nhap();
    }
    //end logout
    // start dangnhap den LoginActivity
    private  void go_Dang_Nhap(){
        Intent intent_DangNhap= new Intent(this,LoginActivity.class);
        intent_DangNhap.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent_DangNhap);
    }

    //end dangnhap
    // nhận thông báo thay đổi của profile nên được có
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // dùng việc tracking profile
        profileTracker.stopTracking();
    }

}
