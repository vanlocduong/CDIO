package game.example.hoangphong.classroom;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HocVien extends AppCompatActivity{

    ImageButton img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hoc_vien);
        img= (ImageButton)findViewById(R.id.imageButton);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(HocVien.this,ThemHocVien.class);
                startActivity(i);
            }
        });
    }
}
