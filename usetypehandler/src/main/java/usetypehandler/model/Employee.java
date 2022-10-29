package usetypehandler.model;

import java.util.Date;

public class Employee {
    private Long id;
    private String name;
    private Date birthday;
    private Gender gender;
    private String mobile;

    public Employee(Long id, String name, Date birthday, Gender gender, String mobile) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.mobile = mobile;
    }

    public Employee(String name, Date birthday, Gender gender, String mobile) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.mobile = mobile;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
