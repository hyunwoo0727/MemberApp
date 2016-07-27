package com.example.hyunwoo0727.memberapp;

import java.util.List;
import java.util.Map;

/**
 * Created by hb2011 on 2016-07-27.
 */
public interface CommonService {
    public List<?> list();
    public List<?> findBy(String keyword);
    public int count();
    public Map<?,?> map();
}
