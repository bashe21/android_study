package com.zyx.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zyx.helloworld.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button mBtnToast1, mBtnToast2, mBtnToast3, mBtnToast4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_3);
        mBtnToast4 = findViewById(R.id.btn_toast_4);
        OnClick onClick = new OnClick();
        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toast = Toast.makeText(getApplicationContext(), "Toast Center", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toast_custom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_toast);
                    TextView textView = (TextView) view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.smile);
                    textView.setText("自定义Toast");
                    toast_custom.setView(view);
                    toast_custom.setDuration(Toast.LENGTH_LONG);
                    toast_custom.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(), "包装过后的Toast");
                    break;
            }
        }
    }
}