package com.example.hyunwoo0727.memberapp;

/**
 * Created by hb2011 on 2016-07-27.
 */
public interface MemberService extends CommonService{
    public int regist(MemberBean mBean);
    public int update(MemberBean mBean);
    public int delete(String id);
    public MemberBean findById(String id);
    public boolean login(MemberBean mBean);
}
