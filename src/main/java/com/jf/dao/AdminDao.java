package com.jf.dao;

import com.jf.bean.Admin;
import com.jf.utils.DButils;

import java.sql.ResultSet;

public class AdminDao {
    public static boolean selectAdminNameAndPass(String username, String password) throws Exception {
        String sql = "select * from admin where username='"+username+"' ";
        Admin admin = new Admin();
        ResultSet rs = DButils.selectNameAndPass(sql);
        while(rs.next()) {
            admin.setId(rs.getString("id"));
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
        }
        if(admin.getPassword()!=null)
            if(admin.getPassword().equals(password)){
                return true;
            }
        return false;
    }
    public Integer selectAdminNameCount(String admUsername) {
        String sql = "SELECT COUNT(*) FROM admin WHERE username =?";
        Integer count = DButils.getCount(sql,admUsername);
        return count;
    }
    //保存注册对象
    public boolean saveAdmin(Admin admin) {
        String sql="insert into admin(username,password)" +
                " values(?,?)";
        return DButils.save(sql,admin.getUsername(),admin.getPassword());
    }
}
