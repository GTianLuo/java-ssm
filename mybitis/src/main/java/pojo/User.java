package pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String email;

    public User(int id, String usrname, String password, Integer age, String gender, String email) {
        this.id = id;
        this.username = usrname;
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
        return username;
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
        this.username = usrname;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usrname='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
