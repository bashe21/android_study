package com.zyx.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zyx.helloworld.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;   
    private OnItemClickListener mListener;

    private List<String> list;
    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new LinearViewHoder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
        } else {
            return new LinearViewHoder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2, parent, false));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == 0) {
            ((LinearViewHoder)holder).textView.setText("Hello World!");

        } else {
            ((LinearViewHoder2)holder).textView.setText("Hello andorid!");
            ((LinearViewHoder2)holder).imageView.setImageResource(R.drawable.image2);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHoder extends RecyclerView.ViewHolder {
        private TextView textView;
        public LinearViewHoder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHoder2 extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public LinearViewHoder2(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnItemClickListener {
        void onclick(int pos);
    }
}
