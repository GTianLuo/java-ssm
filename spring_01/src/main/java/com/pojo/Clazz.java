package com.pojo;

public class Clazz {

    private Integer classID;

    private String className;

    public Clazz(Integer classID, String className) {
        this.classID = classID;
        this.className = className;
    }

    public Clazz() {
    }

    public Integer getClassID() {
        return classID;
    }

    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "classID=" + classID +
                ", className='" + className + '\'' +
                '}';
    }
}
