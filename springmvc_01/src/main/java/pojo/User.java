package pojo;

public class User {

    private  String userName;

    private String password;

    private Integer age;

    public User(String userName, String password, Integer age) {
        System.out.println("有参构造！！！");
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    public User() {
        System.out.println("无参构造！！！");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setter方法赋值！！！");
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
