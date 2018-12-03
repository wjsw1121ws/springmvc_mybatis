package com.cc.springmvc.exception;

/**
 * @Description:
 * @ClassName: MessageException
 * @Auther: changchun_wu
 * @Date: 2018/12/2 13:21
 * @Version: 1.0
 **/
public class MessageException extends Exception {
    public MessageException(String msg){
        this.msg=msg;
    }
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
