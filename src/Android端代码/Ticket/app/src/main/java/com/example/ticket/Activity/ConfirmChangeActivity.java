package com.example.ticket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

import java.util.List;
import java.util.Map;

public class ConfirmChangeActivity extends AppCompatActivity {
//    TicketDao tDao = new TicketDao(this);
//    UserDao uDao = new UserDao(this);
//    OrderDao oDao = new OrderDao(this);
    List<Map<String,Object>> data = null;
    private final String STATUS = "改签票";
    TextView orderId,dates,startStation,startTime,arriveStation,
            arriveTime,name,stationCode,price,idCard,status;
    Button confirm_order,cancel_order,returnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_change);
        ExitApplication.getInstance().addActivity(this);

        findViews();
        //setText();
        setListener();
    }

    /**
	 *确认改签
	 */
    private void setListener(){
        confirm_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(ConfirmChangeActivity.this,FinishedOrderListActivity.class);
                startActivity(intent);
            }
        });

    }

    /*private void setText(){
        Intent intent = getIntent();
        //得到订单编号
        Bundle bundle = intent.getExtras();
        int ids = (Integer)bundle.getSerializable("订单编号");

        String trianCode = intent.getStringExtra("车次");
        //得到值
        Ticket t = tDao.queryByCode(trianCode);

        //得到姓名
        String realname = intent.getStringExtra("乘客姓名");
        System.out.println(realname);
        User user = uDao.queryByName1(realname);

        idCard.setText(user.getIdcard()+"");
        orderId.setText(ids+"");
        dates.setText(t.getDate());
        startStation.setText(t.getStartStation());
        startTime.setText(t.getStartTime());
        arriveStation.setText(t.getArriveStation());
        arriveTime.setText(t.getArriveTime());
        name.setText(realname);
        stationCode.setText(t.getTicketPrice()+"");
        status.setText(STATUS);

        oDao.updateOrder(t,STATUS,ids);
        tDao.updateByCode(trianCode);

    }*/

    /**
	 *显示对应的ticket布局id
	 */
    private void findViews(){
        orderId = (TextView)findViewById(R.id.orders_id2);
        dates = (TextView)findViewById(R.id.orders_date1);
        startStation = (TextView)findViewById(R.id.orders_start_station);
        startTime = (TextView)findViewById(R.id.orders_start_TIME);
        arriveStation = (TextView)findViewById(R.id.orders_arrive_station1);
        arriveTime = (TextView)findViewById(R.id.orders_arrive_TIME);
        name = (TextView)findViewById(R.id.orders_username);
        stationCode = (TextView)findViewById(R.id.orders_stationCode);
        price = (TextView)findViewById(R.id.orders_costPrice);
        idCard = (TextView)findViewById(R.id.orders_idNumber);
        status = (TextView)findViewById(R.id.status_change);

        confirm_order = (Button)findViewById(R.id.confirm_change_bn);
        cancel_order = (Button)findViewById(R.id.cancel_change_bn);

        returnResult = (Button)findViewById(R.id.returnConfirmOrder);

    }
}
