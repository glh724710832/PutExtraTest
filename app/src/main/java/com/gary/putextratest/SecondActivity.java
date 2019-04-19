package com.gary.putextratest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button button_secondactivity;
    TextView text1_secondactivity;
    EditText edit1_secondactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        View();

    }

    void View(){
        button_secondactivity =findViewById(R.id.button_secondactivity);
        text1_secondactivity =findViewById(R.id.text1_secondactivity);
        edit1_secondactivity =findViewById(R.id.edit1_secondactivity);

        Intent intent = getIntent();
        String question = intent.getStringExtra("data");
        int num1 =Integer.valueOf(intent.getStringExtra("data1"));
        int num2 =Integer.valueOf(intent.getStringExtra("data2"));
        text1_secondactivity.setText(question);
        edit1_secondactivity.setText(num1+num2+"");

        button_secondactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("data_return",edit1_secondactivity.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
