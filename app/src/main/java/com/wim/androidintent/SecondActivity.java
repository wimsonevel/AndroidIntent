package com.wim.androidintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Wim on 29-Jan-16.
 */
public class SecondActivity extends AppCompatActivity {

    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtShow = (TextView) findViewById(R.id.txtShow);

        Intent in = getIntent();
        String data = in.getStringExtra(MainActivity.TAG_MESSAGE);
        txtShow.setText(data);
    }
}
