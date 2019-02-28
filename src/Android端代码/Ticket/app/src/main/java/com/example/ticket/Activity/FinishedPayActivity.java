package com.example.ticket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

public class FinishedPayActivity extends AppCompatActivity {
    //TicketDao tDao = new TicketDao(this);
    Button toOrderList,returnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_pay);
        ExitApplication.getInstance().addActivity(this);
        /**
		 *�ҵĶ�����ť����¼�
		 */
        toOrderList = (Button)findViewById(R.id.toOrderList);
        toOrderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(FinishedPayActivity.this,FinishedOrderListActivity.class);
                startActivity(intent);
            }
        });

        /**
		 *������ҳ��ť����¼�
		 */
        returnFirst = (Button)findViewById(R.id.return_First);
        returnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(FinishedPayActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
