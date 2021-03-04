package com.zyx.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.zyx.helloworld.util.ToastUtil;
import com.zyx.helloworld.widget.MyButton;


/*
基于监听的事件处理机制：
事件源 事件 事件监听器
实现监听事件的方法：
1、通过内部类实现
2、通过匿名内部类实现
3、通过事件源所在类实现
4、通过外部类实现
5、布局文件中onClick属性（针对点击事件）
给同一个事件源添加多个同种类型监听器会则怎样？
系统会响应最后一个设置的监听器。注意：布局文件中的onClick属性会首先添加，所以同时开启内部类和布局属性文件属性时，会执行内部类的监听器。

基于回调的事件处理机制：

**/

/*
View的事件分发：
dispatchTouchEvent->setOnTouchListener->onTouchEvent
onClick/onLongClick来自onTouchEvent的处理
 */
/*
SharedPreferences 轻量数据存储
Xml形式，K-V形式
SharedPreferences
SharedPrefereces.Editor
 */
public class EventActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnEvent, mBtnHandler;
    private MyButton btnMy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnEvent = findViewById(R.id.btn_event);
        btnMy = findViewById(R.id.btn_my);
        // 从打印log可以看出，监听优先于回调
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "--onTouchEvent--");
                        break;
                }
                return false;
            }
        });

        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener", "--onclick--");
            }
        });
        btnMy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;// 返回true则会消耗掉该事件，不会再执行点击事件。
            }
        });
        // 通过内部类实现
        mBtnEvent.setOnClickListener(new OnClick());
        // 匿名内部类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("匿名内部类", "click");
//                ToastUtil.showMsg(EventActivity.this, "匿名内部类实现click2...");
//            }
//        });
        //通过事件源所在类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
        // 通过外部类实现
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));

        mBtnHandler = findViewById(R.id.btn_handler);
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "通过事件源所在类实现click...");
                break;
        }
    }

    class  OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event:
                    Log.d("内部类", "click");
                    ToastUtil.showMsg(EventActivity.this, "通过内部类实现实现click...");
                    break;
            }
        }
    }

    public void show(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                Log.d("通过布局", "click");
                ToastUtil.showMsg(EventActivity.this, "通过布局文件中onClick属性实现click...");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("ACtivity", "--onTouchEvent--");
        }
        return false;
    }
}