package com.example.xrs_fang.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //声明全局数据数组和listView
    private String[] data;//数组
    private ListView listView;

    //自定义listview
    private ListView listV;
    private String[] from = {"img","text"};
    private int[] to = {R.id.imageview1,R.id.textview1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemactivity_layout);

//        data = getResources().getStringArray(R.array.arrayStr);
//        listView = (ListView)findViewById(R.id.listview1);

        //自定义listView
        listV = (ListView)findViewById(R.id.listview2);

        //新建适配器
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,getData(),R.layout.item_layout,from,to);
        listV.setAdapter(simpleAdapter);


    }


    //点击按钮显示listview
    public void listbtn(View view){
        Log.e("tag", "listbtn:");

        //系统的，一行一个字符串
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);


    }

    //自定义列表信息内容
    public List<Map<String,?>>getData(){

        List<Map<String,?>> list = new ArrayList<Map<String, ?>>();
        String [] listString = getResources().getStringArray(R.array.arrayS);
        int [] imageids = {R.drawable.p1,R.drawable.p2,R.drawable.p3};

        for (int i = 0; i<listString.length;i++){
            Map<String ,Object> map = new HashMap<String, Object>();
            map.put(from[0],imageids[i]);
            map.put(from[1],listString[i]);
            list.add(map);
        };

        return list;

    }
}
