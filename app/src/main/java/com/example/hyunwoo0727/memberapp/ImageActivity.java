package com.example.hyunwoo0727.memberapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends Activity implements View.OnClickListener {
    ImageView iv_mid;
    Button bt_prev,bt_next;
    int index = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        iv_mid = (ImageView) findViewById(R.id.iv_mid);
        bt_prev = (Button) findViewById(R.id.bt_prev);
        bt_next = (Button) findViewById(R.id.bt_next);
        bt_prev.setOnClickListener(this);
        bt_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_prev:
                if(index==2){
                    bt_prev.setVisibility(View.INVISIBLE);
                    bt_next.setVisibility(View.VISIBLE);
                }
                index -= 1;

                this.setImage(index);
                break;
            case R.id.bt_next:
                if(index==7){
                    bt_next.setVisibility(View.INVISIBLE);
                    bt_prev.setVisibility(View.VISIBLE);
                }
                index += 1;
                this.setImage(index);
                break;
        }
    }

    public void setImage(int index){
        switch (index){
            case 1:
                iv_mid.setImageResource(R.drawable.default1);
                break;
            case 2:
                iv_mid.setImageResource(R.drawable.default2);
                break;
            case 3:
                iv_mid.setImageResource(R.drawable.default3);
                break;
            case 4:
                iv_mid.setImageResource(R.drawable.default4);
                break;
            case 5:
                iv_mid.setImageResource(R.drawable.default5);
                break;
            case 6:
                iv_mid.setImageResource(R.drawable.default6);
                break;
            case 7:
                iv_mid.setImageResource(R.drawable.default7);
                break;
            case 8:
                iv_mid.setImageResource(R.drawable.default8);
                break;

        }
    }
}
