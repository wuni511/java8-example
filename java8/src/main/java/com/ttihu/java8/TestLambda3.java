package com.ttihu.java8;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置4大核心函数式接口
 *   Consumer<T> :消费型接口 没有返回值
 *       void  accept(T t);
 *   Supplier<T> :供给型接口
 *      T get();
 *   Function<T,R> :函数型接口 T 入参类型 R 返回值类型
 *      R apply(T t);
 *   Predicate<T> :断言型接口
 *      boolean test(T t);
 */
public class TestLambda3 {

    //Consumer<T> 消费型接口
    @Test
    public void test1() {
        happy(1000, (m) -> System.out.println("今天出去玩花了" + m + "大洋，看人妖表演"));
    }

    //出去happy
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //Supplier<T> 供给型接口
    @Test
    public void test2() {
        List<Integer> numList = getNumList(11, () -> (int) (Math.random() * 100));
        for (int i = 0; i < numList.size(); i++) {
            System.out.println(i + 1 + "-->" + numList.get(i));
        }
    }

    //产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            numList.add(n);
        }
        return numList;
    }

    //Function<T,R> 函数型接口
    @Test
    public void test3() {
        String str = "我是一个潜力股";
        String s = strHandler(str, (p) -> str.replace("一个", "很牛逼的"));
        System.out.println(s);
    }

    //用于处理字符串
    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    //Predicate<T> 断言型接口
    @Test
    public void test4(){
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> listNum = listFilter(numList, (num) -> 0 == num % 2);
        System.out.println(listNum);
    }

    //处理集合中的值
    public List<Integer> listFilter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> numList = new ArrayList<>();
        for (Integer num : list) {
            if (predicate.test(num)) {
                numList.add(num);
            }
        }
        return numList;
    }
}
