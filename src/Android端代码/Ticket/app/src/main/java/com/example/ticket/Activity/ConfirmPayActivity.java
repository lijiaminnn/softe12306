package com.example.ticket.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class ConfirmPayActivity extends AppCompatActivity {

    Button returnOrder;
    /*TicketDao tDao = new TicketDao(this);
    UserDao uDao = new UserDao(this);
    OrderDao oDao = new OrderDao(this);*/
    List<Map<String,Object>> data = null;
    TextView stationCode,startStation,startTime,arriveStation,
            arriveTime,name,costTime,price,date;
    Button payBtn,cancelBtn;
//    private String firststation,laststation,riqi,checi,qishishijian,daodashijian,yongshi,piaojia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pay);
        ExitApplication.getInstance().addActivity(this);

        findViews();



        Intent intent = getIntent();
        String firststations = intent.getStringExtra("StartStations").toString().trim();
        String laststations = intent.getStringExtra("ArriveStations").toString().trim();
        String dates = intent.getStringExtra("datess").toString().trim();
        String checis = intent.getStringExtra("TrainCodes").toString().trim();
        String qishishijians = intent.getStringExtra("StartTimes").toString().trim();
        String daodashijians = intent.getStringExtra("ArriveTimes").toString().trim();
        String yongshis = intent.getStringExtra("UseTimes").toString().trim();
        String piaojias = intent.getStringExtra("pricess").toString().trim();

        startStation.setText(firststations);
        arriveStation.setText(laststations);
        date.setText(dates);
        stationCode.setText(checis);
        arriveTime.setText(daodashijians);
        startTime.setText(qishishijians);
        costTime.setText(yongshis);
        price.setText(piaojias);

//        firststation = intent.getStringExtra("StartStations").toString().trim();
//        laststation = intent.getStringExtra("ArriveStations").toString().trim();
//        riqi = intent.getStringExtra("datess").toString().trim();
//        checi = intent.getStringExtra("TrainCodes").toString().trim();
//        qishishijian = intent.getStringExtra("StartTimes").toString().trim();
//        daodashijian = intent.getStringExtra("ArriveTimes").toString().trim();
//        yongshi = intent.getStringExtra("UseTimes").toString().trim();
//        piaojia = intent.getStringExtra("pricess").toString().trim();


        //setText();
        setListener();

    }

    /**
	 *取消订单按钮点击事件
	 */
    private void setListener() {
        //取消按钮
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(ConfirmPayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //返回
        returnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        /**
		 *确认支付点击事件
		 */
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                RequestBody requestBody = new FormBody.Builder()
//                        .add()
//                        .add()
//                        .add()
//                        .add()
//                        .build();




                Intent intent = getIntent();
                intent.setClass(ConfirmPayActivity.this,FinishedPayActivity.class);
                startActivity(intent);
            }
        });
    }

        //确认支付
//       payBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = getIntent();
////                String trainCode = intent.getStringExtra("trainCode");
////                tDao.updateByCode(trainCode);//更新余票量：每支付一个订单，火车站减少一张车票
////                //得到用户信息
////                SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
////                String username = spf.getString("username","");
////                System.out.println(username);
////                User user = uDao.queryByName1(username);
////                long userIdNum = user.getIdcard();
////                //得到车票信息
////                Ticket t = tDao.queryByCode(trainCode);
////                //增加一张订单，更新到数据库 订单表
////                String status = "已支付";
////                Order order = new Order(trainCode,t.getStartStation(),t.getArriveStation(),
////                        t.getStartTime(),t.getArriveTime(),user.getRealname(),username,
////                        userIdNum,t.getTicketPrice(),t.getDate(),status);
////                oDao.insertOrder(order);
//
//                intent.setClass(ConfirmPayActivity.this,FinishedPayActivity.class);
//                startActivity(intent);
//            }
//        });
//    }


    /*private void setText(){
        Intent intent = getIntent();
        String trainCode = intent.getStringExtra("trainCode");
        String username = intent.getStringExtra("username");
        String date1 = intent.getStringExtra("date1");
        Ticket t = tDao.queryByCode(trainCode);
        stationCode.setText(t.getTrainCode());
        startStation.setText(t.getStartStation());
        startTime.setText(t.getStartTime());
        arriveStation.setText(t.getArriveStation());
        arriveTime.setText(t.getArriveTime());
        costTime.setText(t.getUseTime());
        price.setText(t.getTicketPrice()+"");
        name.setText(username);
        date.setText((date1));
    }*/

    private void findViews(){
        payBtn = (Button)findViewById(R.id.payBtn);
        cancelBtn = (Button)findViewById(R.id.cancelBtn);
        stationCode = (TextView)findViewById(R.id.pay_stationCode);
        startStation = (TextView)findViewById(R.id.pay_start_station);
        startTime = (TextView)findViewById(R.id.pay_start_times);
        arriveStation = (TextView)findViewById(R.id.pay_arrive_station1);
        arriveTime = (TextView)findViewById(R.id.pay_arrive_times);
        name = (TextView)findViewById(R.id.pay_name);
        costTime = (TextView)findViewById(R.id.pay_costTime);
        date = (TextView)findViewById(R.id.pay_date);
        price = (TextView)findViewById(R.id.pay_costPrice);
        returnOrder = (Button)findViewById(R.id.returnConfirmOrder);



    }
}
