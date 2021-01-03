package com.jf.bean;

public class Penalties {
    private String cfId;
    private String cfNum;
    private String cfName;
    private String cfUnit;
    private String cfLevel;

    public Penalties(){

    }

    public Penalties(String cfId, String cfNum, String cfName, String cfUnit, String cfLevel) {
        this.cfId = cfId;
        this.cfNum = cfNum;
        this.cfName = cfName;
        this.cfUnit = cfUnit;
        this.cfLevel = cfLevel;
    }

    @Override
    public String toString() {
        return "Penalties{" +
                "cfId='" + cfId + '\'' +
                ", cfNum='" + cfNum + '\'' +
                ", cfName='" + cfName + '\'' +
                ", cfUnit='" + cfUnit + '\'' +
                ", cfLevel='" + cfLevel + '\'' +
                '}';
    }

    public String getCfId() {
        return cfId;
    }

    public void setCfId(String cfId) {
        this.cfId = cfId;
    }

    public String getCfNum() {
        return cfNum;
    }

    public void setCfNum(String cfNum) {
        this.cfNum = cfNum;
    }

    public String getCfUnit() {
        return cfUnit;
    }

    public String getCfName() {
        return cfName;
    }

    public void setCfName(String cfName) {
        this.cfName = cfName;
    }

    public void setCfUnit(String cfUnit) {
        this.cfUnit = cfUnit;
    }

    public String getCfLevel() {
        return cfLevel;
    }

    public void setCfLevel(String cfLevel) {
        this.cfLevel = cfLevel;
    }
}
