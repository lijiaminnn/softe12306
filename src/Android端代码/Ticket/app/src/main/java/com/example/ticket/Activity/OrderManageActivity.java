package com.example.ticket.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

public class OrderManageActivity extends AppCompatActivity {
    protected static final String TAG = null;
    Button finishOrder,cancelOrder,changeOrder,returnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_manage);
        ExitApplication.getInstance().addActivity(this);

        finishOrder = (Button)findViewById(R.id.button_finish);
        /**
		 *已完成订单按钮点击事件
		 */
        finishOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
                String name = spf.getString("username","");/**获取登陆者用户名*/
                intent.setClass(OrderManageActivity.this,FinishedOrderListActivity.class);
                startActivity(intent);
            }
        });

        cancelOrder = (Button)findViewById(R.id.button_cancelTicket);
        /**
		 *退票按钮点击事件
		 */
        cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
                String name = spf.getString("username", "");/**获取登录着用户名*/
                intent.setClass(OrderManageActivity.this,CancelOrderActivity.class);
                startActivity(intent);
            }
        });

        changeOrder = (Button)findViewById(R.id.button_changeTicket);
        /**改签*/
        changeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
                String name = spf.getString("username", "");/**获取登录者用户名*/
                intent.setClass(OrderManageActivity.this,ChangeorderqueryActivity.class);
                startActivity(intent);
            }
        });
        /**返回主页*/
        returnMain = (Button)findViewById(R.id.returnMain);
        returnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(OrderManageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
