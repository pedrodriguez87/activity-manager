package com.example.application2;

import android.view.View;
import android.widget.Toast;

public class A implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "A clicked", Toast.LENGTH_SHORT);

    }
}
