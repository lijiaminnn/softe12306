package com.example.ticket.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

import java.util.ArrayList;
import java.util.Map;

public class FinishedOrderListActivity extends AppCompatActivity {
    //OrderDao oDao = new OrderDao(this);
    ArrayList<Map<String,Object>> data = null;
    Button orderBtn;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_order_list);
        ExitApplication.getInstance().addActivity(this);
        lv = (ListView) findViewById(R.id.lv_orderlist);

        SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
        String username = spf.getString("username", "");

        //查询订单信息
        /*data = oDao.queryOrders(username);
        SimpleAdapter adapter = new SimpleAdapter(this, data,R.layout.order_items,
                new String[]{"订单编号","车次","起始站","起始时间","终点站",
                        "到达时间","乘客姓名","身份证号","票价","日期","车票状态"},
                new int[] {R.id.orders_id2,R.id.orders_stationCode,
                        R.id.orders_start_station,R.id.orders_start_TIME,
                        R.id.orders_arrive_station1,R.id.orders_arrive_TIME,
                        R.id.orders_realname,R.id.orders_idNumber,
                        R.id.orders_costPrice,R.id.orders_date1,R.id.status_items});
        lv.setAdapter(adapter);

        orderBtn = (Button) findViewById(R.id.return_first);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(FinishedOrderList.this,OrderManageActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
