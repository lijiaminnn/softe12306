package com.example.ticket.Activity;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText pass1;
    private EditText pass2;
    private EditText realname;
    private EditText phone;
    private EditText email;
    private EditText idCard;
    private Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ExitApplication.getInstance().addActivity(this);

        name = (EditText)findViewById(R.id.regist_name);
        pass1 = (EditText)findViewById(R.id.regist_pwd1);
        pass2 = (EditText)findViewById(R.id.regist_pwd2);
        realname = (EditText)findViewById(R.id.regist_realname);
        phone = (EditText)findViewById(R.id.regist_phone);
        email = (EditText)findViewById(R.id.regist_email);
        idCard = (EditText)findViewById(R.id.regist_cerifNum);
        registerBtn = (Button)findViewById(R.id.regist_btn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
				 *获取输入信息
                 *验证用户名，真实姓名，手机号码，邮箱，身份证是否已经被注册
                 *将信息添加到数据库
                 *跳转到下一个页面显示
				 */
                String res_name = name.getText().toString().trim();
                String res_pass1 = pass1.getText().toString().trim();
                String res_pass2 = pass2.getText().toString().trim();
                String res_realname = realname.getText().toString().trim();
                String res_phone = phone.getText().toString().trim();
                String res_email = email.getText().toString().trim();
                String res_idcard = idCard.getText().toString().trim();
                if(res_name.equals("")){
                    Looper.prepare();
                    Toast.makeText(RegisterActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }else if(!res_pass1.equals(res_pass2)){
                    Looper.prepare();
                    Toast.makeText(RegisterActivity.this,"密码不一致",Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }else{
                    RequestBody requestBody = new FormBody.Builder()
                            .add("username",res_name)
                            .add("password",res_pass1)
                            .add("realname",res_realname)
                            .add("telNumber",res_phone)
                            .add("email",res_email)
                            .add("IDCard",res_idcard).build();
                    HttpUtil.getByOkHttp("http://192.168.43.63:8080/Ticket/register.jsp", requestBody, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Show("Fail");

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String data = response.body().string().trim();
                            if(data.equals("1")){
                                Looper.prepare();
                                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                Intent intent = getIntent();
                                intent.setClass(RegisterActivity.this,PersonalInfoActivity.class);
                                startActivity(intent);
                                Looper.loop();
                            }
                        }
                    });
                }

                /*UserDao uDao = new UserDao(RegisterActivity.this);
                boolean flag = uDao.queryByName(res_name);
                if (flag){
                    Toast.makeText(RegisterActivity.this,"该用户名已经被注册了！",
                            Toast.LENGTH_LONG).show();
                }else {
                    if (!res_name.equals("") && !res_pass1.equals("") && !res_pass2.equals("")
                            && !res_realname.equals("") && !res_email.equals("")){
                        long res_tel = Long.parseLong(res_phone);
                        long res_idcard2 = Long.parseLong(res_idcard);
                        User user = new User(res_name,res_pass2,res_realname,
                                res_tel,res_email,res_idcard2);
                        uDao.register(user);//通过userDao将用户添加到数据库
                        Toast.makeText(RegisterActivity.this,"注册成功",
                                Toast.LENGTH_LONG).show();

                        System.out.println(user.getUsername());
                        Intent intent = getIntent();
                        intent.setClass(RegisterActivity.this,PersonalInfoActivity.class);
                        intent.putExtra("username",user.getUsername());
                        startActivity(intent);
                    }else {
                        Toast.makeText(RegisterActivity.this,
                                "以上输入框均为必填项，均不允许为空！",
                                Toast.LENGTH_LONG).show();
                    }
                }*/
            }
        });

    }
    public void Show(final String word){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(RegisterActivity.this,word,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        });
    }
}
