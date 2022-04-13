package com.any.twofourteenalgorithms.integerList;

import java.util.Arrays;
import java.util.Random;

public class MainInteger {
    private static final int ARRAY_CAPACITY = 10_000;
    private static final int ARRAY_MAX_RANGE_VALUE = 100_000;

    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl();
        System.out.println((integerList.add(3))); // 0
        System.out.println(integerList.add(10)); // 1
        System.out.println(integerList.add(12)); // 2
        System.out.println(integerList.add(2)); // 3
        System.out.println(integerList.add(1)); // 4

        System.out.println("Получаем элемент по индексу " + integerList.get(0));
        System.out.println("Добавлен эелемент по индексу " + integerList.add(0, 4));
        System.out.println("Получаем элемент по индексу после добавления по индексу " + integerList.get(0));
        System.out.println("Получаем элемент по индексу до set по индексу " + integerList.get(2));
        System.out.println("Устанавливаем элемент по индексу " + integerList.set(2, 25));
        System.out.println("Получаем элемент по индексу после set по индексу " + integerList.get(2));
        System.out.println("Ищем элемент. Индекс элемента " + integerList.indexOf(12));
        System.out.println("Получаем элемент по индексу до удаления " + integerList.get(1));
        System.out.println("Удаляем элемент " + integerList.remove(1));
        System.out.println("Получаем элемент по индексу после удаления " + integerList.get(1));
        System.out.println("Поиск элемента с конца " + integerList.lastIndexOf(12));
        System.out.println("Количество элементов " + integerList.size());
        System.out.println("Есть ли элементы в списке? " + integerList.isEmpty());
        Random random = new Random();
        long start = System.currentTimeMillis();
        Integer[] arrayMain = random.ints(ARRAY_CAPACITY, 0, ARRAY_MAX_RANGE_VALUE).boxed().toArray(Integer[]::new);
        Integer[] arrayOne = Arrays.copyOf(arrayMain, ARRAY_CAPACITY);
        integerList.bubbleSort(arrayOne);
        System.out.println("Bubble sort: " + (System.currentTimeMillis() - start));
        Integer[] arrayTwo = Arrays.copyOf(arrayMain, ARRAY_CAPACITY);
        integerList.sortSelection(arrayTwo);
        System.out.println("Selection sort: " + (System.currentTimeMillis() - start));
        Integer[] arrayThree = Arrays.copyOf(arrayMain, ARRAY_CAPACITY);
        integerList.sortInsertion(arrayThree);
        System.out.println("Insertion sort: " + (System.currentTimeMillis() - start));
        System.out.println("Найден ли элемент бинарным поиском? " + integerList.binarySearch(3));


    }

}
