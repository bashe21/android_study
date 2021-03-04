package com.zyx.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zyx.helloworld.datastorage.DataStorageActivity;
import com.zyx.helloworld.datastorage.FileActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnEventListener,mBtnDataStorage,mBtnAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);

        mBtnEventListener = findViewById(R.id.btn_event_listener);
        mBtnEventListener.setOnClickListener(onClick);

        mBtnDataStorage = findViewById(R.id.btn_data);
        mBtnDataStorage.setOnClickListener(onClick);

        // 申请读写权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        mBtnAnimation = findViewById(R.id.btn_animation);
        mBtnAnimation.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_event_listener:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_animation:
                    intent = new Intent(MainActivity.this, ObjectAnimActivity.class);
                    startActivity(intent);
                    break;


            }
        }
    }
}
