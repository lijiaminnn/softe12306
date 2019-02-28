package com.example.ticket.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

import java.util.ArrayList;
import java.util.Map;

/**
 * 改签：出发地和目的地都不可以更改，只能修改日期时间或车次。
 */

public class ChangeOrderActivity extends AppCompatActivity {
    //OrderDao oDao = new OrderDao(this);
    ArrayList<Map<String,Object>> data = null;
    Button orderBtn,cancelOrder,changeOrder;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_order);
        ExitApplication.getInstance().addActivity(this);

        lv = (ListView)findViewById(R.id.lv_changeOrder);

        SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
        String username = spf.getString("username", "");
        /**
		 *查询订单信息
		 */
        //data = oDao.queryOrders(username);
        SimpleAdapter adapter = new SimpleAdapter(this, data,R.layout.order_items,
                new String[]{"订单编号","车次","起始站","终点站","起始时间","到达时间",
                        "乘客姓名","身份证号","票价","日期","车票状态"},
                new int[]{R.id.orders_id2,R.id.orders_stationCode,
                        R.id.orders_start_station,R.id.orders_start_TIME,
                        R.id.orders_arrive_station1,R.id.orders_arrive_TIME,
                        R.id.orders_realname,R.id.orders_idNumber,
                        R.id.orders_costPrice,R.id.orders_date1,R.id.status_items});
        for (int i = 0; i<data.size(); i++){
            String status = (String) data.get(i).get("车票状态");
            if (status.equals("已支付")){
                lv.setAdapter(adapter);
            }
        }

        /**
		 *返回主页
		 */
        orderBtn = (Button)findViewById(R.id.change_return_first);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(ChangeOrderActivity.this,OrderManageActivity.class);
                startActivity(intent);
            }
        });
        /**
		 *ListView的item点击事件
		 *获取相应item的各个对应值
		 */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long orderid) {
                Intent intent = getIntent();
                intent.setClass(ChangeOrderActivity.this,ChangeorderqueryActivity.class);
                String fromStation = data.get(position).get("起始站").toString();
                String toStation = data.get(position).get("终点站").toString();
                String username = data.get(position).get("乘客姓名").toString();
                int ids = (Integer) data.get(position).get("订单编号");
                intent.putExtra("起始站",fromStation);
                intent.putExtra("终点站",toStation);
                intent.putExtra("订单编号",ids);
                intent.putExtra("乘客姓名",username);
                startActivity(intent);
            }
        });
    }
}
