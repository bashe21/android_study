package com.zyx.helloworld.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zyx.helloworld.R;

import org.w3c.dom.Text;

public class BroadActivity extends AppCompatActivity {

    private Button mBtn;
    private TextView mTvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);

        mBtn = findViewById(R.id.btn1);
        mTvTest = (TextView) findViewById(R.id.tv_test);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadActivity.this, BroadActivity2.class);
                startActivity(intent);
            }
        });


    }
}