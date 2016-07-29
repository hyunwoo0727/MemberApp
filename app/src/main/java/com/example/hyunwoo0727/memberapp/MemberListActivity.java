package com.example.hyunwoo0727.memberapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MemberListActivity extends Activity {
    ListView lv_memberlist;
    MemberService service;
    ArrayList<MemberBean> list;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        service = new MemberServiceImpl(this.getApplicationContext());

        list= (ArrayList<MemberBean>) service.list();
        this.setResource(list);
        lv_memberlist.setAdapter(new MemberAdapter(this,list));
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Object o = lv_memberlist.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Intent intent = new Intent(MemberListActivity.this,DetailActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);

            }
        });

        lv_memberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View v,
                                           int i, long l) {
                index=i;
                new AlertDialog.Builder(MemberListActivity.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                               service.delete(list.get(index).getId());
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                Log.v("long clicked","i: " + i);
                return true;
            }
        });
    }

    public void setResource(ArrayList<MemberBean> list){
        int i=0;
        for (;i<list.size();i++){
            String img = list.get(i).getProfile().substring(0,list.get(i).getProfile().indexOf("."));
            list.get(i).setPhoto(this.getResources().getIdentifier(img,"drawable",getPackageName()));
            Log.d("포토이름", list.get(i).getPhoto()+"??");
        }
    }

}
