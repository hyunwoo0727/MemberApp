package com.example.hyunwoo0727.memberapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MemberListActivity extends Activity {
    ListView lv_memberlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        ArrayList<MemberBean> list= this.getList();
        lv_memberlist.setAdapter(new MemberAdapter(this,list));
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = lv_memberlist.getItemIdAtPosition(position);
                MemberBean member = (MemberBean) o;
            }
        });
    }
    public ArrayList<MemberBean> getList(){
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        String[] names = {
                "cupcake",
                "donut",
                "eclair",
                "froyo",
                "gingerbread",
                "honeycomb",
                "icecream",
                "jellybean",
                "kitkat",
                "lollipop"
        };
        int i=0;
        while(i < names.length){
            MemberBean member = new MemberBean();
            member.setName(names[i++]);
            member.setPhone("010-4122-2361");
            list.add(member);
        }
        return list;
    }
}
