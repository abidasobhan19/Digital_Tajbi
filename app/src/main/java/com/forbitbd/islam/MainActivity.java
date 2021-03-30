package com.forbitbd.islam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.forbitbd.islam.utils.AppPreference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btncount,btn_reset;
    private int counter = 0;
    private TextView result;

    private String _stringVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result= findViewById(R.id.count);
        btncount= findViewById(R.id.btn);
        btn_reset=findViewById(R.id.btn_reset);
        btncount.setOnClickListener(this);
        btn_reset.setOnClickListener(this);




    }

    @Override
    protected void onStart() {
        super.onStart();
        _stringVal = Integer.toString(AppPreference.getInstance(this).getCounter());
        result.setText( _stringVal);
    }

    @Override
    public void onClick(View view) {
        if(view == btncount){
//            Log.d("src", "Increasing value...");
            AppPreference.getInstance(this).increaseCounter();
            _stringVal = Integer.toString(AppPreference.getInstance(this).getCounter());
            result.setText( _stringVal);




        }else if(view == btn_reset){
            AppPreference.getInstance(this).resetCounter();
            counter = 0;
            result.setText(String.valueOf(counter));

            ;
        }



    }


}