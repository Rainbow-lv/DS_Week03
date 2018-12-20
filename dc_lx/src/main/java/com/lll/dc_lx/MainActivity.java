package com.lll.dc_lx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lll.dc_lx.adapter.LeftAdapter;
import com.lll.dc_lx.adapter.RightAdapter;
import com.lll.dc_lx.bean.Goods;
import com.lll.dc_lx.bean.Result;
import com.lll.dc_lx.bean.Shop;
import com.lll.dc_lx.core.BasePresenter;
import com.lll.dc_lx.core.DataCall;
import com.lll.dc_lx.presenter.CartPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataCall<List<Shop>> {

    private RecyclerView left_recy;
    private RecyclerView right_recy;
    private TextView mSumPrice;
    private TextView mCount;
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    private CartPresenter cartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left_recy = findViewById(R.id.left_recy);
        right_recy = findViewById(R.id.right_recy);
        mSumPrice = findViewById(R.id.goods_price);
        mCount = findViewById(R.id.goods_num);

        cartPresenter = new CartPresenter(this);

        left_recy.setLayoutManager(new LinearLayoutManager(this));
        right_recy.setLayoutManager(new LinearLayoutManager(this));

        //创建适配器
        leftAdapter = new LeftAdapter();
        rightAdapter = new RightAdapter();
        leftAdapter.setOnItemClickListenter(new LeftAdapter.OnItemClickListenter() {
            @Override
            public void onItemClick(Shop shop) {
                rightAdapter.clearList();//清空数据
                rightAdapter.addAll(shop.getList());
                rightAdapter.notifyDataSetChanged();
            }
        });
        left_recy.setAdapter(leftAdapter);
        rightAdapter.setOnNumListener(new RightAdapter.OnNumListener() {
            @Override
            public void onNum() {
                calculatePrice(leftAdapter.getList());
            }
        });
        right_recy.setAdapter(rightAdapter);

        cartPresenter.requestData();
    }

    private void calculatePrice(List<Shop> list) {
        double totalPrice=0;
        int totalNum = 0;
        for (int i = 0; i < list.size(); i++) {//循环的商家
            Shop shop = list.get(i);
            for (int j = 0; j < shop.getList().size(); j++) {
                Goods goods = shop.getList().get(j);
                //计算价格
                totalPrice = totalPrice + goods.getNum() * goods.getPrice();
                totalNum+=goods.getNum();//计数
            }
        }
        mSumPrice.setText("价格："+totalPrice);
        mCount.setText(""+totalNum);
    }

    @Override
    public void success(List<Shop> data) {
        calculatePrice(data);//计算价格和数量

        leftAdapter.addAll(data);//左边的添加类型

        //得到默认选中的shop，设置上颜色和背景
        Shop shop = data.get(1);
        shop.setTextColor(0xff000000);
        shop.setBackground(R.color.white);
        rightAdapter.addAll(shop.getList());



        leftAdapter.notifyDataSetChanged();
        rightAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(Result result) {
        Toast.makeText(this, result.getCode() + "   " + result.getMsg(), Toast.LENGTH_LONG).show();
    }
}
