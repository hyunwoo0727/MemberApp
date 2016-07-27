package com.example.hyunwoo0727.memberapp;

/**
 * Created by hb2011 on 2016-07-27.
 */
public interface MemberService extends CommonService{
    public int regist(MemberBean mBean);
    public int update(MemberBean mBean);
    public int delete(MemberBean mBean);
    public MemberBean findById(String id);
    public MemberBean login(String id);
}
