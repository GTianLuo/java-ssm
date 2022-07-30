package com.pojo;

public class User {
    private  Integer useName;

    private  String password;


    public User(Integer useName, String password) {
        this.useName = useName;
        this.password = password;
    }

    public User() {
        System.out.println("调用无参构造实例化了对象!!!");
    }


    public Integer getUseName() {
        System.out.println("为对象的属性赋值！！！");
        return useName;
    }

    public void setUseName(Integer useName) {
        this.useName = useName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void initMethod(){
        System.out.println("对象初始化！");
    }
    public void destroyMethod(){
        System.out.println("对象销毁！");
    }

    @Override
    public String toString() {
        return "User{" +
                "useName=" + useName +
                ", password='" + password + '\'' +
                '}';
    }
}
