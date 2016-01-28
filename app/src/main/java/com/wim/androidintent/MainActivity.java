package com.wim.androidintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG_MESSAGE = "data.MainActivity";

    private EditText txtInput;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = (EditText) findViewById(R.id.txtInputData);
        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(this);
    }

    private void startSecondAct(String sometext) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TAG_MESSAGE, sometext);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view == btnSend){
            startSecondAct(txtInput.getText().toString());
        }
    }
}
