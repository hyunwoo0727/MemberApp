package com.example.hyunwoo0727.memberapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hb2011 on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService {

    private Map<String,MemberBean> map;
    private MemberDAO dao;

    private static MemberServiceImpl instance = new MemberServiceImpl();

    private MemberServiceImpl() {
    }

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    public static MemberServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean login(MemberBean mBean) {
        boolean loginOk = false;
        MemberBean m = dao.findByPK(mBean.getId());
        if(m!=null && m.getPw().equals(mBean.getPw())){
            loginOk = true;
            this.map();
        }
        return loginOk;
    }
    @Override
    public Map<?, ?> map() {
        this.map = new HashMap<String,MemberBean>();
        map = dao.selectMap();
        return map;
    }
    @Override
    public int regist(MemberBean mBean) {
        if(dao.findByPK(mBean.getId())==null){
            return dao.insert(mBean);
        }
        return 0;
    }
    @Override
    public int update(MemberBean mBean) {
        int result = dao.updatePw(mBean);
        if(result==1){
            this.map.put(mBean.getId(), dao.findByPK(mBean.getId()));
        }
        return result;
    }
    @Override
    public int delete(String id) {
     /*   int result = 0;
        MemberBean temp = (MemberBean) map.get(mBean.getId());
        if(temp.getPw().equals(mBean.getPw())){*/
           return dao.deleteMember(id);
      /*  }*/
     // return result;
    }
    @Override
    public int count() {
        return map.values().size();
    }

    @Override
    public MemberBean findById(String id) {
        return dao.findByPK(id);
    }

    @Override
    public List<MemberBean> findBy(String word) {
        List<MemberBean> findList = new ArrayList<MemberBean>();
        Set<?> keys = map.keySet();
        Iterator<?> it = keys.iterator();
        while(it.hasNext()){
            MemberBean tempBean = (MemberBean) map.get(it.next());
            if(tempBean.getName().contains(word)){
                findList.add(tempBean);
            }
        }
        return findList;
    }
    @Override
    public ArrayList<MemberBean> list() {
        this.map();
        ArrayList<MemberBean> allList = new ArrayList<MemberBean>();
        Set<?> keys = map.keySet();
        Iterator<?> it = keys.iterator();
        while(it.hasNext()){
            allList.add((this.map.get(it.next()))) ;
        }
        return allList;
    }

}
