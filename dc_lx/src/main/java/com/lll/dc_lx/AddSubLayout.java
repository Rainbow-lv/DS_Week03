package com.lll.dc_lx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddSubLayout extends LinearLayout implements View.OnClickListener {

    private TextView mAddBtn;
    private TextView mSubBtn;
    private TextView mNumText;
    private AddSubListener addSubListener;

    public AddSubLayout(Context context) {
        super(context);
        init();
    }

    public AddSubLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AddSubLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.car_add_sub_layout, this);
        mAddBtn = view.findViewById(R.id.btn_add);
        mSubBtn = view.findViewById(R.id.btn_sub);
        mNumText = view.findViewById(R.id.text_number);
        mAddBtn.setOnClickListener(this);
        mSubBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int number = Integer.parseInt(mNumText.getText().toString());
        switch (v.getId()){
            case R.id.btn_add:
                number++;
                mNumText.setText(number+"");
                break;
            case R.id.btn_sub:
                if (number==0){
                    Toast.makeText(getContext(),"数量不能小于0",Toast.LENGTH_LONG).show();
                    return;
                }
                number--;
                mNumText.setText(number+"");
                break;
        }
        if (addSubListener!=null){
            addSubListener.addSub(number);
        }
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int width = r-l;//getWidth();
        int height = b-t;//getHeight();

    }

    public void setCount(int count) {
        mNumText.setText(count+"");
    }

    public void setAddSubListener(AddSubListener addSubListener) {
        this.addSubListener = addSubListener;
    }

    public interface AddSubListener{
        void addSub(int count);
    }
}
