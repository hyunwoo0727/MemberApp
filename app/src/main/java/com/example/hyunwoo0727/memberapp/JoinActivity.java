package com.example.hyunwoo0727.memberapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class JoinActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_id,et_pw,et_name,et_ssn,et_email,et_phone;
    Button bt_join,bt_cancel;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this.getApplicationContext());
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_ssn = (EditText) findViewById(R.id.et_ssn);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_join.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_join :
                MemberBean mem = new MemberBean();
                mem.setId(et_id.getText().toString());
                mem.setPw(et_pw.getText().toString());
                mem.setName(et_name.getText().toString());
                mem.setEmail(et_email.getText().toString());
                mem.setSsn(et_ssn.getText().toString());
                mem.setProfile("default1.png");
                mem.setPhone(et_phone.getText().toString());
                service.regist(mem);
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.bt_cancel :
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
