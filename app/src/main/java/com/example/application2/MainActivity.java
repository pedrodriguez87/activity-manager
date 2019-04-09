package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView tvName;
    private TextView textTitle;
    private Button btnLoad;
    private EditText newtext;
    private Button detailLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate()", Toast.LENGTH_SHORT).show();


        btnLoad = findViewById(R.id.activity_main__btn__load);
        btnLoad.setOnClickListener(this);

        textTitle = findViewById(R.id.activity__main__tv__title);
        textTitle.setOnClickListener(this);

        tvName = findViewById(R.id.activity__main__tv__name);
        tvName.setOnClickListener(this);

        newtext = findViewById(R.id.activity__main__et__input);
        newtext.setOnClickListener(this);

        detailLoad = findViewById(R.id.activity_main_load_detail);
        detailLoad.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show();
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {

        String message = null;
        String message2 = "Hello ";



        switch (v.getId()) {
            case R.id.activity_main__btn__load:
                message = "button clicked";

                tvName.setText(message2 + newtext.getText().toString());
                btnLoad.setBackgroundColor(getResources().getColor(R.color.PedroColor));

                break;
            case R.id.activity__main__tv__title:
                message = "title clicked";
                break;
            case R.id.activity__main__tv__name:
                message = "";
                break;

            case R.id.activity_main_load_detail:
                Intent intent    = new Intent(this,    DetailActivity.class);

                intent.putExtra("data_from_main_activity", tvName.getText());
                startActivity(intent);

                startActivityForResult(intent, 101);
                break;
                default:


        }

        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data from edit-text", newtext.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        tvName.setText(inState.getString("data from edit-text"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            String returnData = data.getStringExtra("return_data");
            Toast.makeText(this, "Data returned: " + returnData,
                    Toast.LENGTH_SHORT).show();
        }
    }
}

