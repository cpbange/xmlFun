package com.example.xmlpar.demo;

public class User {

    private String firstName;
    private String lastName;

    private Integer age;
    private String gender;
    private Integer userId;

    public User() {
        this.firstName="";
        this.lastName="";
        this.age = 0;
        this.gender="";
        this.userId = (int)Math.random();
    }

    public User(String firstName, String lastName, Integer age, String gender, Integer userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", userId=" + userId +
                '}';
    }
}
