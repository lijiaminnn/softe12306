package com.example.ticket.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.content.SharedPreferences;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticket.Info.TicketInfo;
import com.example.ticket.Info.ticket;
import com.example.ticket.Info.ticketadapter;
import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;
import com.example.ticket.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class QueryResultActivity extends AppCompatActivity {

    Button returnBooking;
    //TicketDao tDao = new TicketDao(this);//本地数据库；
//    Mybaseadapter adapter;
//    ViewHolder holder;
//    List<TicketInfo> _data;
//    TicketInfo info;
    List<Map<String,Object>> data = null;






    private String date;
    private ListView lv;
    public ArrayList<ticket> listticket;
    ticket ticketBean;
   // public JSONObject object;
    //public ArrayList<Map<String,Object>> list = new ArrayList<Map<String, Object>>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_result);


        //初始化数据
//        initData();
//        //适配器
//        adapter = new Mybaseadapter(_data);
//        lv.setAdapter(adapter);
        ExitApplication.getInstance().addActivity(this);
        returnBooking = (Button)findViewById(R.id.returnBooking);
        returnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(QueryResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });






        lv = (ListView)findViewById(R.id.query_listview);
        init();








        /**
		 *建立列表项事件
         *判断是否已登录,如果已经登录则跳到订单界面，否则跳转到提示登录界面
		 */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
                boolean isLogin = spf.getBoolean("login",false);/**默认初始化为未登录*/
                String username = spf.getString("username","");
                if (isLogin){
                    String trainCode = listticket.get(position).getTrainCode();
                    String firsttime = listticket.get(position).getStartTime();
                    String lastTime = listticket.get(position).getArriveTime();
                    String usetime = listticket.get(position).getUseTime();
                    String price = String.valueOf(listticket.get(position).getTicketPrice());
                    intent.setClass(QueryResultActivity.this,ConfirmOrdersActivity.class);
//                    intent.putExtra("trainCode",trainCode);
                    intent.putExtra("TrainCode",trainCode);
                    intent.putExtra("StartTime",firsttime);
                    intent.putExtra("ArriveTime",lastTime);
                    intent.putExtra("UseTime",usetime);
                    intent.putExtra("TicketPrice",price);
                    //intent.putExtra("username",username);
                    startActivity(intent);
                }else {
                    String trainCode = (String) data.get(position).get("TrainCode");
                    intent.setClass(QueryResultActivity.this,LoginActivity.class);
                    intent.putExtra("trainCode",trainCode);
                    //intent.putExtra("username",username);
                    startActivity(intent);
                }
            }
        });

    }










    /**
	 *获取json数据
	 */
    private void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Intent intent = getIntent();
                String startStation = intent.getStringExtra("from").toString().trim();
                String arriveStation = intent.getStringExtra("to").toString().trim();
                String datel = intent.getStringExtra("datel").toString().trim();
                RequestBody requestBody = new FormBody.Builder()
                        .add("StartStation",startStation)
                        .add("ArriveStation",arriveStation)
                        .add("date",datel)
                        .build();
                /**服务器返回的地址*/
                Request request = new Request.Builder()
                        .url("http://10.0.2.2:8080/Ticket/chaxuncheci.jsp")
                        .post(requestBody)
                        .build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    /**获取到数据*/
                    date = response.body().string();
                    /**把数据传入解析json数据方法*/
                    Message message = new Message();
                    message.what = 1;
                    han.sendMessage(message);
                    Gsonjx(date);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public Handler han = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    //Toast.makeText(QueryResultActivity.this,""+date,Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    lv.setAdapter(new ticketadapter(QueryResultActivity.this,listticket));/**调用listview适配器*/
                    break;
            }
        }
    };

    /**
	 *将网页获得的json数据提取其中的数据库信息
	 *@param String date
	 */
    private void Gsonjx(String date){
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(date).getAsJsonArray();
        Gson gson = new Gson();
        listticket = new ArrayList<>();
        for (JsonElement ticket:jsonArray){
            ticketBean = gson.fromJson(ticket,ticket.class);
            listticket.add(ticketBean);
        }
        Message message = new Message();
        message.what = 2;
        han.sendMessage(message);
    }









//    public void Show(final String word){
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                Toast.makeText(QueryResultActivity.this,word,Toast.LENGTH_SHORT).show();
//                Looper.loop();
//            }
//        });
//    }
//    private void initData(){
//        _data = new ArrayList<TicketInfo>();
//    }
//    public void parseGson(String jsonData){
//        _data.clear();
//        Gson gson = new Gson();
//        List<TicketInfo> TicketList = gson.fromJson(jsonData,new TypeToken<List<TicketInfo>>(){}.getType());
//        for(TicketInfo info:TicketList){
//            _data.add(info);
//        }
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //adapter.notifyDataSetChanged();
//            }
//        });
//    }
//    //listview的适配器
//    public class Mybaseadapter extends BaseAdapter {
//        private List<TicketInfo> _data;
//        public  Mybaseadapter(List<TicketInfo> _data){
//            this._data = _data;
//        }
//        @Override
//        public int getCount() {
//            return _data.size();
//        }
//        @Override
//        public Object getItem(int position) {
//            return _data.get(position);
//        }
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ViewHolder viewHolder = null;
//            if (convertView == null) {
//                viewHolder = new ViewHolder();
//                convertView = getLayoutInflater().inflate(R.layout.query_items, null);
//                viewHolder.TrainCode = (TextView) convertView.findViewById(R.id.TrainCode);
//                viewHolder.StartStation = (TextView) convertView.findViewById(R.id.FirstStation);
//                viewHolder.ArriveStation = (TextView) convertView.findViewById(R.id.LastStation);
//                viewHolder.StartTime = (TextView) convertView.findViewById(R.id.StartTime);
//                viewHolder.ArriveTime = (TextView) convertView.findViewById(R.id.ArriveTime);
//                viewHolder.UseTime = (TextView) convertView.findViewById(R.id.UseTime);
//                viewHolder.TicketNum = (TextView) convertView.findViewById(R.id.leftTicket);
//                viewHolder.TicketPrice = (TextView) convertView.findViewById(R.id.tvPrice);
//                viewHolder.date = (TextView) convertView.findViewById(R.id.tv_date2);
//                convertView.setTag(viewHolder);
//            } else {
//                viewHolder = (ViewHolder) convertView.getTag();
//            }
//            TicketInfo info = _data.get(position);
//            viewHolder.TrainCode.setText(info.getTrainCode());
//            viewHolder.StartStation.setText(info.getStartStation());
//            viewHolder.ArriveStation.setText(info.getArriveStation());
//            viewHolder.StartTime.setText(info.getStartTime());
//            viewHolder.ArriveTime.setText(info.getArriveTime());
//            viewHolder.UseTime.setText(info.getUseTime());
//            viewHolder.TicketNum.setText(info.getTicketNum());
//            viewHolder.TicketPrice.setText(String.valueOf(info.getTicketPrice()));
//            viewHolder.date.setText(info.getDate());
//            return convertView;
//        }
//    }
//    final static class ViewHolder {
//        TextView TrainCode;
//        TextView StartStation;
//        TextView ArriveStation;
//        TextView StartTime;
//        TextView ArriveTime;
//        TextView UseTime;
//        TextView TicketNum;
//        TextView TicketPrice;
//        TextView date;
//    }
}
