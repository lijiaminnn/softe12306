package com.example.ticket.Activity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

public class MainActivity extends TabActivity {

    TabHost tabHost;
    Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
		 *去除标题,这个函数必须在setContentView()之前调用
		 */
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        ExitApplication.getInstance().addActivity(this);
        tabHost = getTabHost();
        resources = getResources();

        /**
		 *得到SharedPreferences来读取登录信息
		 */
        SharedPreferences spf = getSharedPreferences("checkLogin",MODE_PRIVATE);
        boolean isLogin = spf.getBoolean("login",false);//默认状态下初始化为用户未登录

        /**首页tab1（进行车票信息查询）*/
        Intent intent1 = new Intent(this,BookingActivity.class);
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setContent(intent1)
                .setIndicator("首页",resources.getDrawable(R.drawable.green_btn_out));
        intent1.putExtra("tabId","tab1");
        tabHost.addTab(tabSpec1);

        /**tab2:如果isLogin为true,表示已登录*/
        if (isLogin){
            Intent intent = getIntent();
            intent.setClass(this,OrderManageActivity.class);
            TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2").setContent(intent).
                    setIndicator("订单管理",resources.getDrawable(R.drawable.green_btn_out));
            tabHost.addTab(tabSpec2);

        }else {
            Intent intent = new Intent(this,LoginActivity.class);
            TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2").setContent(intent).
                    setIndicator("订单管理",resources.getDrawable(R.drawable.green_btn_out));
            intent.putExtra("tabId","tab2");
            tabHost.addTab(tabSpec2);
        }

        if (isLogin){
            Intent intent = new Intent(this,TicketActivity.class);
            String username = spf.getString("username","");
            TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setContent(intent).
                    setIndicator("我的资料",resources.getDrawable(R.drawable.green_btn_out));
            intent.putExtra("username",username);
            tabHost.addTab(tabSpec3);

        }else {
            Intent intent = new Intent(this,LoginActivity.class);
            TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setContent(intent).
                    setIndicator("我的资料",resources.getDrawable(R.drawable.green_btn_out));
            intent.putExtra("tabId","tab3");
            tabHost.addTab(tabSpec3);

        }

        if (isLogin){
            Intent intent = new Intent(this,MoreBottomActivity.class);
            String username = spf.getString("username","");
            TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("tab4").setContent(intent).
                    setIndicator("更多功能",resources.getDrawable(R.drawable.green_btn_out));
            intent.putExtra("username",username);
            tabHost.addTab(tabSpec4);

        }else {
            Intent intent = new Intent(this,MoreActivity.class);
            TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("tab4").setContent(intent).
                    setIndicator("更多功能",resources.getDrawable(R.drawable.green_btn_out));
            intent.putExtra("tabId","tab4");
            tabHost.addTab(tabSpec4);

        }

        tabHost.setCurrentTab(0);


    }
}
