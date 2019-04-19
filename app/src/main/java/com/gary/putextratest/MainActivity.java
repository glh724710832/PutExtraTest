package com.gary.putextratest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText edit_1;
    EditText edit_2;
    EditText edit_sum;
    TextView edit_text1;
    TextView edit_text2;
    Button button_mainactivity;
    int Temp1;
    int Temp2;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_mainactivity = findViewById(R.id.button_mainactivity);
        edit_1 = findViewById(R.id.edit_1);
        edit_2 = findViewById(R.id.edit_2);
        edit_sum = findViewById(R.id.edit_sum);

        button_mainactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.putExtra("data",edit_1.getText().toString().trim()+"+"+edit_2.getText().toString().trim()+"=?");

                intent.putExtra("data1",edit_1.getText().toString().trim());
                intent.putExtra("data2",edit_2.getText().toString().trim());
                Log.d(TAG, edit_1.getText().toString().trim());
                Log.d(TAG, edit_2.getText().toString().trim());
                intent.setClass(MainActivity.this,SecondActivity.class);

                startActivityForResult(intent,1);
            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    edit_sum.setText(returnedData);
                }
                break;
             default:
        }
    }
}
