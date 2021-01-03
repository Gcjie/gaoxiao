package com.jf.utils;

import com.jf.bean.Penalties;
import com.jf.bean.Reward;
import com.jf.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DButils {

        private static final String DBDRIVER="com.mysql.jdbc.Driver";		//MySQL驱动程序
        private static final String DBURL="jdbc:mysql://localhost:3306/reward-penalties?useSSL=true";		//数据库连接地址
        private static final String DBUSER="root";		//用户名
        private static final String DBPASSWORD="123456";		//密码
        private Connection conn = null;

        public DButils(){
        }
        /**
         * 获取数据库连接
         * @return
         * @throws Exception
         */
        public static Connection getCon()throws Exception{
                // 加载数据库驱动程序
                Class.forName(DBDRIVER);
                return DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        }

        /**
         * 关闭数据库连接
         * @throws Exception
         */
        public static void close(Connection conn, Statement ps, ResultSet rs) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    public static ResultSet selectNameAndPass(String sql) throws Exception {
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DButils.getCon();
        ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }

    public static int update(String sql) throws Exception{
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DButils.getCon();
        ps = connection.prepareStatement(sql);
        return ps.executeUpdate();
    }

    public static List<Student> selectStudent(String sql) throws Exception {
        List<Student> students = new ArrayList<>();
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DButils.getCon();
        ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Student student = new Student();
            student.setNum(rs.getString("num"));
            student.setName(rs.getString("name"));
            student.setSex(rs.getString("sex"));
            student.setMajor(rs.getString("major"));
            student.setStuClass(rs.getString("stuClass"));
            student.setPassword(rs.getString("password"));
            students.add(student);
        }
        return students;
    }

    //查询记录数量
    public static Integer getCount(String sql, Object...args) {
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        Integer count = 0;

        try{
            conn = DButils.getCon();
            ps = conn.prepareStatement(sql);


            if(args!=null && args.length>0){

                for (int i = 0;i< args.length;i++){

                    ps.setObject(i+1,args[i]);
                }
            }
            rs = ps.executeQuery();

            while (rs.next()){

                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(conn, ps, rs);
        }

        return  count;
    }

    //保存对象的方法
    public static boolean save(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = null;

        try {
            conn = DButils.getCon();
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //返回更新的记录数
            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return count!=null&&count>0?true:false;
    }

    //删除的方法
    public static boolean delete(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = null;

        try {
            conn = DButils.getCon();
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //返回更新的记录数
            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return count!=null&&count>0?true:false;
    }

    //更新密码的方法
    public static boolean updatePass(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = null;

        try {
            conn = DButils.getCon();
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //返回更新的记录数
            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return count!=null&&count>0?true:false;
    }

    public static List<Reward> selectReward(String sql) throws Exception {
        List<Reward> rewards = new ArrayList<>();
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DButils.getCon();
        ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Reward reward = new Reward();
            reward.setJlId(rs.getString("jlId"));
            reward.setJlNum(rs.getString("jlNum"));
            reward.setJlName(rs.getString("jlName"));
            reward.setJlUnit(rs.getString("jlUnit"));
            reward.setJlLevel(rs.getString("jlLevel"));
            rewards.add(reward);
        }
        return rewards;
    }

    public static List<Penalties> selectPenalties(String sql) throws Exception {
        List<Penalties> penalties = new ArrayList<>();
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DButils.getCon();
        ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Penalties penalties1 = new Penalties();
            penalties1.setCfId(rs.getString("cfId"));
            penalties1.setCfNum(rs.getString("cfNum"));
            penalties1.setCfName(rs.getString("cfName"));
            penalties1.setCfUnit(rs.getString("cfUnit"));
            penalties1.setCfLevel(rs.getString("cfLevel"));
            penalties.add(penalties1);
        }
        return penalties;
    }
}
