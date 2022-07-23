package pojo;

public class User {
    private int id;
    private String usrname;
    private String password;
    private Integer age;
    private String gender;
    private String email;

    public User(int id, String usrname, String password, Integer age, String gender, String email) {
        this.id = id;
        this.usrname = usrname;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUsrname() {
        return usrname;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
