package com.lll.dc_lx.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lll.dc_lx.R;
import com.lll.dc_lx.bean.Shop;

import java.util.ArrayList;
import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyHolder> {
    List<Shop> mList = new ArrayList<>();

    public void addAll(List<Shop> list) {
        mList.addAll(list);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.left_item, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        final Shop shop = mList.get(i);
        myHolder.text.setText(shop.getSellerName());
        myHolder.text.setBackgroundResource(shop.getBackground());
        myHolder.text.setTextColor(shop.getTextColor());
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int j = 0; j <mList.size() ; j++) {
                    mList.get(j).setTextColor(0xffffffff);
                    mList.get(j).setBackground(R.color.grayblack);
                }
                shop.setBackground(R.color.white);
                shop.setTextColor(0xff000000);
                notifyDataSetChanged();
                onItemClickListenter.onItemClick(shop);//切换右边的列表
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final TextView text;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.left_text);
        }
    }
    public List<Shop> getList() {
        return mList;
    }
    private OnItemClickListenter onItemClickListenter;

    public void setOnItemClickListenter(OnItemClickListenter onItemClickListenter) {
        this.onItemClickListenter = onItemClickListenter;
    }

    public interface OnItemClickListenter{
        void onItemClick(Shop shop);
    }

}
