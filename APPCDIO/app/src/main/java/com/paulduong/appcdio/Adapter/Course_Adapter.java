package com.paulduong.appcdio.Adapter;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.paulduong.appcdio.Model.Course_model;
import com.paulduong.appcdio.R;

import java.util.List;

/**
 * Created by PaulDuong on 7/4/2017.
 */

public class Course_Adapter extends RecyclerView.Adapter<Course_Adapter.MyViewHolder> {

    Context context;
    List<Course_model> list;

    public Course_Adapter(Context context, List<Course_model> list){

        this.context = context;
        this.list= list;

    }
    public  class  MyViewHolder extends  RecyclerView.ViewHolder{
        private TextView textView_name,textView_decription,textView_click_option;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView_name=(TextView)itemView.findViewById(R.id.textViewHead);
            textView_decription=(TextView)itemView.findViewById(R.id.textViewDesc);
            textView_click_option=(TextView)itemView.findViewById(R.id.textViewOptions);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.course_cardview_layout,parent,false);
        return new MyViewHolder(view);
    }
    // xu ly
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Course_model list_model = list.get(position);

        holder.textView_name.setText(list_model.getName());
        holder.textView_decription.setText(list_model.getDescription());
        holder.textView_click_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu(holder.textView_click_option);

            }
        });

    }
    public  void  ShowMenu(View view){
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.inflate(R.menu.option_cardview_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.itedit:

                        break;
                    case  R.id.itdelete:
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
