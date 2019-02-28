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

public class ConfirmOrdersActivity extends AppCompatActivity {
    //TicketDao tDao = new TicketDao(this);
    List<Map<String,Object>> data = null;
    TextView stationCode,startStation,startTime,arriveStation,
            arriveTime,name,costTime,price,dates;
    Button orderBtn,returnResult;

    private String traincodes, startstations,arrivestations,starttimes,arrivetimes,costtimes,prices,datess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_orders);
        ExitApplication.getInstance().addActivity(this);

        findViews();
        Intent intent = getIntent();
        String firststation = intent.getStringExtra("from").toString().trim();
        String laststation = intent.getStringExtra("to").toString().trim();
        String date = intent.getStringExtra("datel").toString().trim();
        String checi = intent.getStringExtra("TrainCode").toString().trim();
        String qishishijian = intent.getStringExtra("StartTime").toString().trim();
        String daodashijian = intent.getStringExtra("ArriveTime").toString().trim();
        String yongshi = intent.getStringExtra("UseTime").toString().trim();
        String piaojia = intent.getStringExtra("TicketPrice").toString().trim();
        startStation.setText(firststation);
        arriveStation.setText(laststation);
        dates.setText(date);
        stationCode.setText(checi);
        arriveTime.setText(daodashijian);
        startTime.setText(qishishijian);
        costTime.setText(yongshi);
        price.setText(piaojia);

        startstations = intent.getStringExtra("from").toString().trim();
        arrivestations = intent.getStringExtra("to").toString().trim();
        datess = intent.getStringExtra("datel").toString().trim();
        traincodes = intent.getStringExtra("TrainCode").toString().trim();
        starttimes = intent.getStringExtra("StartTime").toString().trim();
        arrivetimes = intent.getStringExtra("ArriveTime").toString().trim();
        costtimes = intent.getStringExtra("UseTime").toString().trim();
        prices = intent.getStringExtra("TicketPrice").toString().trim();


//        setText();
        setListener();

    }

    /**
	 *提交订单的按钮
	 */
    private void setListener(){
        orderBtn.setOnClickListener(new View.OnClickListener() {
            //确认订单
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();

                intent.setClass(ConfirmOrdersActivity.this,ConfirmPayActivity.class);
                intent.putExtra("TrainCodes",traincodes);
                intent.putExtra("StartTimes",starttimes);
                intent.putExtra("ArriveTimes",arrivetimes);
                intent.putExtra("UseTimes",costtimes);
                intent.putExtra("TicketPrices",prices);
                intent.putExtra("StartStations",startstations);
                intent.putExtra("ArriveStations",arrivestations);
                intent.putExtra("datess",datess);
                intent.putExtra("pricess",prices);

                startActivity(intent);
            }
        });

        /**
		 *返回到查询结果界面
		 */
        returnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(ConfirmOrdersActivity.this,QueryResultActivity.class);
                startActivity(intent);
            }
        });
    }
//    private void setText(){
//        Intent intent = getIntent();
//        String trainCode = intent.getStringExtra("trainCode");
//        String username = intent.getStringExtra("username");
//        String date1 = intent.getStringExtra("date1");
//       Ticket t = tDao.queryByCode(trainCode);
//        stationCode.setText(t.getTrainCode());
//        startStation.setText(t.getStartStation());
//        startTime.setText(t.getStartTime());
//        arriveStation.setText(t.getArriveStation());
//        arriveTime.setText(t.getArriveTime());
//        costTime.setText(t.getUseTime());
//        price.setText(t.getTicketPrice()+"");
//        name.setText(username);
//        dates.setText(date1);
//    }

    private void findViews(){
        stationCode = (TextView)findViewById(R.id.stationCode);
        startStation = (TextView)findViewById(R.id.start_station);
        startTime = (TextView)findViewById(R.id.start_times);
        arriveStation = (TextView)findViewById(R.id.arrive_station1);
        arriveTime = (TextView)findViewById(R.id.arrive_times);
        name = (TextView)findViewById(R.id.name);
        costTime = (TextView)findViewById(R.id.costTime);
        price = (TextView)findViewById(R.id.costPrice);
        orderBtn = (Button)findViewById(R.id.submitOrder);
        returnResult = (Button)findViewById(R.id.returnResult);
        dates = (TextView)findViewById(R.id.confirm_date);
    }
}
