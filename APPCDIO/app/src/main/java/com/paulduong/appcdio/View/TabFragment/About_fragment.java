package com.paulduong.appcdio.View.TabFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paulduong.appcdio.R;

/**
 * Created by PaulDuong on 6/28/2017.
 */

public class About_fragment extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment3, container, false);
        textView=(TextView)view.findViewById(R.id.txt3);
        return view;
    }
}
