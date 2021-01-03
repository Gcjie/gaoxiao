package com.jf.bean;

public class Reward {
    private String jlId;
    private String jlNum;
    private String jlName;
    private String jlUnit;
    private String jlLevel;

    public Reward(){

    }
    public Reward(String jlId, String jlNum, String jlName, String jlUnit, String jlLevel) {
        this.jlId = jlId;
        this.jlNum = jlNum;
        this.jlName = jlName;
        this.jlUnit = jlUnit;
        this.jlLevel = jlLevel;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "jlId='" + jlId + '\'' +
                ", jiNum='" + jlNum + '\'' +
                ", jlName='" + jlName + '\'' +
                ", jlUnit='" + jlUnit + '\'' +
                ", jlLevel='" + jlLevel + '\'' +
                '}';
    }

    public String getJlId() {
        return jlId;
    }

    public void setJlId(String jlId) {
        this.jlId = jlId;
    }

    public String getJlNum() {
        return jlNum;
    }

    public void setJlNum(String jlNum) {
        this.jlNum = jlNum;
    }

    public String getJlName() {
        return jlName;
    }

    public void setJlName(String jlName) {
        this.jlName = jlName;
    }

    public String getJlUnit() {
        return jlUnit;
    }

    public void setJlUnit(String jlUnit) {
        this.jlUnit = jlUnit;
    }

    public String getJlLevel() {
        return jlLevel;
    }

    public void setJlLevel(String jlLevel) {
        this.jlLevel = jlLevel;
    }
}
