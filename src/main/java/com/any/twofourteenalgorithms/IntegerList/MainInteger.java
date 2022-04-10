package com.any.twofourteenalgorithms.IntegerList;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainInteger {
    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl();
        Integer[] listMain = new Integer[20];
/*        integerList.add(3); // 0
        integerList.add(10); // 1
        integerList.add(12); // 2
        integerList.add(2); // 3
        integerList.add(1); // 4
        System.out.println(integerList.binarySearch(12) == 2);*/


        integerList.randomNumberOfArray(listMain);
        integerList.bubbleSort(listMain);
        System.out.println("Bubble sort: " + integerList.compareSort());
        integerList.sortInsertion(listMain);
        integerList.sortSelection();
    }

}
