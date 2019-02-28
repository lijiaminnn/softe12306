package com.example.ticket.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by 张燕华 on 2018/12/25.
 * 自定义的GridView，解决在热门城市中嵌套GridView的显示不完全问题
 */

public class MyGirdView extends GridView {
    public MyGirdView(Context context) {
        super(context);
    }

    public MyGirdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGirdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 1.onMeasure函数决定了组件显示的高度与宽度；
     * 2.makeMeasureSpec函数中第一个函数决定布局空间的大小，第二个参数是布局模式;
     * 3.MeasureSpec.AT_MOST的意思就是子控件需要多大的空间就扩展到多大的空间;
     *
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //heightMeasureSpec  用expandSpec代替
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                View.MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
