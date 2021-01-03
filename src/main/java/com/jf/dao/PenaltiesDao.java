package com.jf.dao;

import com.jf.bean.Penalties;
import com.jf.utils.DButils;

import java.util.List;

public class PenaltiesDao {
    public static List<Penalties> selectNum(String num) throws Exception{
        String sql = "select * from penalties where cfNum='"+num+"' ";
        List<Penalties> penalties = DButils.selectPenalties(sql);
        return penalties;
    }

    public static List<Penalties> selectAllPenalties() throws Exception{
        String sql= "select * from penalties";
        List<Penalties> penalties = DButils.selectPenalties(sql);
        return penalties;
    }

    public boolean savePenalties(Penalties penalties) {
        String sql="insert into penalties(cfId,cfNum,cfName,cfUnit,cfLevel)" + " values(?,?,?,?,?)";
        return DButils.save(sql,penalties.getCfId(),penalties.getCfNum(),penalties.getCfName(),penalties.getCfUnit(),penalties.getCfLevel());
    }

    public static boolean updatePenalties(String cfId,String cfNum,String cfName,String cfUnit,String cfLevel) throws Exception{
        String sql = "update penalties set cfNum='"+cfNum+"',cfName='"+cfName+"',cfUnit='"+cfUnit+"',cfLevel='"+cfLevel+"' " +
                "where cfId='"+cfId+"'";
        DButils.update(sql);
        return true;
    }

    public boolean delPenalties(String cfId) {
        String sql="delete from penalties where cfId=?";
        return DButils.delete(sql,cfId);
    }
}
