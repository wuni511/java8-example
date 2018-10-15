package com.ttihu.java8;

/**
 * @author jiahao
 * @Title: Employee
 * @date 2018/10/11 17:24
 */
public class Employee {
    private String name;
    private int age;
    private double slalary;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age, double slalary) {
        this.name = name;
        this.age = age;
        this.slalary = slalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSlalary() {
        return slalary;
    }

    public void setSlalary(double slalary) {
        this.slalary = slalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", slalary=" + slalary +
                '}';
    }
}
