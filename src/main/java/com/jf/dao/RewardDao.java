package com.jf.dao;

import com.jf.bean.Reward;
import com.jf.utils.DButils;

import java.util.List;

public class RewardDao {
    public static List<Reward> selectNum(String num) throws Exception{
        String sql = "select * from reward where jlNum='"+num+"' ";
        List<Reward> rewards = DButils.selectReward(sql);
        return rewards;
    }

    public static List<Reward> selectAllReward() throws Exception{
        String sql= "select * from reward";
        List<Reward> rewards = DButils.selectReward(sql);
        return rewards;
    }

    public boolean saveReward(Reward reward) {
        String sql="insert into reward(jlId,jlNum,jlName,jlUnit,jlLevel)" + " values(?,?,?,?,?)";
        return DButils.save(sql,reward.getJlId(),reward.getJlNum(),reward.getJlName(),reward.getJlUnit(),reward.getJlLevel());
    }

    public static boolean updateReward(String jlId,String jlNum,String jlName,String jlUnit,String jlLevel) throws Exception{
        String sql = "update reward set jlNum='"+jlNum+"',jlName='"+jlName+"',jlUnit='"+jlUnit+"',jlLevel='"+jlLevel+"' " +
                "where jlId='"+jlId+"'";
        DButils.update(sql);
        return true;
    }

    public boolean delReward(String jlId) {
        String sql="delete from reward where jlId=?";
        return DButils.delete(sql,jlId);
    }
}
