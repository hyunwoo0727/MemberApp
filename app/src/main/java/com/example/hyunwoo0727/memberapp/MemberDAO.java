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
    public static final String DB_NAME = "hanbitdb";

    public MemberDAO(Context context) {
        super(context, DB_NAME, null, 1); // contex = databases 까지
        Log.d("생성자","????????????????????????????");
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
                +PHONE+" text);";
        db.execSQL(sql);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        this.onCreate(db);
    }
    public int insert(MemberBean mBean){
        int result = 0;
        StringBuffer sb = new StringBuffer();
    //    sb.append("INSERT INTO MEMBER(ID,PW,NAME,REGDATE,SSN,EMAIL,PROFILE_IMG,PHONE) ");
      //  sb.append("VALUES(?,?,?,?,?,?,?,?)");
        sb.append("INSERT INTO MEMBER(ID,PW) VALUES(");
        sb.append("'"+mBean.getId()+"',");
        sb.append("'"+mBean.getPw()+"'");
        sb.append(");");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sb.toString());
        return result;
    }
    public int updatePw(MemberBean mBean){
        int result = 0;
        String sql = "UPDATE MEMBER SET PW=?,EMAIL=? WHERE ID=?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }
    public int deleteMember(String id){
        int result = 0;
        String sql = "DELETE FROM MEMBER WHERE ID=?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }
    public MemberBean findByPK(String pk){
        MemberBean findBean = null;
        String sql = "SELECT * FROM MEMBER WHERE ID='" +  pk +"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            findBean = new MemberBean();
            findBean.setId(cursor.getString(cursor.getColumnIndex("id")));
            findBean.setPw(cursor.getString(cursor.getColumnIndex("pw")));
        }
        return findBean;
    } // id
    public Map<String, MemberBean> selectMap() {
        Map<String, MemberBean> memberMap = new HashMap<String,MemberBean>();
        String sql = "SELECT * FROM MEMBER";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        return memberMap;
    }
}
