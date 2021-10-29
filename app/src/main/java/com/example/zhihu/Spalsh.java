package com.example.zhihu;
/**
 * @author Wraith-Chen
 * @Time 2021/10/29
 * 启动页面
 */
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Spalsh extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_spalsh);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Spalsh.this, MainActivity.class);
                startActivity(intent);
                Spalsh.this.finish();
            }
        },3000);
    }
}