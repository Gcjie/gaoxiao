package com.jf.dao;

import com.jf.bean.Student;
import com.jf.utils.DButils;

import java.sql.ResultSet;
import java.util.List;

public class StudentDao {
    //保存
    public boolean saveStudent(Student student) {
        String sql="insert into student(num,name,sex,major,stuClass,password)" +
                " values(?,?,?,?,?,?)";
        return DButils.save(sql,student.getNum(),student.getName(),student.getSex(),student.getMajor(),student.getStuClass()
        ,student.getPassword());
    }

public static Student selectStudentNumAndPass(String num, String password) throws Exception {
    String sql = "select * from student where num='"+num+"' ";
    Student student = new Student();
    ResultSet rs = DButils.selectNameAndPass(sql);
    while(rs.next()) {
        student.setNum(rs.getString("num"));
        student.setName(rs.getString("name"));
        student.setSex(rs.getString("sex"));
        student.setMajor(rs.getString("major"));
        student.setStuClass(rs.getString("stuClass"));
        student.setPassword(rs.getString("password"));
    }
    if (student.getPassword()!=null)
        if(student.getPassword().equals(password)){
            return student;
        }
    return null;
}
public static List<Student> selectStudent() throws Exception {
    String sql = "select * from student";
    List<Student> students = DButils.selectStudent(sql);
    return students;
}
    public Integer selectStu(String num) {
        String sql = "SELECT COUNT(*) FROM student WHERE num =?";
        Integer count = DButils.getCount(sql,num);
        return count;
    }

    //删除学生
    public boolean delStudent(String num) {
        String sql="delete from student where num=?";
        return DButils.delete(sql,num);
    }

    public static List<Student> selectNum(String num) throws Exception{
        String sql = "select * from student where num='"+num+"'";
        List<Student> students = DButils.selectStudent(sql);
        return students;
    }

    public static boolean updatePass(String newPass,String num) throws Exception{
        String sql = "update student set password=? where num=?";
        return DButils.updatePass(sql,newPass,num);
    }

    public static boolean updateStudent(String num,String name,String sex,String major,String stuClass,String password) throws Exception{
        String sql = "update student set name='"+name+"',sex='"+sex+"',major='"+major+"',stuClass='"+stuClass+"',password='"+password+"' where num='"+num+"'";
        DButils.update(sql);
        return true;
    }
}
