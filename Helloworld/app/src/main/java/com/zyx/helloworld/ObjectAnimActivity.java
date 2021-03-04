package com.zyx.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/*
属性动画：
属性动画会真正的改变对象的值；

 */
public class ObjectAnimActivity extends AppCompatActivity {
    private TextView mTvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        mTvTest = (TextView) findViewById(R.id.tv);

        //mTvTest.animate().translationYBy(500).setDuration(2000).start();

        //mTvTest.animate().alpha(0).setDuration(2000).start();

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                // valueAnimator 实际的值
//                Log.d("aaa", animation.getAnimatedValue()+"");
//                // 动画的进度0-1
//                Log.d("aaaa", animation.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvTest, "translationY", 0, 500, 200, 800);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}