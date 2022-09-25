package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultMessage;
    private Button btnGetAverage, btnViewPictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultMessage = (TextView) findViewById(R.id.txt1);

        btnGetAverage = (Button) findViewById(R.id.btnGetAverage);
        btnViewPictures = (Button) findViewById(R.id.btnViewPictures);

        btnGetAverage.setOnClickListener(this);
        btnViewPictures.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGetAverage:
                break;

            case R.id.btnViewPictures:
                break;

        }
    }
}