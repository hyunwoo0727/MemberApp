package com.example.hyunwoo0727.memberapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_id,et_pw,et_name,et_ssn,et_email,et_phone;
    Button bt_join,bt_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
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
                StringBuffer sb = new StringBuffer();
                sb.append("ID : " + et_id.getText());
                sb.append("\nPW : " + et_pw.getText());
                sb.append("\nNAME : " + et_name.getText());
                sb.append("\nSSN : " + et_ssn.getText());
                sb.append("\nEMAIL : " + et_email.getText());
                sb.append("\nPHONE : " + et_phone.getText());
                Toast.makeText(JoinActivity.this,sb.toString(),Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_cancel :
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
