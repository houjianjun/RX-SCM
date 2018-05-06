package com.xtwy.facade.user.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的描述：用户状态
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  18:21
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public enum UserStatusEnum {

    ACTIVE("激活", 100),
    INACTIVE("冻结", 101);

    /** 描述 */
    private String desc;
    /** 枚举值 */
    private int value;

    private UserStatusEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static UserStatusEnum getEnum(int value){
        UserStatusEnum resultEnum = null;
        UserStatusEnum[] enumAry = UserStatusEnum.values();
        for(int i = 0;i<enumAry.length;i++){
            if(enumAry[i].getValue() == value){
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        UserStatusEnum[] ary = UserStatusEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (int num = 0; num < ary.length; num++) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = String.valueOf(getEnum(ary[num].getValue()));
            map.put("value", String.valueOf(ary[num].getValue()));
            map.put("desc", ary[num].getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    /**
     * 转为List
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List toList(){
        UserStatusEnum[] ary = UserStatusEnum.values();
        List list = new ArrayList();
        for(int i=0;i<ary.length;i++){
            Map<String,String> map = new HashMap<String,String>();
            map.put("value",String.valueOf(ary[i].getValue()));
            map.put("desc", ary[i].getDesc());
            list.add(map);
        }
        return list;
    }
}
