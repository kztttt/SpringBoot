package com.bap;

import org.apache.kylin.jdbc.Driver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName KylinJdbc
 * @Author lyd
 * @Date $ $
 * @Vesion 1.0
 * @Description jdbc操作kylin
 **/
public class KylinJdbc {
    public void connentJdbc() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        Driver driver = (Driver) Class.forName("org.apache.kylin.jdbc.Driver").newInstance();
        Properties info = new Properties();
        info.put("user", "ADMIN");
        info.put("password", "KYLIN");
        Connection conn = driver.connect("jdbc:kylin://192.168.216.111:7070/sz_bap", info);
        Statement state = conn.createStatement();
        ResultSet resultSet = state.executeQuery("SELECT\n" +
                "USER_ID,\n" +
                "sum(SCHOOL_ORDERS),\n" +
                "sum(COMPANY_ORDER),\n" +
                "sum(HOME_ORDER),\n" +
                "sum(HOUR0_5_ORDER),\n" +
                "sum(HOUR6_12_ORDER),\n" +
                "sum(HOUR13_15_ORDER),\n" +
                "sum(HOUR16_20_ORDER),\n" +
                "sum(HOUR21_24_ORDER)\n" +
                "FROM SZBAP_DM.DM_ORDER_DISTRIBUTE\n" +
                "group by USER_ID,DT");
        while (resultSet.next()) {
            resultSet.getString(1);
            System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)
            +"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)
            +"\t"+resultSet.getString(5)+"\t"+resultSet.getString(6));
        }
    }

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        KylinJdbc ky = new KylinJdbc();
        ky.connentJdbc();
    }
}