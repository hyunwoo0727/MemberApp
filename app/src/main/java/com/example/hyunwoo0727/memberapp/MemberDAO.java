package com.example.hyunwoo0727.memberapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hb2011 on 2016-07-27.
 */
public class MemberDAO extends SQLiteOpenHelper {

    public MemberDAO(Context context) {
        super(context, "", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public int insert(MemberBean mBean){
        int result = 0;
        String sql = "INSERT INTO MEMBER(ID,PW,NAME,REGDATE,SSN,EMAIL,PROFILE_IMG,PHONE) VALUES(?,?,?,?,?,?,?,?)";

        return result;
    }
    public int updatePw(MemberBean mBean){
        int result = 0;
        String sql = "UPDATE MEMBER SET PW=?,EMAIL=? WHERE ID=?";

        return result;
    }
    public int deleteMember(String id){
        int result = 0;
        String sql = "DELETE FROM MEMBER WHERE ID=?";

        return result;
    }
    public MemberBean findByPK(String pk){
        MemberBean findBean = null;
        String sql = "SELECT * FROM MEMBER WHERE ID=?";

        return findBean;
    } // id
    public Map<String, MemberBean> selectMap() {
        Map<String, MemberBean> memberMap = new HashMap<String,MemberBean>();
        String sql = "SELECT * FROM MEMBER";

        return memberMap;
    }


}
