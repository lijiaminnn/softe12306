package com.example.ticket.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ticket.R;

import java.util.List;

/**
 * Created by 张燕华 on 2018/12/25.
 * 热门城市中GridView的适配器
 */

public class CityAdapter extends ArrayAdapter<String>{
    /**
     * 需要渲染的item布局文件
     */
    private int resource;

    public CityAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
        resource = textViewResourceId;
    }
	/**
	 *重写View空间的分布
	 *@param 参数1 position
	 *@param 参数2 convertView
	 *@param 参数3 parent
	 *@return layout 返回值为一个LinearLayout的布局
	 */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null){
            layout = (LinearLayout) LayoutInflater.from(getContext()).inflate(resource,null);
        }
        else {
            layout = (LinearLayout)convertView;
        }
        Button name = (Button)layout.findViewById(R.id.tv_city);
        name.setText(getItem(position));
        return layout;
    }

}
