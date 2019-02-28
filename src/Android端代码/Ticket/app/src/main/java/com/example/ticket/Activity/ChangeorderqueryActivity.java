package com.example.ticket.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ChangeorderqueryActivity extends AppCompatActivity {
    private Button btSearch;
    private TextView tvD,tvM,tvY,From,To;
    private LinearLayout ll;
    private ListView lv;
    private String StartStation;
    private String ArriveStation;
    private String date,datel;
    private Calendar myCalendar;
//    OrderDao oDao = new OrderDao(this);
//    TicketDao tDao = new TicketDao(this);
    List<Map<String,Object>> data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeorderquery);
        ExitApplication.getInstance().addActivity(this);

        findViews();
        setText();
        setListener();
    }

	/**
	 *设置当前日期Calendar.getInstance（）方法
     *创建 日期对话框对象，五个参数
	 */
    private void selectDate(){

        myCalendar = Calendar.getInstance(Locale.CHINA);

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                //每次保存设置的日期
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                tvY.setText(year+"");
                tvM.setText((monthOfYear+1)+"");
                tvD.setText(dayOfMonth+"");
                datel = year+"-"+(monthOfYear+1)+"-"+dayOfMonth;

            }
        };

        DatePickerDialog dialog = new DatePickerDialog(this,listener,
                myCalendar.get(Calendar.YEAR),//默认当前年份
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();

    }

    /**
	 *日期布局管理器这个空间  绑定事件
	 */
    private void setListener(){
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });

        /*btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datel != null){
                    data = tDao.queryTicket(StartStation,ArriveStation,datel);
                    if (!data.isEmpty()){
                        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),data,
                                R.layout.query_items,
                                new String[]{"车次","起始站","终点站","出发时间","到达时间",
                                        "耗时","票数","票价","日期"},
                                new int[]{R.id.TrainCode,R.id.FirstStation,R.id.LastStation,
                                        R.id.StartTime,R.id.ArriveTime,R.id.UseTime,
                                        R.id.leftTicket,R.id.tvPrice,R.id.tv_date2});
                        lv.setAdapter(adapter);
                    }else {
                        Toast.makeText(getApplicationContext(),"您选的车次已经没票啦!",0).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"请选择要改签的日期",0).show();
                }
            }
        });
*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = getIntent();
                String trainCode = data.get(position).get("车次").toString();
                intent.putExtra("车次",trainCode);
                intent.setClass(ChangeorderqueryActivity.this,ConfirmChangeActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
	 *获取订单界面的起始站、终点站、日期参数
	 */
    private void setText(){
        Intent intent = getIntent();
        StartStation = intent.getStringExtra("起始站");
        From.setText(StartStation);
        ArriveStation = intent.getStringExtra("终点站");
        To.setText(ArriveStation);
    }
    /**
	 *初始化
	 */
    private void findViews(){
        From = (TextView)findViewById(R.id.change_from);
        To = (TextView)findViewById(R.id.change_to);
        ll = (LinearLayout)findViewById(R.id.linearLayout_changeDate);
        tvY = (TextView)findViewById(R.id.change_tvYear);
        tvM = (TextView)findViewById(R.id.change_tvMonth);
        tvD = (TextView)findViewById(R.id.change_tvDay);
        btSearch = (Button)findViewById(R.id.change_query);
        lv = (ListView)findViewById(R.id.change_listview);
    }
}
