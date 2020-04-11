package com.example.myapplication9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化方法
        initUI();
    }
    private void initUI(){
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                Intent intent1 = new Intent();
                intent1.setClass(getApplicationContext(),Main1Activity.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent();
                intent2.setClass(getApplicationContext(),Main3Activity.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent();
                intent3.setClass(getApplicationContext(),Main2Activity.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent();
                intent4.setClass(getApplicationContext(),Main4Activity.class);
                startActivity(intent4);
                break;
        }

    }
}