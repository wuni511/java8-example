package com.ttihu.java8.exer;

/**
 * @author jiahao
 * @Title: MyFunction2
 * @date 2018/10/12 17:30
 */
@FunctionalInterface
public interface MyFunction2<T, R> {
    public R getValue(T t1,T t2);
}
