package com.any.twofourteenalgorithms.integerList;

import java.util.Arrays;
import java.util.Random;

public class MainInteger {
    private static final int ARRAY_CAPACITY = 10_000;
    private static final int ARRAY_MAX_RANGE_VALUE = 100_000;

    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl();
        Random random = new Random();
        long start = System.currentTimeMillis();
        Integer[] arrayMain = random.ints(ARRAY_CAPACITY, 0, ARRAY_MAX_RANGE_VALUE).boxed().toArray(Integer[]::new);
        Integer[] arrayOne = Arrays.copyOf(arrayMain,ARRAY_CAPACITY);
        integerList.bubbleSort(arrayOne);
        System.out.println("Bubble sort: " + (System.currentTimeMillis() -start));
        Integer[] arrayTwo = Arrays.copyOf(arrayMain,ARRAY_CAPACITY);
        integerList.sortSelection(arrayTwo);
        System.out.println("Selection sort: " + (System.currentTimeMillis() -start));
        Integer[] arrayThree = Arrays.copyOf(arrayMain,ARRAY_CAPACITY);
        integerList.sortInsertion(arrayThree);
        System.out.println("Insertion sort: " + (System.currentTimeMillis() -start));

        integerList.add(3); // 0
        integerList.add(10); // 1
        integerList.add(12); // 2
        integerList.add(2); // 3
        integerList.add(1); // 4
        System.out.println(integerList.binarySearch(12));
    }

}
