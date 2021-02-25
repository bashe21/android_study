package com.zyx.helloworld.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zyx.helloworld.R;

public class AActivity extends AppCompatActivity {
    private Button mBtnJump;
    private Button mBtnJump2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.d("AActiviy","--onCreate--");
        Log.d("AActivity","taskid:"+getTaskId()+", hash:"+hashCode());
        logTaskName();
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显示1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "zyx");
                bundle.putInt("number", 88);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent, 0);

                // 显示2
                //Intent intent = new Intent();
                //intent.setClass(AActivity.this, BActivity.class);
                //startActivity(intent);

                // 显示3
                //Intent intent = new Intent();
                //intent.setClassName(AActivity.this, "com.zyx.helloworld.jump.BActivity");
                //startActivity(intent);

                // 显示4
                //Intent intent = new Intent();
                //intent.setComponent(new ComponentName(AActivity.this, "com.zyx.helloworld.jump.BActivity"));
                //startActivity(intent);

                // 隐式1
                //Intent intent = new Intent();
                //intent.setAction("com.zyx.test.BActivity");
                //startActivity(intent);
            }
        });

        mBtnJump2 = findViewById(R.id.btn_jump2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().getString("title"), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActiviy","--onCreate--");
        Log.d("AActivity","taskid:"+getTaskId()+", hash:"+hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}