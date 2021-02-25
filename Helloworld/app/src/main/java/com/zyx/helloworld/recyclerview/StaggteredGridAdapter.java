package com.zyx.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zyx.helloworld.R;

import java.util.List;

public class StaggteredGridAdapter extends RecyclerView.Adapter<StaggteredGridAdapter.LinearViewHoder> {

    private Context mContext;
    private OnItemClickListener mListener;

    private List<String> list;
    public StaggteredGridAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }
    @NonNull
    @Override
    public StaggteredGridAdapter.LinearViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHoder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggerd_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggteredGridAdapter.LinearViewHoder holder, final int position) {
        if (position % 2 != 0) {
            holder.imageView.setImageResource(R.drawable.image1);
        } else {
            holder.imageView.setImageResource(R.drawable.image2);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "click"+position, Toast.LENGTH_SHORT).show();
                mListener.onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHoder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public LinearViewHoder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener {
        void onclick(int pos);
    }
}
