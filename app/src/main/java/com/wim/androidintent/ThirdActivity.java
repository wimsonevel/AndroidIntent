package com.wim.androidintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Wim on 29-Jan-16.
 */
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG_MESSAGE = "data.ThirdActivity";

    private TextView txtShow;
    private EditText txtInput;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txtShow = (TextView) findViewById(R.id.txtShow);
        txtInput = (EditText) findViewById(R.id.txtSend);
        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(this);

        Intent in = getIntent();
        String data = in.getStringExtra(MainActivity.TAG_MESSAGE);
        txtShow.setText(data);
    }

    private void sendBackData(String sometext){
        Intent intent = getIntent();
        intent.putExtra(TAG_MESSAGE, sometext);
        setResult(RESULT_OK, intent);
    }

    @Override
    public void onClick(View view) {
        if(view == btnSend){
            sendBackData(txtInput.getText().toString());
            finish();
        }
    }
}