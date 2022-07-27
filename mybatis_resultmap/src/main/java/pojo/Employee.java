package pojo;

public class Employee {
    private Integer empId;

    private String empName;

    private  Integer age;

    private String gender;

    private Dept dept;

    public Employee(Integer empId, String empName, Integer age, String gender, Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
    }

    public Employee() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDeptId(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }

}
