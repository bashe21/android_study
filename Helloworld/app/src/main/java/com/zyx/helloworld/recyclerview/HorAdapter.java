package com.zyx.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zyx.helloworld.R;

import java.util.List;

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHoder> {

    private Context mContext;
    private OnItemClickListener mListener;

    private List<String> list;
    public HorAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }
    @NonNull
    @Override
    public HorAdapter.LinearViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHoder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorAdapter.LinearViewHoder holder, final int position) {
        holder.textView.setText("Hello Android!");
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
        private TextView textView;
        public LinearViewHoder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener {
        void onclick(int pos);
    }
}
