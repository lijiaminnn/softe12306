package com.example.ticket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

public class MoreActivity extends AppCompatActivity {

    Button loginBn;
    Button registerBn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ExitApplication.getInstance().addActivity(this);

        loginBn = (Button)findViewById(R.id.login);
        registerBn = (Button)findViewById(R.id.register);
		/**登录按钮点击事件*/
        loginBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.setClass(MoreActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
		/**注册按钮点击事件*/
        registerBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
