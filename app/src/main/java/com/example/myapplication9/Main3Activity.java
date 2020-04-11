package com.example.myapplication9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initUI();
    }

    private void initUI() {
        findViewById(R.id.p2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.p2:
                Intent intent7 = new Intent();
                intent7.setClass(getApplicationContext(), Main6Activity.class);
                startActivity(intent7);
                break;

        }
    }
}