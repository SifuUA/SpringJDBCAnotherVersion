package com.okres.springjdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

public class QueryForListReturnListDao  extends JdbcDaoSupport{

    @Autowired
    public QueryForListReturnListDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<String> getDeptNames(){
        String sql = "Select d.dept_name from Department d";

        // queryForList(String sql, Class<T> elementType)
        List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);

        return list;
    }

    public List<String> getDeptNames(String searchName){
        String sql = "Select d.dept_name from Department d"
                + "where d.dept_name like ?";

        // queryForList(String sql, Class<T> elementType, Object... args)
        List<String> list = this.getJdbcTemplate().queryForList(sql, String.class,
                "%" + searchName + "%");
        return list;
    }
}
