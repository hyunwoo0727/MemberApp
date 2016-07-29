package com.example.hyunwoo0727.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends Activity implements View.OnClickListener {
   TextView tv_id,tv_pw,tv_name,tv_ssn,tv_email
    ,tv_phone,tv_addr;
    MemberService service;
    MemberBean memberBean;
    Phone phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.init();
    }
    public void init(){
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_pw = (TextView) findViewById(R.id.tv_pw);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_ssn = (TextView) findViewById(R.id.tv_ssn);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_addr = (TextView) findViewById(R.id.tv_addr);
        service = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = getIntent();
        memberBean =  service.findById(intent.getStringExtra("id"));
        tv_id.setText(memberBean.getId());
        tv_pw.setText(memberBean.getPw());
        tv_name.setText(memberBean.getName());
        tv_ssn.setText(memberBean.getSsn());
        tv_email.setText(memberBean.getEmail());
        tv_phone.setText(memberBean.getPhone());
        tv_phone.setOnClickListener(this);
        phone = new Phone(this,this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_phone:
                phone.directCall(memberBean.getPhone());
                break;
        }
    }
}
