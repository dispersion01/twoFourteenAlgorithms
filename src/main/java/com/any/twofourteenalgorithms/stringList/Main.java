package com.any.twofourteenalgorithms.stringList;

import com.any.twofourteenalgorithms.IntegerList.IntegerList;
import com.any.twofourteenalgorithms.IntegerList.IntegerListImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();

        System.out.println(stringList.add("one"));
        System.out.println(stringList.add("two"));
        System.out.println(stringList.add("three"));
        System.out.println(stringList.add("four"));
        System.out.println(stringList.add("five"));
        System.out.println(stringList.add("six"));
        System.out.println(stringList.add("seven"));
        System.out.println(stringList.add("eight"));
        System.out.println(stringList.add("nine"));
        System.out.println(stringList.add("ten"));
        System.out.println("--------------------");
        System.out.println(stringList.add(1,"eleven"));
        System.out.println(stringList.set(2,"twelve"));
        System.out.println(stringList.remove(3));
        System.out.println(stringList.remove("four"));
        System.out.println(stringList.contains("five"));
        System.out.println(stringList.indexOf("six"));
        System.out.println(stringList.get(7));
        System.out.println(stringList.size());
        System.out.println(stringList.isEmpty());
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.clear();
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println("--------------------");

    }

}
