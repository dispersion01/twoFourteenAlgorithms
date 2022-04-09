package com.any.twofourteenalgorithms.IntegerList;

import java.util.List;

public class MainInteger {
    public static void main(String[] args) {
        IntegerListImpl integerList = new IntegerListImpl();
        List<Integer> listMain = List.of(integerList.randomNumberOfArray());
        List<Integer> listOne = List.copyOf(listMain);
        System.out.println(integerList.bubbleSort());




        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(integerList.add(11));
        System.out.println(integerList.add(12));
        System.out.println(integerList.add(13));
        System.out.println(integerList.add(14));

        System.out.println(integerList.add(1,15));
        System.out.println(integerList.set(2,16));





    }

}
