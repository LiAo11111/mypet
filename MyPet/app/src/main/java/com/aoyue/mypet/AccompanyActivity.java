package com.aoyue.mypet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class AccompanyActivity extends AppCompatActivity {
private RecyclerView accompanyRecy ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accompany);
        accompanyRecy = findViewById(R.id.accompany_recy);
        accompanyRecy.setLayoutManager(new LinearLayoutManager(AccompanyActivity.this));
        accompanyRecy.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        initData();
    }

    private void initData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("     第一天                          0.3小时");
        list.add("     第二天                          0.1小时");
        list.add("     第三天                          0.2小时");
        list.add("     第四天                          0.3小时");
        list.add("     第五天                          0.4小时");
        list.add("     第六天                          0.6小时");
        list.add("     第七天                          4小时");
        list.add("     第八天                          0.5小时");
        list.add("     第九天                          0.3小时");
        list.add("     第十天                          0.8小时");
        list.add("     第十一天                         0.4小时");
        list.add("     第十二天                         0.3小时");
        list.add("     第十三天                         3小时");
        list.add("     第十四天                         0.8小时");
        list.add("     第十五天                         0.2小时");
        list.add("     第十六天                         0.6小时");
        list.add("     第十七天                         5小时");
        list.add("     第十八天                         0.6小时");
        list.add("     第十九天                         0.4小时");
        list.add("     第二十天                         0.2小时");
        list.add("     第二十一天                        0.3小时");
        list.add("     第二十二天                        2小时");
        accompanyRecy.setAdapter(new MyAdaper(AccompanyActivity.this,list));
    }
}