package com.bean;

import java.io.Serializable;

public class Email implements Serializable {
    public static final long servialVersionUID = 1L;
    //邮箱地址
    private String mailAdd;
    //是否为一个标准邮箱
    private boolean email;{
        /**
        * 默认无参构造方法
        */
    }
    public Email(){
    }
    /**
    * 构造方法
    * @param mailAdd Email地址
    */
    public Email(String mailAdd){
        this.mailAdd = mailAdd;
    }
    /**
    * 是否为一个标准邮箱
    * @return 布尔值
    */
    public boolean isEmail(){
        String regex = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+[-.]\\w*";
        if (mailAdd.matches(regex)){
            email = true;
        }
        return email;
    }
    public String getMailAdd(){
        return mailAdd;
    }
    public void setMailAdd(String mailAdd){
        this.mailAdd = mailAdd;
    }

}
