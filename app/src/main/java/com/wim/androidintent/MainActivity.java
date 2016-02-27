package com.wim.androidintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG_MESSAGE = "data.MainActivity";

    private EditText txtInput;
    private Button btnSend1, btnSend2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = (EditText) findViewById(R.id.txtInputData);
        btnSend1 = (Button) findViewById(R.id.btnSend1);
        btnSend2 = (Button) findViewById(R.id.btnSend2);

        btnSend1.setOnClickListener(this);
        btnSend2.setOnClickListener(this);
    }

    private void startSecondAct(String sometext) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TAG_MESSAGE, sometext);
        startActivity(intent);
    }

    private void startThirdAct(String sometext) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(TAG_MESSAGE, sometext);
        startActivityForResult(intent, 48);
    }

    @Override
    public void onClick(View view) {
        if(view == btnSend1){
            startSecondAct(txtInput.getText().toString());
        }else if(view == btnSend2){
            startThirdAct(txtInput.getText().toString());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if((requestCode == 48) && (resultCode == RESULT_OK)){
            String message = data.getStringExtra(ThirdActivity.TAG_MESSAGE);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}