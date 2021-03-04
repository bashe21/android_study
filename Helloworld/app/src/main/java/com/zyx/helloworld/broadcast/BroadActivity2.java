package com.zyx.helloworld.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zyx.helloworld.R;

public class BroadActivity2 extends AppCompatActivity {

    private Button mBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_2);

        mBtn2 = findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 已经弃用
//                LocalBroadCastManager localBroadCast =
            }
        });
    }
}