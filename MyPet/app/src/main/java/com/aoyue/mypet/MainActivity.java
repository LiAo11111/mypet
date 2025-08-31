package com.aoyue.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.cpiz.android.bubbleview.BubbleTextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private String[] str={"主人，我好饿啊！","主人，你来陪我做游戏吧","主人，我要离家出走了","主人，我想和你玩啊","主人，我要去睡觉了"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView mainPet = findViewById(R.id.main_pet);
        BubbleTextView mainBb = findViewById(R.id.main_bb);
        AnimationDrawable anim  = (AnimationDrawable)mainPet.getBackground();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run(){
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(mainBb.getVisibility()==View.VISIBLE){
                            mainBb.setVisibility(View.INVISIBLE);
                        }else {
                            int i = new Random().nextInt(4);
                            mainBb.setText(str[i]);
                            mainBb.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,3*1000);
        anim.start();
        findViewById(R.id.dev_but).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, DevActivity.class));
            }
        });
        findViewById(R.id.accompany_but).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, AccompanyActivity.class));
            }
        });
        findViewById(R.id.task_but).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, TaskActivity.class));
            }
        });
    }
}