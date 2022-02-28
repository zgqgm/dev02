package com.fc.service;

import com.fc.bean.PageInfo;
import com.fc.bean.UserInfo;
import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    QueryRunner queryRunner = new QueryRunner();

    Connection connection = DruidUtil.getConnection();

    // 用于获取总数据量的方法
    public int getTotalCount(String tiaojian,String gender) {
        String app="'%"+tiaojian+"%'";
        String abb="'%"+gender+"%'";
        String sql= "select * from userinfo where name like "+app+" and gender like"+abb;
        List<UserInfo> list = null;
        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(UserInfo.class));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<UserInfo> getList(int pageNo, int pageSize,String tiaojian,String gender) {
        String app="'%"+tiaojian+"%'";
        String abb="'%"+gender+"%'";
        String sql= "select * from userinfo where name like "+app+" and gender like"+abb+" limit ?, ?";
        int start = (pageNo - 1) * pageSize;

        List<UserInfo> list = null;

        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(UserInfo.class), start, pageSize);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    public PageInfo<UserInfo> getPageInfo(int pageNo, int pageSize,String tiaojian,String gender) {
        int totalCount = getTotalCount(tiaojian,gender);

        List<UserInfo> list = getList(pageNo, pageSize,tiaojian,gender);
        return new PageInfo<>(pageNo, pageSize, totalCount, list);
    }
}
