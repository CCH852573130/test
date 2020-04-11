package com.example.myapplication9;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main1Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv;
    //原图
    private Bitmap bitsrc;
    //拷贝图
    private Bitmap bitcopy;
    private Canvas canvas;
    private Paint paint;
    private int startX;
    private int startY;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        iv = (ImageView) findViewById(R.id.iv);
        setBitmap();

        // 设置触摸侦听
        iv.setOnTouchListener(new View.OnTouchListener() {



            // 触摸屏幕时，触摸事件产生时，此方法调用

            @Override

            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    // 用户手指摸到屏幕
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        break;
                    // 用户手指正在滑动
                    case MotionEvent.ACTION_MOVE:
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        canvas.drawLine(startX, startY, x, y, paint);
                        // 每次绘制完毕之后，本次绘制的结束坐标变成下一次绘制的初始坐标
                        startX = x;
                        startY = y;
                        iv.setImageBitmap(bitcopy);
                        break;
                    // 用户手指离开屏幕
                    case MotionEvent.ACTION_UP:
                        break;
                }
                // true：告诉系统，这个触摸事件由我来处理
                // false：告诉系统，这个触摸事件我不处理，这时系统会把触摸事件传递给imageview的父节点
                return true;
            }

        });
        initUI();
    }
    private void initUI(){
        findViewById(R.id.button11).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button11:
                Intent intent6 = new Intent();
                intent6.setClass(getApplicationContext(), Main5Activity.class);
                startActivity(intent6);
                break;
        }
    }

    public void setBitmap() {
        // 加载画画板的背景图
        bitsrc = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        // 创建图片副本
        // 1.在内存中创建一个与原图一模一样大小的bitmap对象，创建与原图大小一致的白纸
        bitcopy = Bitmap.createBitmap(bitsrc.getWidth(), bitsrc.getHeight(),
                bitsrc.getConfig());
        // 2.创建画笔对象
        paint = new Paint();
        // 3.创建画板对象，把白纸铺在画板上
        canvas = new Canvas(bitcopy);
        // 4.开始作画，把原图的内容绘制在白纸上
        canvas.drawBitmap(bitsrc, new Matrix(), paint);
        // 5.将绘制的图放入imageview中
        iv.setImageBitmap(bitcopy);
    }
    public void red(View view){
        paint.setColor(Color.RED);
    }
    public void green(View view){
        paint.setColor(Color.GREEN);
    }
    public void brush(View view){
        paint.setStrokeWidth(8);
    }
    public void cancel(View view){
        setBitmap();
    }
    public void eraser(View view){
        paint.setColor(Color.rgb(255,255,255));
        paint.setStrokeWidth(8);
    }
    public void save(View view){
        String path = Environment.getExternalStorageDirectory() + "/" + "2.png";
        File file = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitcopy.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}