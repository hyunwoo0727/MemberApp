package com.example.hyunwoo0727.memberapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hb2011 on 2016-07-27.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "member";
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String SSN = "ssn";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String PROFILE = "profile";
    public static final String DB_NAME = "hanbitdb";

    public MemberDAO(Context context) {
        super(context, DB_NAME, null, 1); // contex = databases 까지
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("오푼","????????????????????????????");
        String sql = "create table if not exists "
                +TABLE_NAME
                +"("
                +ID+" text primary key, "
                +PW+" text, "
                +NAME+" text, "
                +SSN+" text, "
                +EMAIL+" text, "
                +PROFILE+" text, "
                +PHONE+" text);";
        db.execSQL(sql);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public int insert(MemberBean mBean){
        int result = 0;
        String sql = "INSERT INTO " + TABLE_NAME
                + String.format("(%s,%s,%s,%s,%s,%s,%s) ", ID,PW,NAME,SSN,EMAIL,PROFILE,PHONE)
                + String.format("values('%s','%s','%s','%s','%s','%s','%s');",
                mBean.getId(),mBean.getPw(),mBean.getName(),mBean.getSsn(),mBean.getEmail(),mBean.getProfile(),mBean.getPhone());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }
    public int updatePw(MemberBean mBean){
        String sql = "UPDATE "+TABLE_NAME+" SET "+PW+"='"+mBean.getPw()+"',"+EMAIL+"='"+mBean.getEmail()+"' WHERE "+ID+"='"+mBean.getId()+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return 1;
    }
    public int deleteMember(String id){
        int result = 1;
        String sql = "DELETE FROM "+TABLE_NAME+" WHERE "+ID+"='"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }
    public MemberBean findByPK(String pk){
        MemberBean findBean = null;
        String sql = "SELECT "
                + String.format("%s,%s,%s,%s,%s,%s,%s ", ID,PW,NAME,SSN,EMAIL,PROFILE,PHONE)
                + String.format("FROM " + TABLE_NAME + " WHERE ID = '%s'",pk);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            findBean = new MemberBean();
            findBean.setId(cursor.getString(cursor.getColumnIndex("id")));
            findBean.setPw(cursor.getString(cursor.getColumnIndex("pw")));
            findBean.setName(cursor.getString(cursor.getColumnIndex("name")));
            findBean.setSsn(cursor.getString(cursor.getColumnIndex("ssn")));
            findBean.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            findBean.setProfile(cursor.getString(cursor.getColumnIndex("profile")));
            findBean.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
        }
        return findBean;
    } // id
    public Map<String, MemberBean> selectMap() {
        Map<String, MemberBean> memberMap = new HashMap<String,MemberBean>();
        String sql = "SELECT * FROM " + TABLE_NAME+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }do{
            MemberBean findBean = new MemberBean();
            findBean.setId(cursor.getString(cursor.getColumnIndex("id")));
            findBean.setPw(cursor.getString(cursor.getColumnIndex("pw")));
            findBean.setName(cursor.getString(cursor.getColumnIndex("name")));
            findBean.setSsn(cursor.getString(cursor.getColumnIndex("ssn")));
            findBean.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            findBean.setProfile(cursor.getString(cursor.getColumnIndex("profile")));
            findBean.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            memberMap.put(findBean.getId(),findBean);
        }while(cursor.moveToNext());

        return memberMap;
    }
}
