package com.zyx.helloworld.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zyx.helloworld.R;

public class ContainerActivity extends AppCompatActivity {
    private AFragment aFragment;
    private BFragment bFragment;
    private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        /*
        Fragment有自己的生命周期；
        Fragment依赖于Activity；
        Fragment通过getActivity()可以获取所在的Activity；Activity通过FragmentManager的findFragmentById()或findFragmentByTag()获取Fragment；
        Fragment和Activity是多对多的关系。
        * */
        mBtnChange = findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitNowAllowingStateLoss();
            }
        });
        // 实例化AFragment
        aFragment = AFragment.newInstance("我是参数");
        // 把AFragment添加到Activity中, 记得调用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment).commitAllowingStateLoss();
    }
}