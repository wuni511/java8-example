package com.ttihu.java8;

import com.ttihu.java8.exer.MyFunction;
import com.ttihu.java8.exer.MyFunction2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author jiahao
 * @Title: TestLambda2
 * @date 2018/10/12 16:10
 */
public class TestLambda2 {
    List<Employee> emps = Arrays.asList(
            new Employee("a赵六", 49, 3945.28),
            new Employee("b张三", 25, 9999.99),
            new Employee("c李四", 12, 3777.89),
            new Employee("d赵六", 49, 5598.99),
            new Employee("e王五", 36, 5669.35)
    );

    /**
     * 调用 Collections.sort() 方法给employee排序，先通过年龄排序，如果年龄相同在通过工资排序
     */
    @Test
    public void test1() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return Double.compare(e1.getSlalary(), e2.getSlalary());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        emps.stream().forEach(System.out::println);
    }

    @Test
    public void test2() {
        for (Employee emp : emps) {
            String s = stringHandler(emp.getName(), x -> x.toUpperCase());
            System.out.println(s);
        }
    }


    //根据需求处理字符串
    public String stringHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    @Test
    public void test3() {
        op(100L, 200L, (l1, l2) -> l1 + l2);
        op(100L, 200L, (l1, l2) -> l1 * l2);
    }
    public void op(long l1, long l2, MyFunction2<Long,Long> mf) {
        System.out.println(mf.getValue(l1,l2));
    }


}
