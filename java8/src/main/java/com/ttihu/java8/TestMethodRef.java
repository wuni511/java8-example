package com.ttihu.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用：若Lambda体中的内容已经有方法实现了，我们可以用“方法引用”
 *          （可以理解为方法引用是Lambda表达式的另外一种表现）
 * 主要有三种语法格式：
 *      对象::实例方法名
 *      类::静态方法名
 *      类::实例方法名
 * 构造器引用:
 *      格式：
 *      ClassName::new  需要调用的构造器的参数列表与函数式接口中抽象方法的参数列表保持一致
 * 数组引用
 *      Type::new
 */
public class TestMethodRef {

    //数组引用
    @Test
    public void test6() {
        Function<Integer, String[]> fc = (x) -> new String[x];
        String[] strArr = fc.apply(10);
        System.out.println(strArr.length);
        Function<Integer, String[]> fc1 = String[]::new;
        String[] strs = fc1.apply(20);
        System.out.println(strs.length);
    }

    //构造器引用
    @Test
    public void test5() {
        Supplier<Employee> sp = () -> new Employee();
        //调用的是无参构造器
        Supplier<Employee> sp1 = Employee::new;

        Function<String, Employee> fc = (x) -> new Employee(x);
        Employee emp = fc.apply("王八");
        System.out.println(emp);

        BiFunction<String, Integer, Employee> bf = (x, y) -> new Employee();

    }

    //类::实例方法名
    @Test
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        //当lambda参数列表中的第一个参数作为lambda方法体中方法的调用者，
        // 第二个参数做为方法的要调用的方法的参时可以使用  类::实例方法名
        BiPredicate<String, String> bi1 = String::equals;
        boolean flag = bi1.test("a", "a");
        System.out.println(flag);
    }

    //类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com1 = Integer::compare;
        int i = com1.compare(1000, 2000);
        System.out.println(i);
    }


    //对象::实例方法名
    @Test
    public void test1() {
        String str = "你看看";
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept(str);
        Consumer<String> con1 = System.out::println;
        con1.accept("迷茫");
    }

    @Test
    public void test2() {
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String s = sup.get();
        System.out.println(s);

        Supplier<Integer> sup1 = emp::getAge;
        Integer integer = sup1.get();
        System.out.println(integer);

    }
}
