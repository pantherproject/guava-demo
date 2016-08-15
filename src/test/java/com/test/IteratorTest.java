package com.test;

import com.google.common.base.Predicate;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 遍历集合的耗时
 * Created by panther on 16-8-6.
 */
public class IteratorTest {
    public static void main(String[] args) {

        List<Integer> integerList = Lists.newArrayList();
        for (int i = 0; i < 1000; ++i) {
            integerList.add(i);
        }

        Stopwatch stopwatch1 = Stopwatch.createStarted();
        List<Integer> resultList1 = Lists.newArrayList(Iterables.filter(integerList, new Predicate<Integer>() {
            public boolean apply(Integer input) {
                return input > 5;
            }
        }));
//        System.out.println(resultList1);
        System.out.println(stopwatch1.elapsed(TimeUnit.MILLISECONDS));

        Stopwatch stopwatch = Stopwatch.createStarted();
        List<Integer> resultList = Lists.newArrayList();
        for (Integer i : integerList) {
            if (i > 5) {
                resultList.add(i);
            }
        }
//        System.out.println(resultList);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));


    }
}
