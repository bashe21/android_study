package com.zyx.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zyx.helloworld.fragment.ContainerActivity;
import com.zyx.helloworld.gridview.GridActivity;
import com.zyx.helloworld.jump.AActivity;
import com.zyx.helloworld.listview.ListViewActivity;
import com.zyx.helloworld.recyclerview.RecycleViewActivity;

public class UIActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgressBar;
    private Button mBtnCustomDialog;
    private Button mBtnPopWindow;
    private Button mBtnLifeCycle;
    private Button mBtnActivityA;
    private Button mBtnFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = (Button) findViewById(R.id.btn_textview);
//        mBtnTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 跳转得到TextView演示界面
//                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
//                startActivity(intent);
//            }
//        });

        mBtnButton = findViewById(R.id.btn_button);
//        mBtnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
//                startActivity(intent);
//            }
//        });

        mBtnEditText = findViewById(R.id.btn_edittext);
//        mBtnEditText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
//                startActivity(intent);
//            }
//        });

        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
//        mBtnRadioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, RadioButtonActivity.class);
//                startActivity(intent);
//            }
//        });

        mBtnCheckBox = findViewById(R.id.btn_checkbox);

        mBtnImageView = findViewById(R.id.btn_imageview);

        mBtnListView = findViewById(R.id.btn_listview);

        mBtnGridView = findViewById(R.id.btn_gridview);

        mBtnRecyclerView = findViewById(R.id.btn_recycleview);

        mBtnWebView = findViewById(R.id.btn_webview);

        mBtnToast = findViewById(R.id.btn_toast);

        mBtnDialog = findViewById(R.id.btn_dialog);

        mBtnProgressBar = findViewById(R.id.btn_progress);

        mBtnCustomDialog = findViewById(R.id.btn_custom_dialog);

        mBtnPopWindow = findViewById(R.id.btn_pop);

        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);

        mBtnActivityA = findViewById(R.id.btn_activity);

        mBtnFragment = findViewById(R.id.btn_frament);

        setListener();
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgressBar.setOnClickListener(onClick);
        mBtnCustomDialog.setOnClickListener(onClick);
        mBtnPopWindow.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnActivityA.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(UIActivity.this, GridActivity.class);
                    break;
                case R.id.btn_recycleview:
                    intent = new Intent(UIActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this,WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_custom_dialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_pop:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    intent = new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_activity:
                    intent = new Intent(UIActivity.this, AActivity.class);
                    break;
                case R.id.btn_frament:
                    intent = new Intent(UIActivity.this, ContainerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}