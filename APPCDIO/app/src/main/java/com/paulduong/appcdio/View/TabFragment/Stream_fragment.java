package com.paulduong.appcdio.View.TabFragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.paulduong.appcdio.Adapter.Course_Adapter;
import com.paulduong.appcdio.Model.Course_model;
import com.paulduong.appcdio.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PaulDuong on 6/28/2017.
 */

public class Stream_fragment extends Fragment implements View.OnClickListener{
    TextView textView;
    RecyclerView recyclerView;
    List<Course_model> course_models;
    Course_Adapter course_adapter;
    FloatingActionButton floatingActionButton;
    Dialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1, container, false);

        textView=(TextView)view.findViewById(R.id.textView);
        floatingActionButton= (FloatingActionButton)view.findViewById(R.id.float_course_fragment);
        floatingActionButton.setOnClickListener(this);






        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview_course);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        course_models = new ArrayList<Course_model>();

        loadRecyclerViewItem();





        return view;

    }

    // start load
    private void loadRecyclerViewItem() {
        //you can fetch the data from server or some apis
        //for this tutorial I am adding some dummy data directly
        for (int i = 1; i <= 5; i++) {
          Course_model myList = new Course_model("This is header "+ i, "This is content the value");
            course_models.add(myList);
        }

        course_adapter = new Course_Adapter(getActivity(),course_models);
        recyclerView.setAdapter(course_adapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.float_course_fragment:
                CustomDialog();
                break;



        }

    }
    // start diaglo
    public void CustomDialog(){

        dialog = new Dialog(getActivity());
        // it remove the dialog title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the laytout in the dialog
        dialog.setContentView(R.layout.float_layout);
        // set the background partial transparent
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Window window = dialog.getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        // set the layout at right bottom
        param.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        // it dismiss the dialog when click outside the dialog frame
        dialog.setCanceledOnTouchOutside(true);


        View question =(View)dialog.findViewById(R.id.question);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"you click question ",Toast.LENGTH_SHORT).show();
            }
        });
        View reuse_post =(View)dialog.findViewById(R.id.Reuse_post);
        reuse_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"you click reuse_post ",Toast.LENGTH_SHORT).show();
            }
        });

        View assignment =(View)dialog.findViewById(R.id.assigncement);
        assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"you click assignment ",Toast.LENGTH_SHORT).show();
            }
        });

       View announcement=(View)dialog.findViewById(R.id.announcement);
        announcement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"you click announcement ",Toast.LENGTH_SHORT).show();
            }
        });

        // initialize the item of the dialog box, whose id is demo1
        View demodialog =(View) dialog.findViewById(R.id.cross);
        // it call when click on the item whose id is demo1.

        demodialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diss miss the dialog
                dialog.dismiss();
                int id = v.getId();
                switch (id){
                    case R.id.announcement:

                        break;
                    case R.id.btn_assignment:
                        Toast.makeText(getActivity(),"you click announcement ",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_question:
                        Toast.makeText(getActivity(),"you click announcement ",Toast.LENGTH_SHORT).show();

                }

            }
        });

        // it show the dialog box
        dialog.show();

    }


    
}
