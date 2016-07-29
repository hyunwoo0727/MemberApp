package com.example.hyunwoo0727.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText et_id,et_pw;
    Button bt_login,bt_join;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button) findViewById(R.id.bt_join);
        service = new MemberServiceImpl(this.getApplicationContext());
        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                MemberBean mem = new MemberBean();
                mem.setId(et_id.getText().toString());
                mem.setPw(et_pw.getText().toString());
                if(service.login(mem)) {
                    startActivity(new Intent(this,HomeActivity.class));
                }
                break;
            case R.id.bt_join:
                startActivity(new Intent(this,JoinActivity.class));
                break;
        }
    }
}
