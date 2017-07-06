package game.example.hoangphong.classroom;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity implements OnMenuSelectedListener{
    String arrayName[]={"Thông báo" ,"Bài tập","Câu hỏi","Sử dụng lại bài đăng"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luong);
        //setContentView(R.layout.activity_cauhoi);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.plus, R.drawable.delete);
        circleMenu.addSubMenu(Color.CYAN, R.drawable.cauhoi);
        circleMenu.addSubMenu(Color.GREEN, R.drawable.thongbao);
        circleMenu.addSubMenu(Color.BLUE, R.drawable.cauhoi);
        circleMenu.addSubMenu(Color.YELLOW, R.drawable.thongbao);
        circleMenu.setOnMenuSelectedListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.add:
                AlertDialog.Builder mBuilder= new AlertDialog.Builder(MainActivity.this) ;
                View mView= getLayoutInflater().inflate(R.layout.layout_dangkikhoahoc,null);
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMenuSelected(int i) {
        switch (i){
            case 0:
                Intent itent =new Intent(MainActivity.this,bai_tap.class);
                startActivity(itent);
                break;
            case 2:
                Intent itent2 =new Intent(MainActivity.this,thongbao_layout.class);
                startActivity(itent2);
                break;
            case 3:
                Intent itent3 =new Intent(MainActivity.this,cauhoi.class);
                startActivity(itent3);
                break;
            case 4:
                Intent iten4 =new Intent(MainActivity.this,bai_tap.class);
                startActivity(iten4);
                break;
        }

    }


}
