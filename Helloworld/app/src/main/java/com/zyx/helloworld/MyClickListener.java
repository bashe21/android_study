package com.zyx.helloworld;

import android.app.Activity;
import android.view.View;

import com.zyx.helloworld.listview.MyListAdapter;
import com.zyx.helloworld.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {
    private Activity mActivity;

    public MyClickListener(Activity activity) {
        this.mActivity = activity;
    }
    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(mActivity, "通过外部类实现click...");
    }
}
