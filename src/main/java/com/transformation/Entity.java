package com.transformation;

public class Entity {

    String parmaID;
    String parmaName;

    public Entity(){
    }
    public Entity(String parmaID, String parmaName) {
        this.parmaID = parmaID;
        this.parmaName = parmaName;
    }



    public String getParmaID() {
        return parmaID;
    }

    public void setParmaID(String parmaID) {
        this.parmaID = parmaID;
    }

    public String getParmaName() {
        return parmaName;
    }

    public void setParmaName(String parmaName) {
        this.parmaName = parmaName;
    }


    @Override
    public String toString() {
        return "Entity{" +
                "parmaID='" + parmaID + '\'' +
                ", parmaName='" + parmaName + '\'' +
                '}';
    }
}
