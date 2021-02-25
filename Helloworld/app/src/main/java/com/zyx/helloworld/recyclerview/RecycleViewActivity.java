package com.zyx.helloworld.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.zyx.helloworld.R;
import com.zyx.helloworld.listview.ListViewActivity;

public class RecycleViewActivity extends AppCompatActivity {
    private Button mBtnLinear;
    private Button mBtnHor;
    private Button mBtnGrid;
    private Button mBtnPu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtnLinear = findViewById(R.id.btn_linear);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnHor = findViewById(R.id.btn_hor);
        mBtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnGrid = findViewById(R.id.btn_grid);
        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnPu = findViewById(R.id.btn_pu);
        mBtnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, PullRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
