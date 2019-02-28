package com.example.ticket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;

public class updatePassActivity extends AppCompatActivity {
    private Button contacts;
    private Button myInfo;
    private Button updatePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        ExitApplication.getInstance().addActivity(this);

        contacts = (Button)findViewById(R.id.contacts);
        myInfo = (Button)findViewById(R.id.personal_inf);
        updatePass = (Button)findViewById(R.id.update_pwd);

        updatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(updatePassActivity.this,PersonalInfoActivity.class);
                startActivity(intent);
            }
        });

        myInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(updatePassActivity.this,PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
