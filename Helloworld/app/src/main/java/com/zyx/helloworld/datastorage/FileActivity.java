package com.zyx.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zyx.helloworld.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Android存储概念：
内部存储: Internal Storage，随应用卸载被删除
外部存储：External Storage 分为共有目录和私有目录。私有目录也是随应用卸载而被删除。
内部存储：
/data/data/<applicationId>/shared_prefs
/data/data/<applicationId>/databases
/data/data/<applicationId>/files
/data/data/<applicationId>/cache
context.getCacheDir()
context.getFilesDir()

外部存储
共有目录：
Environment.getExternalStoragePublicDirectory(int type)
私有目录：
/mnt/sdcard/Android/data/data/<applicationId>/cache
/mnt/sdcard/Android/data/data/<applicationId>/files
 */
/*
File内部存储
FileOutputStream
FileInputStream
 */
public class FileActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvContent;
    private final  String mFileName = "test.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mEtName = (EditText) findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });
    }

    // 存储信息
    private void save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
//            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE); // 内部存储
            // 外部存储
            // 创建文件夹
            File dir = new File(Environment.getExternalStorageDirectory(), "zyx");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 创建文件
            File file = new File(dir, mFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 读取信息
    private String read() {
        FileInputStream fileInputStream = null;
        try {
//            fileInputStream = openFileInput(mFileName); // 内部数据读取

            // 外部数据读取
            File file = new File((Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"zyx"),mFileName);
            fileInputStream = new FileInputStream(file);

            byte[] buff = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0) {
                stringBuilder.append(new String(buff, 0, len));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}