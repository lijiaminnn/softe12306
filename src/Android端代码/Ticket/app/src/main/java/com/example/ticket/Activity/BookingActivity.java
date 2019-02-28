package com.example.ticket.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

import java.util.Calendar;
import java.util.Locale;


public class BookingActivity extends Activity {

    private Button _searchbut;/**查询按钮*/
    private TextView tvD,tvM,tvY;/**日、月、年控件*/
    private Button _butstart_staion, _butend_station;/**起点站、终点站按钮*/
    private LinearLayout ll;/**日期选择控件*/
    private Calendar mycalendar;/**日历控件*/
    private String date,date1;
    private String StartStation,ArriveStation;

	
    /**
     *重写父类onCreate（）方法
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        ExitApplication.getInstance().addActivity(this);
        findView();
        setListeners();
    }

    /**
     *初始化按钮
     */
    private void findView(){
        tvY = (TextView)findViewById(R.id.tvYear);
        tvM = (TextView)findViewById(R.id.tvMonth);
        tvD = (TextView)findViewById(R.id.tvDay);
        _searchbut = (Button)findViewById(R.id.searchbut);

        ll = (LinearLayout)findViewById(R.id.linearLayout_startDate);

        _butstart_staion = (Button)findViewById(R.id.butstart_station);
        _butend_station = (Button)findViewById(R.id.butend_station);
    }

    /**
     * 设置监听器
     */
    private void setListeners(){

    /**
	 *日期布局管理器 绑定单击事件
	 */
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });

    /**
	 *单击查询按钮触发事件
	 */
        _searchbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(BookingActivity.this,QueryResultActivity.class);
                intent.putExtra("from",StartStation);
                intent.putExtra("to",ArriveStation);
                intent.putExtra("datel",date1);
                startActivity(intent);
            }
        });

    /**
	 *单击起始站按钮触发事件
	 */
        _butstart_staion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        /**
		 *得到StationActivity关闭后返回的数据，
         *第二个参数为请求码，可以根据业务需求自己编号
		 */
                startActivityForResult(new Intent(BookingActivity.this,ChooseStationActivity.class),1);
            }
        });

    /**
	 *单击终点站按钮触发事件
	 */
        _butend_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(BookingActivity.this,ChooseStationActivity.class),2);
            }
        });

    }

    /**
     * 1、为日期对话框设置监听事件：OnDateSetListener(),当日期选择的话，会触发这个事件
     * 2、复写onDateSet()方法
     */
    protected void selectDate(){
        /**设置当前日期*/
        mycalendar = Calendar.getInstance(Locale.CHINA);
        DatePickerDialog dialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        /**每次保存设置的日期*/
                        mycalendar.set(Calendar.YEAR,year);
                        mycalendar.set(Calendar.MONTH,monthOfYear);
                        mycalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        tvY.setText(year+"");
                        tvM.setText((monthOfYear+1)+"");
                        tvD.setText(dayOfMonth+"");

                        date1 = year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
                    }
                },
                mycalendar.get(Calendar.YEAR),/**默认当前日期*/
                mycalendar.get(Calendar.MONTH),
                mycalendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }

    /**
     * 为了得到传回的数据，需重写onActivityResult方法
     *
     * @param requestCode[in]:请求码，即调用startActivityForResult()传递过去的值
     * @param resultCode[in]：结果码，结果码用于标识返回数据来自哪个新的Activity
     * @param data[in]:输入参数3
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:/**起始站按钮返回值StartStation*/
                StartStation = data.getExtras().getString("result");/**得到新Activity关闭后返回的数据*/
                _butstart_staion.setText(StartStation);
                break;
            case 2:/**终点站按钮返回值ArriveStation*/
                ArriveStation = data.getExtras().getString("result");/**得到新Activity关闭后返回的数据*/
                _butend_station.setText(ArriveStation);
                break;

        }
    }
}

