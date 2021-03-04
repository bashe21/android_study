package com.zyx.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zyx.helloworld.MainActivity;
import com.zyx.helloworld.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnSharedPreferences, mBtnFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        mBtnSharedPreferences = findViewById(R.id.btn_sharepreferences);
        mBtnSharedPreferences.setOnClickListener(this);

        mBtnFile = findViewById(R.id.btn_file);
        mBtnFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_sharepreferences:
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                startActivity(intent);
                break;
        }
    }
}