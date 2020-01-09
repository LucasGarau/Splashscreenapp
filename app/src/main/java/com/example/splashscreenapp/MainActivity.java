package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] menu = getResources().getStringArray(R.array.menu);
        ListView menuList = (ListView) findViewById(R.id.ListView_Menu);
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,
                R.layout.menu_item, menu);
        menuList.setAdapter(adapt);


    }

}