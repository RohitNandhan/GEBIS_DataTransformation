package com.mapping.gmail.Refoctored.Bean;

import java.util.List;

public class ParmaExcel implements Comparable<ParmaExcel>{
    private Integer parmaID;
    private String parmaname;
    private List<String> emailID;

    public ParmaExcel(){}

    public ParmaExcel(Integer parmaID, String parmaname, List<String> emailID) {
        this.parmaID = parmaID;
        this.parmaname = parmaname;
        this.emailID = emailID;
    }

    public Integer getParmaID() {
        return parmaID;
    }

    public void setParmaID(Integer parmaID) {
        this.parmaID = parmaID;
    }

    public String getParmaname() {
        return parmaname;
    }

    public void setParmaname(String parmaname) {
        this.parmaname = parmaname;
    }

    public List<String> getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID.add(emailID);
    }

    @Override
    public String toString() {
        return "Excel{" +
                "parmaID=" + parmaID +
                ", parmaname='" + parmaname + '\'' +
                ", emailID=" + emailID +
                '}';
    }

    @Override
    public int compareTo(ParmaExcel o) {
        return this.getParmaname().compareTo(o.getParmaname());
    }
}
