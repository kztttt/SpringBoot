package com.bap.Mapper;

import com.bap.entry.OrderDistribute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("SELECT\n" +
            "dod.user_id,\n" +
            "dod.school_orders,\n" +
            "dod.company_order,\n" +
            "dod.home_order,\n" +
            "dod.hour0_5_order,\n" +
            "dod.hour6_12_order,\n" +
            "dod.hour13_15_order,\n" +
            "dod.hour16_20_order,\n" +
            "dod.hour21_24_order\n" +
            "FROM dm_order_distribute dod\n" +
            "WHERE dod.dt >= #{dt} \n" +
            ";")
    public List<OrderDistribute> listByDay(String dt);
}