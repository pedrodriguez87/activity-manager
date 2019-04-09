package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private Button dtLoad;
    private EditText dtText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textInfo = findViewById(R.id.textView_detail_activity);

        String data = getIntent().getStringExtra("data_from_main_activity");

        textInfo.setText(data);

        dtText = findViewById(R.id.editText_activity_detail);

        dtLoad = findViewById(R.id.activity__detail__btn__return_info);
        dtLoad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent returnIntent = new Intent();
                returnIntent.putExtra("return data", dtText.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();

            }
        });

    }

}
