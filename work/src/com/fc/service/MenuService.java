package com.fc.service;

import com.fc.bean.PageInfo;
import com.fc.bean.UserInfo;
import com.fc.bean.menuInfo;
import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuService {
    QueryRunner queryRunner = new QueryRunner();

    Connection connection = DruidUtil.getConnection();

    // 用于获取总数据量的方法
    public int getTotalCount(String tiaojian,String cut) {
        String app="'%"+tiaojian+"%'";
        String abb="'%"+cut+"%'";
        if (cut.equals("") && !tiaojian.equals("")){}
        String sql ="select nmi.id,nm.name AS cut,nmi.name from nav_menu_re_item join nav_menu nm on nav_menu_re_item.menu_id = nm.id join nav_menu_item nmi on nav_menu_re_item.item_id = nmi.id " +
                "where nm.name like "+abb+" and nmi.name like"+app;
        List<menuInfo> list = null;
        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(menuInfo.class));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<menuInfo> getList(int pageNo, int pageSize,String tiaojian,String cut) {
        String app="'%"+tiaojian+"%'";
        String abb="'%"+cut+"%'";
        String sql= "select nmi.id,nm.name AS cut,nmi.name from nav_menu_re_item join nav_menu nm on nav_menu_re_item.menu_id = nm.id join nav_menu_item nmi on nav_menu_re_item.item_id = nmi.id " +
                "where nm.name like "+abb+" and nmi.name like"+app+" limit ?, ?";
        int start = (pageNo - 1) * pageSize;

        List<menuInfo> list = null;

        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(menuInfo.class), start, pageSize);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    public PageInfo<menuInfo> getPageInfo(int pageNo, int pageSize,String tiaojian,String cut) {
        int totalCount = getTotalCount(tiaojian,cut);

        List<menuInfo> list = getList(pageNo, pageSize,tiaojian,cut);
        return new PageInfo<>(pageNo, pageSize, totalCount, list);
    }
}
