package com.zyx.helloworld.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zyx.helloworld.R;

public class PullRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvPu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_recycler_view);
        mRvPu = (RecyclerView) findViewById(R.id.rv_pu);
        mRvPu.addItemDecoration(new MyDecoration());
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvPu.setAdapter(new StaggteredGridAdapter(PullRecyclerViewActivity.this, new StaggteredGridAdapter.OnItemClickListener() {
            @Override
            public void onclick(int pos) {
                Toast.makeText(PullRecyclerViewActivity.this, "click:"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.dividerHeight2);
            outRect.set(gap, gap, gap, gap);
        }
    }
}