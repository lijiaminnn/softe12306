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
import android.widget.Toast;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

import java.util.ArrayList;
import java.util.Map;

public class CancelOrderActivity extends AppCompatActivity {
//    OrderDao oDao = new OrderDao(this);
//    TicketDao tDao = new TicketDao(this);
    ArrayList<Map<String,Object>> data = null;
    Button orderBtn,cancelOrder,changeOrder;
    ListView lv;
	/**
	 *重写父类onCreate（）方法
	 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_order);
        ExitApplication.getInstance().addActivity(this);

        lv = (ListView)findViewById(R.id.lv_cancelOrder);

        ExitApplication.getInstance().addActivity(this);

        /*SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
        String username = spf.getString("username","");*/
        //显示订单信息
        /*data = oDao.queryOrders(username);
        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.order_items,
                new String[]{"订单编号","车次","起始站","终点站","起始时间","到达时间",
                        "乘客姓名","身份证号","票价","日期","车票状态"},
                new int[]{R.id.orders_id2,R.id.orders_stationCode,
                        R.id.orders_start_station,R.id.orders_start_TIME,
                        R.id.orders_arrive_station1,R.id.orders_arrive_TIME,
                        R.id.orders_realname,R.id.orders_idNumber,
                        R.id.orders_costPrice,R.id.orders_date1,R.id.status_items});
        lv.setAdapter(adapter);

        orderBtn = (Button)findViewById(R.id.cancel_return_first);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(CancelOrderActivity.this,OrderManageActivity.class);
                startActivity(intent);
            }
        });

        //点击列表项，执行退票操作（数据库order表减少1，ticket表增加1）
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int id1 = Integer.parseInt(data.get(position).get("订单编号").toString());
                oDao.deleteOrder(id1);
                String trainCode = data.get(position).get("车次").toString();
                tDao.addByCode(trainCode);
                Toast.makeText(CancelOrderActivity.this,"退票成功",0).show();
                Intent intent = getIntent();
                intent.setClass(CancelOrderActivity.this,CancelOrderActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
