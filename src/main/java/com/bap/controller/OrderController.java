package com.bap.controller;

import com.bap.Mapper.OrderMapper;
import com.bap.entry.OrderDistribute;
import com.bap.util.MsgResponse;
import org.apache.kylin.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * {
 *     "code":200,
 *     "data":[],
 *     "msg":""
 * }
 **/
@RestController
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @RequestMapping(value = "/listOrderDistribute/{dt}",method = RequestMethod.GET)
    public MsgResponse listOrderDistribute(@PathVariable("dt")  String dt){
        MsgResponse mr = null;
        try {
            List<OrderDistribute> orderDistributes = orderMapper.listByDay(dt);
            if(orderDistributes != null){
                mr = MsgResponse.success();
                mr.setData(orderDistributes);
            } else {
                mr = MsgResponse.success();
                mr.setData("[]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mr = MsgResponse.fail();
            mr.setData("[]");
        }
        return mr;
    }


    @RequestMapping(value = "/listOrderDistributeKylin/{dt}",method = RequestMethod.GET)
    public MsgResponse listOrderDistributeKylin(@PathVariable("dt")  String dt){
        MsgResponse mr = null;
        OrderDistribute orderDistribute = new OrderDistribute();
        List<OrderDistribute> orderDistributes = new ArrayList<OrderDistribute>();
        try {
            Driver driver = (Driver) Class.forName("org.apache.kylin.jdbc.Driver").newInstance();

            Properties info = new Properties();
            info.put("user", "ADMIN");
            info.put("password", "KYLIN");
            Connection conn = driver.connect("jdbc:kylin://192.168.216.111:7070/sz_bap", info);
            Statement state = conn.createStatement();
            //kylin的传参数？？？
            ResultSet resultSet = state.executeQuery("");

            while (resultSet.next()) {
                orderDistribute.setUser_id(resultSet.getInt(1));
                orderDistribute.setSchool_orders(resultSet.getInt(2));
                orderDistribute.setCompany_order(resultSet.getInt(3));
                orderDistribute.setHome_order(resultSet.getInt(4));
                orderDistribute.setHour0_5_order(resultSet.getInt(5));
                orderDistribute.setHour6_12_order(resultSet.getInt(6));
                orderDistribute.setHour13_15_order(resultSet.getInt(7));
                orderDistribute.setHour16_20_order(resultSet.getInt(8));
                orderDistribute.setHour21_24_order(resultSet.getInt(9));
                orderDistribute.setDt(resultSet.getString(10));
                orderDistributes.add(orderDistribute);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mr = MsgResponse.fail();
            mr.setData("[]");
        }
        return mr;
    }
}