package com.bap.util;

/**
 * @ClassName MsgResponse
 * @Author lyd
 * @Date $ $
 * @Vesion 1.0
 * @Description 用于封装返回的json格式的数据
 **/
public class MsgResponse {
    private int code; //返回状态码

    private String msg;//返回状态信息

   /* //包含的数据
    private Map<String, Object> data = new HashMap<>();
    //添加包含的数据
    public MsgResponse add(String key, Object value)
    {
        this.getData().put(key, value);
        return this;
    }
    public Map<String, Object> getData()
    {
        return data;
    }

    public void setData(Map<String, Object> data)
    {
        this.data = data;
    }*/
   //包含的数据
   private Object data = null;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //成功信息
    public static MsgResponse success()
    {
        MsgResponse msg = new MsgResponse();
        msg.setCode(200);
        msg.setMsg("处理成功!");
        return msg;
    }

    //成功信息
    public static MsgResponse fail()
    {
        MsgResponse msg = new MsgResponse();
        msg.setCode(400);
        msg.setMsg("处理失败!");
        return msg;
    }



    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }


}