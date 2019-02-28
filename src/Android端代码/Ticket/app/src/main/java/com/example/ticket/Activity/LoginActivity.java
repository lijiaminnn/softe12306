package com.example.ticket.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ticket.R;
import com.example.ticket.util.ExitApplication;
import com.example.ticket.util.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPass;
    private Button logins;
    private Button register;
    private Button moreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ExitApplication.getInstance().addActivity(this);
        setViews();
        setListener();
    }

    private void setViews(){
        etName = (EditText)findViewById(R.id.etUsername);
        etPass = (EditText)findViewById(R.id.etPwd);
        logins = (Button)findViewById(R.id.btLogin);
        register = (Button)findViewById(R.id.btRegist);
        moreInfo = (Button)findViewById(R.id.textView_moreFun);
    }

    private void setListener(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MoreActivity.class);
                startActivity(intent);
            }
        });

        /** 
		 *登录按钮的点击事件
		 */
        logins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                final String username = etName.getText().toString().trim();
                String password = etPass.getText().toString().trim();

				/**
				 *获取用户输入的内容
                 *判断非空
                 *调用okhttp3的登录验证方法，如果为真则存在用户，否则该用户不存在，提示注册
				 */
                if(username.equals("")){
                    Looper.prepare();
                    Toast.makeText(LoginActivity.this,"用户名不能为空",Toast.LENGTH_SHORT ).show();
                    Looper.loop();
                }else if(password.equals("")){
                    Looper.prepare();
                    Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT ).show();
                    Looper.loop();
                }else{
					/**根据okhttp3方法向指定网页进行传参
					 *然后获得服务器的参数判断是否为已注册用户
					 */
                    RequestBody requestBody = new FormBody.Builder()
                            .add("username",username)
                            .add("password",password)
                            .build();
                    HttpUtil.getByOkHttp("http://192.168.43.63:8080/Ticket/login.jsp", requestBody, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Show("Fail");

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String data = response.body().string().trim();
                            /**登录成功跳转到下一个页面*/

                            if(data.equals("1")){
                                Looper.prepare();
                                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT ).show();
                                SharedPreferences.Editor editor = getSharedPreferences("checkLogin",
                                        MODE_PRIVATE).edit();
                                editor.putBoolean("login",true);
                                editor.commit();
                                Intent intent = getIntent();
                                String tabId = intent.getStringExtra("tabId");
                                if (tabId.equals("tab1")){
                                    intent.setClass(LoginActivity.this,ConfirmChangeActivity.class);
                                    startActivity(intent);
                                }else if (tabId.equals("tab2")){
                                    intent.setClass(LoginActivity.this,OrderManageActivity.class);
                                    startActivity(intent);
                                }else if (tabId.equals("tab3")) {
                                    intent.setClass(LoginActivity.this, TicketActivity.class);
                                    startActivity(intent);
                                }else if (tabId.equals("tab4")) {
                                    intent.setClass(LoginActivity.this, MoreBottomActivity.class);
                                    startActivity(intent);
                                }
                                Looper.loop();
                            }else{
                                //Toast.makeText(LoginActivity.this,"该用户不存在，请先注册",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
	/**
	 *显示错误的信息提示
	 */
    public void Show(final String word){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(LoginActivity.this,word,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        });
    }
}
