package com.blog.javaStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC-Jxin on 2017/11/7.
 */
public class ArrayTest {
    public static void main (String[] args){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list){
            if ("2".equals(item)){
                list.remove(item);
            }
        }
    }
}
