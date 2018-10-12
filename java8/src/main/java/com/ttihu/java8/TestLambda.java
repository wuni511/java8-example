package com.ttihu.java8;

import org.junit.Test;

import java.util.*;

/**
 * @author jiahao
 * @Title: TestLambda
 * @date 2018/10/11 15:48
 */
public class TestLambda {
    /**
     * 匿名内部类
     */
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return Integer.compare(integer, t1);
            }
        };
        TreeSet treeSet = new TreeSet(com);
        System.out.println(treeSet);
    }

    /**
     * lambda
     */
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(com);
        System.out.println(treeSet);
    }

    List<Employee> employess = Arrays.asList(
            new Employee("张三", 12, 9999.99),
            new Employee("李四", 25, 3777.89),
            new Employee("王五", 36, 5669.35),
            new Employee("赵六", 49, 3945.28)
    );

    //需求，获取当前公司员工年龄大于35的员工
    @Test
    public void test3(){
        List<Employee> employees = filterEmployees(employess);
        System.out.println(employees);
    }

    public List<Employee> filterEmployees(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() > 35) {
                emps.add(employee);
            }
        }
        return emps;
    }

    //需求；获取当前公司员工工资大于3500的员工
    public List<Employee> filterEmployees1(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSlalary() >= 3500) {
                emps.add(employee);
            }
        }
        return emps;
    }




}
